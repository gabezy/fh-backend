package dev.moreira.Fithub.domain.workout;

public record ListWorkoutDto(
        String name,
        String userId
) {
    public ListWorkoutDto(Workout data) {
        this(data.getName(), data.getUser().getId());
    }
}
