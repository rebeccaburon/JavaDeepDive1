package app.Uge3.Relations_Thomas_example.entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@Setter
@ToString
@AllArgsConstructor
@Entity
@Builder
public class Emloyee {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne (cascade = CascadeType.PERSIST) //adressens ID bliver automatisk persisteret.
    private Adress adress;

}
