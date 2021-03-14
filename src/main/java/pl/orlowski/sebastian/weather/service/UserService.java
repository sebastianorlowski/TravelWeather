package pl.orlowski.sebastian.weather.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.orlowski.sebastian.weather.dto.UserRegistrationDto;
import pl.orlowski.sebastian.weather.model.Role;
import pl.orlowski.sebastian.weather.model.User;
import pl.orlowski.sebastian.weather.repository.RoleRepository;
import pl.orlowski.sebastian.weather.repository.UserRepository;
import pl.orlowski.sebastian.weather.validation.user.UserValidation;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserValidation userValidation;
    private final RoleRepository roleRepository;

    public User save(UserRegistrationDto userRegistrationDto) {

        userValidation.userRegistrationValidator(userRegistrationDto);

        User user = new User();
        user.setUsername(userRegistrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
        user.setEmail(userRegistrationDto.getEmail());
        user.setEnabled(true);
        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));

        return userRepository.save(user);
    }

}
