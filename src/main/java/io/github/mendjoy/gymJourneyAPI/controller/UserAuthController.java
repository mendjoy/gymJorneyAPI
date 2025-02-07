package io.github.mendjoy.gymJourneyAPI.controller;

import io.github.mendjoy.gymJourneyAPI.dto.UserAuthenticationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserAuthenticationDTO userAuthenticationDTO){
        UsernamePasswordAuthenticationToken usernamePasswordToken = new UsernamePasswordAuthenticationToken(userAuthenticationDTO.getEmail(), userAuthenticationDTO.getPassword());
        authenticationManager.authenticate(usernamePasswordToken);

        return ResponseEntity.ok().build();

    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody ){

    }

}
