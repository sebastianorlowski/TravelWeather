package pl.orlowski.sebastian.weather.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import pl.orlowski.sebastian.weather.dto.DestinationDto;
import pl.orlowski.sebastian.weather.model.Destination;
import pl.orlowski.sebastian.weather.service.DestinationService;

@RestController
@RequestMapping("/api/v1/trips")
@RequiredArgsConstructor
public class DestinationController {

    private final DestinationService destinationService;

    @PostMapping("/{tripId}/destinations")
    public ResponseEntity<?> createDestination(@PathVariable Long tripId,
                                               @RequestBody DestinationDto destinationDto,
                                               UsernamePasswordAuthenticationToken user) {
        destinationService.createDestination(destinationDto, tripId,  user.getName());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(destinationDto);
    }

    @GetMapping("/{tripId}/destinations/{destinationId}")
    public ResponseEntity<?> showDestination(@PathVariable Long tripId,
                                             @PathVariable Long destinationId,
                                             UsernamePasswordAuthenticationToken user) {
        Destination destination = destinationService.showDestinationById(destinationId, user.getName());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(destination);
    }

    @PutMapping("/{tripId}/destinations/{destinationId}")
    public ResponseEntity<?> updateDestination(@PathVariable Long tripId,
                                               @PathVariable Long destinationId,
                                               @RequestBody DestinationDto destinationDto,
                                               UsernamePasswordAuthenticationToken user) {
        destinationService.updateDestination(destinationDto, destinationId, user.getName());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(destinationDto);
    }

    @DeleteMapping("/{tripId}/destinations/{destinationId}")
    public ResponseEntity<?> deleteDestination(@PathVariable Long tripId,
                                               @PathVariable Long destinationId,
                                               UsernamePasswordAuthenticationToken user) {
        destinationService.removeDestination(destinationId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

}
