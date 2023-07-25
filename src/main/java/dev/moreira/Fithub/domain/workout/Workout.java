package dev.moreira.Fithub.domain.workout;

import dev.moreira.Fithub.domain.user.User;
import dev.moreira.Fithub.util.StringValidator;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "Workout")
@Table(name = "workouts")
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
    @Column(name = "workout_date")
    private LocalDate workoutDate;
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "updated_at")
    private LocalDateTime updatedAt = null;

    public Workout(User user, RegisterWorkoutDto data) {
        this.user = user;
        this.name = data.name();
        this.workoutDate = LocalDate.parse(data.workoutDate());
    }

    public void update(UpdateWorkoutDto data) {
        if (!StringValidator.stringIsEmptyOrNull(data.name())) {
            this.name = data.name();
            this.setUpdatedAt(LocalDateTime.now());
        }
    }
}
