package io.github.mendjoy.gymJourneyAPI.service;

import io.github.mendjoy.gymJourneyAPI.dto.exercise.ExerciseDTO;
import io.github.mendjoy.gymJourneyAPI.entity.exercise.Exercise;
import io.github.mendjoy.gymJourneyAPI.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public Page<ExerciseDTO> getAllExercises(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Exercise> exercisePage = exerciseRepository.findAll(pageable);

        return exercisePage.map(exercise -> new ExerciseDTO(exercise.getId(),
                                                                    exercise.getName(),
                                                                    exercise.getDescription(),
                                                                    exercise.getMuscle_group()));
    }

    public Page<ExerciseDTO> searchExercisesByName(String name, int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Exercise> exercisePage = exerciseRepository.findByNameContainingIgnoreCase(name, pageable);
        return exercisePage.map(exercise -> new ExerciseDTO(exercise.getId(),
                                                                    exercise.getName(),
                                                                    exercise.getDescription(),
                                                                    exercise.getMuscle_group()));

    }
}
