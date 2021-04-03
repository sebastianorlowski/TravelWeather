package pl.orlowski.sebastian.weather.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import pl.orlowski.sebastian.weather.dto.DestinationDto;
import pl.orlowski.sebastian.weather.model.Destination;
import pl.orlowski.sebastian.weather.model.Trip;
import pl.orlowski.sebastian.weather.service.DestinationService;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/destinations")
@RequiredArgsConstructor
public class DestinationController {

    private final DestinationService destinationService;

    @GetMapping
    public ResponseEntity<?> showDestination(@RequestParam Long id) {
        Destination destination = destinationService.showDestinationById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(destination);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDestination(@PathVariable Long id,
                                               @RequestBody DestinationDto destinationDto) {
        destinationService.updateDestination(destinationDto, id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(destinationDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDestination(@PathVariable Long id,
                                               UsernamePasswordAuthenticationToken user) {
        destinationService.removeDestination(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

}
