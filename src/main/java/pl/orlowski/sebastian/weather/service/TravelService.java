package pl.orlowski.sebastian.weather.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.orlowski.sebastian.weather.model.Destination;
import java.util.List;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class TravelService {

    private List<Destination> destinationList;

    public boolean addDestinationInfo(Destination destination) {
        return destinationList.add(destination);
    }

    public List<Destination> showDestinationInfo() {
        return destinationList;
    }

}
