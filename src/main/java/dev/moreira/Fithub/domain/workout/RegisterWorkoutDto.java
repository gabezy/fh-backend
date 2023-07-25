package dev.moreira.Fithub.domain.workout;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record RegisterWorkoutDto(
        @NotBlank
        String name,
        @NotBlank
        String userId,
        @NotBlank
        String workoutDate
) {
}
