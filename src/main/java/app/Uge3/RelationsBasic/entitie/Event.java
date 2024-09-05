package app.Uge3.RelationsBasic.entitie;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Event {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private LocalDate date;

    //Relation with Linktabel 1:m
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL) //perosn in PersonEvent
    private Set<PersonEvent> persons = new HashSet<>();

    public Event(LocalDate date, String name) {
        this.date = date;
        this.name = name;
    }
}
