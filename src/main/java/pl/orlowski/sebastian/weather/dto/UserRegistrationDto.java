package pl.orlowski.sebastian.weather.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Getter
@Setter
public class UserRegistrationDto {

    private Long id;
    private String username;
    private String email;
    private String password;

}
