package app.Uge2.FridayExcercie_Uge2OG3.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @Column(nullable = false)
    private String address;

    @OneToMany (mappedBy = "sourcesLocation")
    private Set<Shipment> sourcesLocations = new HashSet<>();

    @OneToMany (mappedBy = "destinationsLocation")
    private Set<Shipment> destinationsLocations = new HashSet<>();


    public Location(String address, double longitude, double latitude) {
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
    }
    //Bi direction Metod --> Both entites are aware of the relationship.

    public void addSourcesLocation(Shipment sourcesLocation) {
        this.sourcesLocations.add(sourcesLocation);
        if (sourcesLocation !=null){
            sourcesLocation.setSourcesLocation(this);
        }
    }

    public void addDestinationLocation(Shipment destinationsLocation) {
        this.destinationsLocations.add(destinationsLocation);
        if (destinationsLocation !=null){
            destinationsLocation.setDestinationsLocation(this);
        }
    }
}
