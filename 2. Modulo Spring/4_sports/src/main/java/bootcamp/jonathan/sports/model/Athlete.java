package bootcamp.jonathan.sports.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Athlete {
    private String name;
    private String surname;
    private int age;
}
