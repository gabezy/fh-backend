package dev.moreira.Fithub.domain.workout;

import java.time.LocalDate;

public record ListWorkoutDto(
        String id,
        String name,
        LocalDate date

) {
    public ListWorkoutDto(Workout data) {
        this(data.getId(),data.getName(), data.getWorkoutDate());
    }
}
