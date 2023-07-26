package dev.moreira.Fithub.domain.repository;

import dev.moreira.Fithub.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
    User findByEmailAndPassword(String email, String password);
    User findByUsernameAndPassword(String username, String password);
}
