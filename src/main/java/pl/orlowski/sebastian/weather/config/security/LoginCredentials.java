package pl.orlowski.sebastian.weather.config.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

public class LoginCredentials {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
