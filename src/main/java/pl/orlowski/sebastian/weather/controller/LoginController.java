package pl.orlowski.sebastian.weather.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.orlowski.sebastian.weather.config.security.LoginCredentials;
import pl.orlowski.sebastian.weather.model.User;

@RestController
public class LoginController {

    @PostMapping("/login")
    public void login(@RequestBody LoginCredentials loginCredentials) {

    }
}
