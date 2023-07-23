package dev.moreira.Fithub.domain.user;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "Users")
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String username;
    private String password;
    private String email;
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "updated_at")
    private LocalDateTime updatedAt = null;

    //TODO: Implement Hash on the password

    public User(CreateUserDto data) {
        this.username = data.username();
        this.password = data.password();
        this.email = data.email();
    }

    public void updateUsername(String username) {
        this.setUsername(username);
    }

}
