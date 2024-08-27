package app.Uge2.jpaday1.org.example.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) //setting the ID
    private Integer id;
    private String username;
    private String password;
    private String email;

}
