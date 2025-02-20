package io.github.mendjoy.gymJourneyAPI.service;

import io.github.mendjoy.gymJourneyAPI.dto.exercise.ExerciseDTO;
import io.github.mendjoy.gymJourneyAPI.entity.exercise.Exercise;
import io.github.mendjoy.gymJourneyAPI.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    public ExerciseDTO register(ExerciseDTO exerciseDTO){
        if(exerciseRepository.existsByName(exerciseDTO.getName())){
            throw new RuntimeException("Exercicio já cadastrado!");
        }

        Exercise newExercise = new Exercise(exerciseDTO.getName(),
                                            exerciseDTO.getDescription(),
                                            exerciseDTO.getMuscle_group());

        Exercise savedExercise = exerciseRepository.save(newExercise);

        return new ExerciseDTO(savedExercise.getId(),
                               savedExercise.getName(),
                               savedExercise.getDescription(),
                               savedExercise.getMuscle_group());
    }

    public ExerciseDTO getExerciseById(Integer id){
        Exercise exercise = exerciseRepository.findById(id).orElseThrow(() -> new RuntimeException("Exercicio não encontrado!"));
        return new ExerciseDTO(exercise.getId(),
                               exercise.getName(),
                               exercise.getDescription(),
                               exercise.getMuscle_group());
    }
}
