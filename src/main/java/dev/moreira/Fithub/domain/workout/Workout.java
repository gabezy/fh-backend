package dev.moreira.Fithub.domain.workout;

import dev.moreira.Fithub.domain.user.User;
import dev.moreira.Fithub.util.StringValidator;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "Workout")
@Table(name = "workout")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(of = "id")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String name;
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "updated_at")
    private LocalDateTime updatedAt = null;

    public Workout(User user, String name) {
        this.user = user;
        this.name = name;
    }

    public void update(UpdateWorkoutDto data) {
        if (!StringValidator.stringIsEmptyOrNull(data.name())) {
            this.name = data.name();
            this.setUpdatedAt(LocalDateTime.now());
        }
    }
}
