package app.Uge1.Excercises2_FunctionalProgramming.e4Generics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
@AllArgsConstructor

public class SerializableEmployee implements Serializable {
 private Employee employee;
}
