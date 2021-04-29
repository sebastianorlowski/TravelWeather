package pl.orlowski.sebastian.weather.dto;

import lombok.*;

@Data
@Getter
@Setter
public class UserRegistrationDto {

    private Long id;
    private String username;
    private String email;
    private String password;

}
