package pl.orlowski.sebastian.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "trips")
@Getter
@Setter
@RequiredArgsConstructor
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private User user;

    @OneToMany
    private Collection<Destination> destinations;

}
