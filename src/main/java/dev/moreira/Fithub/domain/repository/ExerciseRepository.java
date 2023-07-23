package dev.moreira.Fithub.domain.repository;

import dev.moreira.Fithub.domain.exercise.DetailsExerciseDto;
import dev.moreira.Fithub.domain.exercise.Exercise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, String> {
    Page<Exercise> findAllByWorkoutId(String workoutId, Pageable pageable);
}
