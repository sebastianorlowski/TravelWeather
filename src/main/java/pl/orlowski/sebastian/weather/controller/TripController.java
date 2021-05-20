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
import java.util.List;

@RestController
@RequestMapping("/api/v1/trips")
@RequiredArgsConstructor
public class TripController {

    public final TripService tripService;
    public final DestinationService destinationService;

    @GetMapping
    public ResponseEntity<List<Trip>> showTrips(UsernamePasswordAuthenticationToken user) {
        List<Trip> trips = tripService.showTripByUsername(user.getName());
        if (trips.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(trips, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> showTripById(@PathVariable Long id,
                                          UsernamePasswordAuthenticationToken user) {
        Trip trip = tripService.showTripById(id, user.getName());

        return new ResponseEntity<>(trip, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Trip> createTrip(@RequestBody TripDto tripDto,
                                        UsernamePasswordAuthenticationToken user) {
        Trip trip = tripService.save(tripDto, user.getName());

        return new ResponseEntity<>(trip, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trip> updateTripName(@PathVariable Long id,
                                            @RequestBody TripDto tripDto,
                                            UsernamePasswordAuthenticationToken user) {
        Trip trip = tripService.updateTrip(tripDto, id, user.getName());

        return new ResponseEntity<>(trip, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrip(@PathVariable Long id,
                                  UsernamePasswordAuthenticationToken user) {
        tripService.removeTrip(id, user.getName());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
