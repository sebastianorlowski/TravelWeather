package pl.orlowski.sebastian.weather.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.orlowski.sebastian.weather.dto.DestinationDto;
import pl.orlowski.sebastian.weather.dto.TripDto;
import pl.orlowski.sebastian.weather.model.Destination;
import pl.orlowski.sebastian.weather.model.Trip;
import pl.orlowski.sebastian.weather.repository.DestinationRepository;

@Service
@RequiredArgsConstructor
public class DestinationService {

    private final DestinationRepository destinationRepository;

    public Destination destination(DestinationDto destinationDto, Trip trip) {

        return destinationRepository.save(
                Destination.builder()
                .hours(destinationDto.getHours())
                .day(destinationDto.getDay())
                .month(destinationDto.getMonth())
                .year(destinationDto.getYear())
                .place(destinationDto.getPlace())
                .trip(trip)
                .build());
    }
}
