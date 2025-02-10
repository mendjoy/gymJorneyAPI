package io.github.mendjoy.gymJourneyAPI.exception;

import io.github.mendjoy.gymJourneyAPI.dto.response.ResponseApiDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ResponseApiDTO> handleUserNotFoundException(UsernameNotFoundException exception){
        ResponseApiDTO responseApi = ResponseApiDTO.error(HttpStatus.NOT_FOUND, exception.getMessage());
        return new ResponseEntity<>(responseApi, responseApi.getStatus());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ResponseApiDTO> handleBadCredentialsException(BadCredentialsException exception){
        ResponseApiDTO responseApi = ResponseApiDTO.error(HttpStatus.UNAUTHORIZED, exception.getMessage());
        return new ResponseEntity<>(responseApi, responseApi.getStatus());
    }
}
