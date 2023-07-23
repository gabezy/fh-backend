package dev.moreira.Fithub.domain.exercise;

import dev.moreira.Fithub.domain.workout.Workout;
import dev.moreira.Fithub.util.StringValidator;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Exercise")
@Table(name = "exercises")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(of = "id")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Workout workout;

    private String name;
    private Integer weight;
    @Column(name = "repetitions")
    private Integer reps;
    private Integer sets;
    private String notes = null;

    public Exercise(Workout workout,RegisterExerciseDto data) {
        this.workout = workout;
        this.name = data.name();
        this.weight = data.weight();
        this.reps = data.reps();
        this.sets = data.sets();
        if (!StringValidator.stringIsEmptyOrNull(data.notes())) {
            this.notes = data.notes();
        }
    }

    public void update(UpdateExerciseDto data) {
        if (!StringValidator.stringIsEmptyOrNull(data.name())) {
            this.name = data.name();
        }
        if (!StringValidator.stringIsEmptyOrNull(data.notes())) {
            this.notes = data.notes();
        }
        if (data.weight() != null && data.weight() > 0) {
            this.weight = data.weight();
        }
        if (data.reps() != null && data.reps() > 0) {
            this.reps = data.reps();
        }
        if (data.sets() != null && data.sets() > 0) {
            this.sets = data.sets();
        }
    }

}
