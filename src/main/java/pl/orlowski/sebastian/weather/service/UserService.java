package pl.orlowski.sebastian.weather.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.orlowski.sebastian.weather.dto.UserRegistrationDto;
import pl.orlowski.sebastian.weather.model.User;
import pl.orlowski.sebastian.weather.repository.UserRepository;
import pl.orlowski.sebastian.weather.validation.PasswordStrength;
import pl.orlowski.sebastian.weather.validation.exception.EmailAlreadyExistException;
import pl.orlowski.sebastian.weather.validation.exception.PasswordIsWeakException;
import pl.orlowski.sebastian.weather.validation.exception.UserAlreadyExistException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final PasswordStrength passwordStrength;

    public User save(UserRegistrationDto userRegistrationDto) {

        if (!passwordStrength.isValid(userRegistrationDto.getPassword())) {
            throw new PasswordIsWeakException("");
        }

        if (usernameIsExist(userRegistrationDto.getUsername())) {
            throw new UserAlreadyExistException(userRegistrationDto.getUsername());
        }

        if (emailIsExist(userRegistrationDto.getEmail())) {
            throw new EmailAlreadyExistException(userRegistrationDto.getEmail());
        }

        User user = new User();
        user.setUsername(userRegistrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
        user.setEmail(userRegistrationDto.getEmail());

        return userRepository.save(user);
    }

    public boolean emailIsExist(String email) {
        return userRepository.findByEmail(email) != null;
    }

    public boolean usernameIsExist(String username) {
        return userRepository.findByUsername(username) != null;
    }
}
