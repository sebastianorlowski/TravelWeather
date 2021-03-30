package pl.orlowski.sebastian.weather.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import pl.orlowski.sebastian.weather.dto.TripDto;
import pl.orlowski.sebastian.weather.model.Trip;
import pl.orlowski.sebastian.weather.model.User;
import pl.orlowski.sebastian.weather.service.TripService;

import javax.xml.ws.Response;
import java.util.Collection;

@RestController
@RequestMapping("/api/v1/trips")
@RequiredArgsConstructor
public class TripController {

    public final TripService tripService;

    /* Pierwsza strona - wyświetl 10 tripów(max liczba tripów) */
    @GetMapping
    public ResponseEntity<?> getTrips(UsernamePasswordAuthenticationToken user) {
        Collection<Trip> trips = tripService.findTripByUsername(user.getName());
        if (trips.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(trips);
    }

    /* Stwórz nowego tripa */
    @PostMapping
    public ResponseEntity<?> createTrip(@RequestBody TripDto tripDto,
                                        UsernamePasswordAuthenticationToken user) {
        tripService.save(tripDto, user.getName());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(tripDto);
    }

    /* Edytuj tripa */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTripName(@PathVariable Long id,
                                            @RequestBody TripDto tripDto,
                                            UsernamePasswordAuthenticationToken user) {
        tripService.updateTrip(tripDto, id, user.getName());

        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }


    /* Usuń tripa */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrip(@PathVariable Long id,
                                  UsernamePasswordAuthenticationToken user) {
        tripService.removeTrip(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
