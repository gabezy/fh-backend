package dev.moreira.Fithub.controller;

import dev.moreira.Fithub.domain.repository.UserRepository;
import dev.moreira.Fithub.domain.service.UserService;
import dev.moreira.Fithub.domain.user.*;
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
    private UserRepository userRepository;

    @Autowired
    private UserService service;

    @PostMapping
    @Transactional
    public ResponseEntity<DetailsUserDto> create(@RequestBody @Valid CreateUserDto data, UriComponentsBuilder uriBuilder) {
        User user = new User(data);
        userRepository.save(user);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetailsUserDto(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailsUserDto> get(@PathVariable String id) {
        var user = userRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetailsUserDto(user));
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginUserDto data) {
        var user = userRepository.findByEmailAndPassword(data.email(), data.password());
        if (user == null) {
            throw new RuntimeException("User doesn't exist");
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    //TODO: implement the validation and update for new email and password
    public ResponseEntity updateUsername(@PathVariable String id, @RequestBody @Valid UpdateUserDto dataToUpdate) {
        var user = userRepository.getReferenceById(id);
        if (service.usernameAlreadyExistsOrInvalid(dataToUpdate.newUsername())) {
            throw new RuntimeException("Username Already Exists");
        }
        user.updateUsername(dataToUpdate.newUsername());
        return ResponseEntity.ok().build();
    }
}