package app.Uge3.RelationsBasic.entitie;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class PersonDetail {
    //No Generated Value
    @Id
    private Integer id;
    private String adress;
    private String city;
    private int zip;
    private int age;


    //Relation 1:1 (One To One)
    @OneToOne
    @MapsId
    private Person person;

    public PersonDetail(String adress, String city, int age, int zip) {
        this.adress = adress;
        this.city = city;
        this.age = age;
        this.zip = zip;

    }
}

