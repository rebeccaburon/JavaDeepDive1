package app.Uge3.Relations_Thomas_example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@Setter
@ToString
@AllArgsConstructor
@Entity
@Builder
public class Adress {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
      private Long id;
    private String street;

    //Man danner relationen på den klasse, som er ejet af en anden relation.
    //Så en Employee har en adress. Derfor skal adress mappes til Employee.
    @OneToMany (mappedBy = "adress", cascade = CascadeType.ALL )
    private Set<Emloyee> employeeList;

    public void addEmployee(Emloyee employeeAdd) {
        if (employeeList == null) {
            this.employeeList = new HashSet<>();
        }
        this.employeeList.add(employeeAdd);
        employeeAdd.setAdress(this);
    }
    public void removeEmployee(Emloyee employeeRemove) {
        this.employeeList.remove(employeeRemove);
        employeeRemove.setAdress(null);
    }
}
