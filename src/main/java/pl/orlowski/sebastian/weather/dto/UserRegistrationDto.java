package pl.orlowski.sebastian.weather.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserRegistrationDto {

    private Long id;
    @Size(min = 5, max = 20, message = "")
    @Pattern(regexp = "^[A-Za-z0-9]+$")
    private String username;

    @Email
    private String email;

    private String password;
}
