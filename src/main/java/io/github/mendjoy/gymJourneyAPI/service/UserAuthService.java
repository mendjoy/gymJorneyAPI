package io.github.mendjoy.gymJourneyAPI.service;

import io.github.mendjoy.gymJourneyAPI.dto.UserAuthenticationDTO;
import io.github.mendjoy.gymJourneyAPI.dto.UserRegisterDTO;
import io.github.mendjoy.gymJourneyAPI.entity.user.User;
import io.github.mendjoy.gymJourneyAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserAuthorizationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username);
    }

    public void authenticate(UserAuthenticationDTO authenticationDTO){
        UsernamePasswordAuthenticationToken usernamePasswordToken = new UsernamePasswordAuthenticationToken(authenticationDTO.getEmail(), authenticationDTO.getPassword());
        authenticationManager.authenticate(usernamePasswordToken);
    }

    public void register(UserRegisterDTO userRegisterDTO){
        if(userRepository.existsByEmail(userRegisterDTO.getEmail())){

        }
        String encryptPassword = new BCryptPasswordEncoder().encode(userRegisterDTO.getPassword());
        User newUser = new User(userRegisterDTO.getEmail(), userRegisterDTO.getName(), userRegisterDTO.getPassword());

        userRepository.save(newUser);
    }
}
