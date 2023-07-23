package dev.moreira.Fithub.domain.exercise;

public record DetailsExerciseDto(String name, Integer weight, Integer reps, Integer sets, String notes) {

    public DetailsExerciseDto(Exercise exercise) {
        this(exercise.getName(), exercise.getWeight(), exercise.getReps(), exercise.getSets(), exercise.getNotes());
    }
}

