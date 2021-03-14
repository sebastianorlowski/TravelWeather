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
import pl.orlowski.sebastian.weather.validation.user.UserValidation;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Unknown user");
        }

        if (user.isEnabled()) {
            org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User
                    (user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));

            return userDetails;
        } else {
            throw new UsernameNotFoundException("Account is disabled!");
        }
    }

    /* Transfer roles to authorities */
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
//        Put roles into stream then map the role, we put role to the security provide class
//        simplegrantedauthority and we pass roles name to this object and finally we collected stream to the list
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}
