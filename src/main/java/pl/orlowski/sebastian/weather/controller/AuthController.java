package pl.orlowski.sebastian.weather.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.orlowski.sebastian.weather.config.security.LoginCredentials;
import pl.orlowski.sebastian.weather.dto.UserRegistrationDto;
import pl.orlowski.sebastian.weather.model.User;
import pl.orlowski.sebastian.weather.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public ResponseEntity<User> registerUser(@RequestBody UserRegistrationDto userRegistrationDto) {
        userService.save(userRegistrationDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //Only for Swagger
    @PostMapping("/login")
    public void login(@RequestBody LoginCredentials loginCredentials) {

    }
}