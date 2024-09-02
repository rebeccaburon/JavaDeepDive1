package app.Uge2.FridayExcercie.entities;

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
@Table(name = "packages")

public class GLSPackages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //setting the ID
    private Integer id;
    //Colum can not be NULL and are uniq.
    @Column(nullable = false, unique = true)
    private String trackingNumber;

    @Column(nullable = false)
    private String senderName;

    @Column(nullable = false)
    private String reciverName;

    //Specifies that DeliveryStatus enum should be stored as a String in the database.
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeliveryStatus deliveryStatus;

    @Column(name = "last_updated", nullable = false)
    private LocalDateTime lastUpdated;

    @Builder
    public GLSPackages(String trackingNumber, String senderName, String reciverName, DeliveryStatus deliveryStatus) {
        this.trackingNumber = trackingNumber;
        this.senderName = senderName;
        this.reciverName = reciverName;
        this.deliveryStatus = deliveryStatus;
    }

    //The method should be called before the entity is saved to the database
    // weather if it's a new entity or an update to an existing one.
    @PrePersist
    @PreUpdate
    // sets the lastUpdated field to the current date and time.
    protected void onUpdate() {
        lastUpdated = LocalDateTime.now();
    }

    //Defines the states of the delivery
    public enum DeliveryStatus {
        PENDING,
        IN_TRANSIT,
        DELIVERED;
    }
}
