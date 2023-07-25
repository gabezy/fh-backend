package dev.moreira.Fithub.controller;

import dev.moreira.Fithub.domain.repository.WorkoutRepository;
import dev.moreira.Fithub.domain.repository.UserRepository;
import dev.moreira.Fithub.domain.workout.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {
    @Autowired
    private WorkoutRepository workoutRepository;
    @Autowired
    private UserRepository userRepository;
    //TODO: implement validation (check if workout, user exists and return a custom exception if not)

    @PostMapping
    @Transactional
    public ResponseEntity<DetailsWorkoutDto> register(@RequestBody @Valid RegisterWorkoutDto data, UriComponentsBuilder uriBuilder) {
        var user = userRepository.getReferenceById(data.userId());
        var workout = new Workout(user, data);
        workoutRepository.save(workout);
        var uri = uriBuilder.path("/workouts/{id}").buildAndExpand(workout.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetailsWorkoutDto(workout));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Page<ListWorkoutDto>> listWorkoutsByUserId(@PathVariable String userId, @PageableDefault(sort = {"createdAt"}) Pageable pageable) {
        Page<ListWorkoutDto> workouts = workoutRepository.findAllByUserId(userId, pageable).map(ListWorkoutDto::new);
        return ResponseEntity.ok(workouts);
    }

    @GetMapping("/detail/{workoutId}")
    public ResponseEntity<DetailsWorkoutDto> detailWorkout(@PathVariable String workoutId) {
        var workout = workoutRepository.getReferenceById(workoutId);
        return ResponseEntity.ok(new DetailsWorkoutDto(workout));
    }

    @PutMapping("/{workoutId}")
    @Transactional
    public ResponseEntity updateWorkout(@PathVariable String workoutId, @RequestBody UpdateWorkoutDto data) {
        var workout = workoutRepository.getReferenceById(workoutId);
        workout.update(data);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{workoutId}")
    @Transactional
    public ResponseEntity deleteWorkout(@PathVariable String workoutId) {
        workoutRepository.deleteById(workoutId);
        return ResponseEntity.noContent().build();
    }
}
