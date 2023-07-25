package dev.moreira.Fithub.domain.exercise;

public record DetailsExerciseDto(String id,String name, Integer weight, Integer reps, Integer sets, String notes) {

    public DetailsExerciseDto(Exercise exercise) {
        this(exercise.getId(), exercise.getName(), exercise.getWeight(), exercise.getReps(), exercise.getSets(), exercise.getNotes());
    }
}

