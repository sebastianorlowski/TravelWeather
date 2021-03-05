package pl.orlowski.sebastian.weather.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.orlowski.sebastian.weather.config.security.LoginCredentials;
import pl.orlowski.sebastian.weather.model.User;

@RestController
public class LoginController {

    @PostMapping("/login")
    public void login(@RequestBody LoginCredentials loginCredentials) {

    }
}
