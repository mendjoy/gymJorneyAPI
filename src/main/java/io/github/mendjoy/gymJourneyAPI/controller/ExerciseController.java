package io.github.mendjoy.gymJourneyAPI.controller;

import io.github.mendjoy.gymJourneyAPI.dto.exercise.ExerciseDTO;
import io.github.mendjoy.gymJourneyAPI.dto.response.ResponseApiDTO;
import io.github.mendjoy.gymJourneyAPI.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
