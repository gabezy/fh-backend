package dev.moreira.Fithub.domain.service;

import dev.moreira.Fithub.domain.repository.UserRepository;
import dev.moreira.Fithub.util.StringValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public boolean usernameAlreadyExistsOrInvalid(String username) {
        return repository.findByUsername(username) != null || StringValidator.stringIsEmptyOrNull(username);
    }
}
