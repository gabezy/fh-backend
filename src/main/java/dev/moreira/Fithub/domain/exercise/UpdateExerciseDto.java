package dev.moreira.Fithub.domain.exercise;

public record UpdateExerciseDto(
        String name,
        Integer weight,
        Integer reps,
        Integer sets,
        String notes
) {
}
