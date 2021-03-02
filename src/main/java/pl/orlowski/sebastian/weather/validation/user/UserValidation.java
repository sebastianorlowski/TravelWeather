package pl.orlowski.sebastian.weather.validation.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.orlowski.sebastian.weather.dto.UserRegistrationDto;
import pl.orlowski.sebastian.weather.repository.UserRepository;
import pl.orlowski.sebastian.weather.validation.exception.*;

@Component
@RequiredArgsConstructor
public class UserValidation {

    private final UserInfoChecker userInfoChecker;
    private final UserRepository userRepository;

    public void userRegistrationValidator(UserRegistrationDto userRegistrationDto) {
        try {
            if (!userInfoChecker.isValidPassword(userRegistrationDto.getPassword())) {
                throw new PasswordIsWeakException("");
            }

            if (!userInfoChecker.isValidUsername(userRegistrationDto.getUsername())) {
                throw new WrongUsernameFormatException("");
            }

            if (!userInfoChecker.isValidEmail(userRegistrationDto.getEmail())) {
                throw new WrongEmailFormatException("");
            }

            if (usernameIsExist(userRegistrationDto.getUsername())) {
                throw new UserAlreadyExistException(userRegistrationDto.getUsername());
            }

            if (emailIsExist(userRegistrationDto.getEmail())) {
                throw new EmailAlreadyExistException(userRegistrationDto.getEmail());
            }
        } catch (NullPointerException e) {
            throw new EmptyValueException("");
        }
    }

    public boolean emailIsExist(String email) {
        return userRepository.findByEmail(email) != null;
    }

    public boolean usernameIsExist(String username) {
        return userRepository.findByUsername(username) != null;
    }
}
