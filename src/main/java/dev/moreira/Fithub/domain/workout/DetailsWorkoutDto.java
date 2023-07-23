package dev.moreira.Fithub.domain.workout;

import java.time.LocalDateTime;

public record DetailsWorkoutDto(
        String name,
        String userId,
        LocalDateTime createdAt
) {
    public DetailsWorkoutDto(Workout workout) {
        this(workout.getName(), workout.getUser().getId(), workout.getCreatedAt());
    }

}
