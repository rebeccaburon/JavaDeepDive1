package app.Uge3.RelationsBasic.entitie;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Fee {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer amount;
    private LocalDate payDate;

    @ManyToOne //For hver en fee er der en person
    private Person person;

    public Fee(Integer amount, LocalDate payDate) {
        this.amount = amount;
        this.payDate = payDate;
    }

}
