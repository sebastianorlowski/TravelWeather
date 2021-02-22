package pl.orlowski.sebastian.weather.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.orlowski.sebastian.weather.dto.UserRegistrationDto;
import pl.orlowski.sebastian.weather.model.Destination;
import pl.orlowski.sebastian.weather.model.User;
import pl.orlowski.sebastian.weather.repository.UserRepository;
import pl.orlowski.sebastian.weather.service.TravelService;
import pl.orlowski.sebastian.weather.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final TravelService travelService;
    private final UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "zarejestruj się";
    }

    @PostMapping("/registration")
    public String registerUser(@Valid UserRegistrationDto userRegistrationDto,
                               BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "";
        }
        userService.save(userRegistrationDto);

        return "zarejestrowny";
    }

    @GetMapping("/")
    public String home() {
        return new String("Hello");
    }

    @GetMapping("/secured")
    public String homeSecured() {
        return new String("Secured hello");
    }

    @GetMapping("/index")
    public List<Destination> getOption() {
        return travelService.showDestinationInfo();
    }

    @PostMapping("/addDestination")
    public boolean addDestination(@RequestBody Destination destination) {
        return travelService.addDestinationInfo(destination);
    }


}
