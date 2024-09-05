package app.Uge3.RelationsBasic.entitie;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;


    // Relation 1:1 (One to One)
    @OneToOne (mappedBy = "person", cascade = CascadeType.ALL) //person in PersonDetail
    private app.Uge3.RelationsBasic.entitie.PersonDetail personDetail;

    public Person(String name) {
        this.name = name;
    }

    // Relation 1:m
    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    private Set<Fee> fees = new HashSet<>();


    //Relation m:m
    @ManyToMany
    private Set <Event> events = new HashSet<>();

    //Unidirectional add
    public void addEvent(Event event) {
        this.events.add(event);
    }



    //Bidirection method

    public void addPersonDetails(PersonDetail personDetail) {
        this.personDetail = personDetail;
        if (personDetail != null) {
            personDetail.setPerson(this);
        }
    }


    //Adding an amount to the Set of fees.
    public void addFee(Fee fee) {
        this.fees.add(fee);
        if(fee != null){
            fee.setPerson(this);
        }
    }


}
