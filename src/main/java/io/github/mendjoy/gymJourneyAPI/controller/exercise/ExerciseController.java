package io.github.mendjoy.gymJourneyAPI.controller.exercise;

import io.github.mendjoy.gymJourneyAPI.dto.exercise.ExerciseDTO;
import io.github.mendjoy.gymJourneyAPI.dto.response.ResponseApiDTO;
import io.github.mendjoy.gymJourneyAPI.repository.ExerciseRepository;
import io.github.mendjoy.gymJourneyAPI.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @PostMapping
    public ResponseEntity<ResponseApiDTO> register(@RequestBody ExerciseDTO exerciseDTO){
        ExerciseDTO newExercise = exerciseService.register(exerciseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseApiDTO.success(HttpStatus.CREATED, newExercise));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseApiDTO> getExerciseById(@PathVariable Integer id){
        ExerciseDTO exerciseDTO = exerciseService.getExerciseById(id);
        return ResponseEntity.ok(ResponseApiDTO.success(HttpStatus.OK, exerciseDTO));
    }

    @GetMapping
    public ResponseEntity<ResponseApiDTO> getAllExercises( @RequestParam(defaultValue = "0") int page,  @RequestParam(defaultValue = "10") int size){
        Page<ExerciseDTO> exerciseDTOS = exerciseService.getAllExercises(page, size);
        return ResponseEntity.ok(ResponseApiDTO.success(HttpStatus.OK, exerciseDTOS));
    }
}
