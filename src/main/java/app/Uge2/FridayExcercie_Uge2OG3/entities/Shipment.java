package app.Uge2.FridayExcercie_Uge2OG3.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shipment {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Packages packages;

    @ManyToOne
    private Location sourcesLocation;
    @ManyToOne
    private Location destinationsLocation;

    private LocalDateTime shipmentDateTime;

}
