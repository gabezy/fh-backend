package dev.moreira.Fithub.domain.exercise;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterExerciseDto(
        @NotBlank
        String name,
        @NotBlank
        String workoutId,
        @NotNull
        Integer weight,
        @NotNull
        Integer reps,
        @NotNull
        Integer sets,
        String notes
) {
}
