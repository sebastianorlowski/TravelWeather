package pl.orlowski.sebastian.weather.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.orlowski.sebastian.weather.dto.UserRegistrationDto;
import pl.orlowski.sebastian.weather.model.Role;
import pl.orlowski.sebastian.weather.model.User;
import pl.orlowski.sebastian.weather.repository.RoleRepository;
import pl.orlowski.sebastian.weather.repository.UserRepository;
import pl.orlowski.sebastian.weather.validation.user.UserValidator;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserValidator userValidator;
    private final RoleRepository roleRepository;

    public void save(UserRegistrationDto userRegistrationDto) {
        userValidator.userRegistrationValidator(userRegistrationDto);

        User user = new User();
        user.setUsername(userRegistrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
        user.setEmail(userRegistrationDto.getEmail());
        user.setEnabled(true);
        final Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("ROLE_USER"));
        user.setRoles(roles);

        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("");
        }
        return new org.springframework.security.core.userdetails.User
                (user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
