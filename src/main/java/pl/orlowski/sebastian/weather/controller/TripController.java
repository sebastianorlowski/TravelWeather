package pl.orlowski.sebastian.weather.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import pl.orlowski.sebastian.weather.dto.TripDto;
import pl.orlowski.sebastian.weather.model.Trip;
import pl.orlowski.sebastian.weather.service.DestinationService;
import pl.orlowski.sebastian.weather.service.TripService;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/trips")
@RequiredArgsConstructor
public class TripController {

    public final TripService tripService;
    public final DestinationService destinationService;

    @GetMapping
    public ResponseEntity<?> showTrips(UsernamePasswordAuthenticationToken user) {
        Collection<Trip> trips = tripService.showTripByUsername(user.getName());
        if (trips.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(trips);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> showTripById(@PathVariable Long id,
                                          UsernamePasswordAuthenticationToken user) {
        Trip trip = tripService.showTripById(id, user.getName());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(trip);
    }

    @PostMapping
    public ResponseEntity<?> createTrip(@RequestBody TripDto tripDto,
                                        UsernamePasswordAuthenticationToken user) {
        tripService.save(tripDto, user.getName());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTripName(@PathVariable Long id,
                                            @RequestBody TripDto tripDto,
                                            UsernamePasswordAuthenticationToken user) {
        tripService.updateTrip(tripDto, id, user.getName());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tripDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrip(@PathVariable Long id,
                                  UsernamePasswordAuthenticationToken user) {
        tripService.removeTrip(id, user.getName());

        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
