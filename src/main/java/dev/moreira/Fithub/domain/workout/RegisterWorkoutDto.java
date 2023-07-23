package dev.moreira.Fithub.domain.workout;

import jakarta.validation.constraints.NotBlank;

public record RegisterWorkoutDto(
        @NotBlank
        String name,
        @NotBlank
        String userId
) {
}
