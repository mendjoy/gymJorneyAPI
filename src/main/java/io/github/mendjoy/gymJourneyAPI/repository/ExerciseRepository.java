package io.github.mendjoy.gymJourneyAPI.repository;

import io.github.mendjoy.gymJourneyAPI.entity.exercise.Exercise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {

    public Optional<Exercise> findById(Integer id);

    public Optional<Exercise> findByName(String name);

    public boolean existsByName(String name);

    @Override
    Page<Exercise> findAll(Pageable pageable);
}
