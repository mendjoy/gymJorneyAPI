package io.github.mendjoy.gymJourneyAPI.repository;

import io.github.mendjoy.gymJourneyAPI.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByEmail(String email);

    public boolean existsByEmail(String email);

    public Optional<User> findById(Integer id);
}
