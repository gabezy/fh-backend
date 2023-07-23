package dev.moreira.Fithub.domain.repository;

import dev.moreira.Fithub.domain.user.User;
import dev.moreira.Fithub.domain.workout.Workout;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout, String> {
    Page<Workout> findAllByUserId(String userId, Pageable pageable);
}
