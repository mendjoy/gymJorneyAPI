package io.github.mendjoy.gymJourneyAPI.service;

import io.github.mendjoy.gymJourneyAPI.entity.user.User;
import io.github.mendjoy.gymJourneyAPI.entity.user.UserRole;
import io.github.mendjoy.gymJourneyAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void grantAdminRole(Integer id){
        User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Usuário não cadastrado!"));
        user.setRole(UserRole.ADMIN);
        userRepository.save(user);
    }
}
