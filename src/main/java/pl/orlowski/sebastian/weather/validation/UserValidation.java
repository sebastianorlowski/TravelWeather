package pl.orlowski.sebastian.weather.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.orlowski.sebastian.weather.dto.UserRegistrationDto;
import pl.orlowski.sebastian.weather.repository.UserRepository;
import pl.orlowski.sebastian.weather.service.UserService;
import pl.orlowski.sebastian.weather.validation.exception.EmailAlreadyExistException;
import pl.orlowski.sebastian.weather.validation.exception.PasswordIsWeakException;
import pl.orlowski.sebastian.weather.validation.exception.UserAlreadyExistException;

@Component
@RequiredArgsConstructor
public class UserValidation {

    private final PasswordStrength passwordStrength;
    private final UserRepository userRepository;

    public void userRegistrationValidator(UserRegistrationDto userRegistrationDto) {
        if (!passwordStrength.isValid(userRegistrationDto.getPassword())) {
            throw new PasswordIsWeakException("");
        }

        if (usernameIsExist(userRegistrationDto.getUsername())) {
            throw new UserAlreadyExistException(userRegistrationDto.getUsername());
        }

        if (emailIsExist(userRegistrationDto.getEmail())) {
            throw new EmailAlreadyExistException(userRegistrationDto.getEmail());
        }

    }

    public boolean emailIsExist(String email) {
        return userRepository.findByEmail(email) != null;
    }

    public boolean usernameIsExist(String username) {
        return userRepository.findByUsername(username) != null;
    }
}
