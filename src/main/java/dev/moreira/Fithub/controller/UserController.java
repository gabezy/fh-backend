package dev.moreira.Fithub.controller;

import dev.moreira.Fithub.domain.repository.UserRepository;
import dev.moreira.Fithub.domain.service.UserService;
import dev.moreira.Fithub.domain.user.CreateUserDto;
import dev.moreira.Fithub.domain.user.DetailsUser;
import dev.moreira.Fithub.domain.user.UpdateUser;
import dev.moreira.Fithub.domain.user.User;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserService service;

    @PostMapping
    @Transactional
    public ResponseEntity<DetailsUser> create(@RequestBody @Valid CreateUserDto data, UriComponentsBuilder uriBuilder) {
        User user = new User(data);
        repository.save(user);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetailsUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailsUser> get(@PathVariable String id) {
        var user = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetailsUser(user));
    }

    @PutMapping("/{id}")
    @Transactional
    //TODO: implement the validation and update for new email and password
    public ResponseEntity updateUsername(@PathVariable String id, @RequestBody @Valid UpdateUser dataToUpdate) {
        var user = repository.getReferenceById(id);
        if (service.usernameAlreadyExistsOrInvalid(dataToUpdate.newUsername())) {
            throw new RuntimeException("Username Already Exists");
        }
        user.updateUsername(dataToUpdate.newUsername());
        return ResponseEntity.ok().build();
    }
}