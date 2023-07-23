package dev.moreira.Fithub.controller;

import dev.moreira.Fithub.domain.exercise.DetailsExerciseDto;
import dev.moreira.Fithub.domain.exercise.Exercise;
import dev.moreira.Fithub.domain.exercise.RegisterExerciseDto;
import dev.moreira.Fithub.domain.exercise.UpdateExerciseDto;
import dev.moreira.Fithub.domain.repository.ExerciseRepository;
import dev.moreira.Fithub.domain.repository.WorkoutRepository;
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
@RequestMapping("/exercises")
public class ExerciseController {
    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private WorkoutRepository workoutRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetailsExerciseDto> register(@RequestBody @Valid RegisterExerciseDto data, UriComponentsBuilder uriBuilder) {
        var workout = workoutRepository.getReferenceById(data.workoutId());
        var exercise = new Exercise(workout, data);
        var uri = uriBuilder.path("/exercises/{id}").buildAndExpand(exercise.getId()).toUri();
        exerciseRepository.save(exercise);
        return ResponseEntity.created(uri).body(new DetailsExerciseDto(exercise));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailsExerciseDto> detail(@PathVariable String id) {
        var exercise = exerciseRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetailsExerciseDto(exercise));
    }

    @GetMapping("/list/{workoutId}")
    public ResponseEntity<Page<DetailsExerciseDto>> listExercisesByWorkoutId(@PathVariable String workoutId, @PageableDefault Pageable pageable) {
        Page<DetailsExerciseDto> exercise = exerciseRepository.findAllByWorkoutId(workoutId, pageable).map(DetailsExerciseDto::new);
        return ResponseEntity.ok(exercise);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity update(@PathVariable String id,@RequestBody UpdateExerciseDto data) {
        var exercise = exerciseRepository.getReferenceById(id);
        exercise.update(data);
        return ResponseEntity.ok().build();
    }
}
