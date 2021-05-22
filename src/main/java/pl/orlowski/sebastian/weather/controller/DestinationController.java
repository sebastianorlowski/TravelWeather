package pl.orlowski.sebastian.weather.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import pl.orlowski.sebastian.weather.dto.DestinationDto;
import pl.orlowski.sebastian.weather.model.Destination;
import pl.orlowski.sebastian.weather.model.Trip;
import pl.orlowski.sebastian.weather.service.DestinationService;

@RestController
@RequestMapping("/api/v1/trips")
public class DestinationController {

    private final DestinationService destinationService;

    @Autowired
    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @PostMapping("/{tripId}/destinations")
    public ResponseEntity<Destination> createDestination(@PathVariable Long tripId,
                                                  @RequestBody DestinationDto destinationDto,
                                                  UsernamePasswordAuthenticationToken user) {
        Destination destination = destinationService
                .createDestination(destinationDto, tripId,  user.getName());

        return new ResponseEntity<>(destination, HttpStatus.CREATED);
    }

    @GetMapping("/destinations/{destinationId}")
    public ResponseEntity<Destination> showDestination(@PathVariable Long destinationId,
                                             UsernamePasswordAuthenticationToken user) {
        Destination destination = destinationService
                .showDestinationById(destinationId, user.getName());

        return new ResponseEntity<>(destination, HttpStatus.OK);
    }

    @PutMapping("/{tripId}/destinations/{destinationId}")
    public ResponseEntity<?> updateDestination(@PathVariable Long tripId,
                                               @PathVariable Long destinationId,
                                               @RequestBody DestinationDto destinationDto,
                                               UsernamePasswordAuthenticationToken user) {
        Destination destination = destinationService
                .updateDestination(destinationDto, destinationId, user.getName(), tripId);

        return new ResponseEntity<>(destination, HttpStatus.OK);
    }

    @DeleteMapping("/{tripId}/destinations/{destinationId}")
    public ResponseEntity<?> deleteDestination(@PathVariable Long tripId,
                                               @PathVariable Long destinationId,
                                               UsernamePasswordAuthenticationToken user) {
        destinationService.removeDestination(destinationId, user.getName());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
