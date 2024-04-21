package deportistas.deportistas.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sport {
    private Integer id;
    private Integer nivel;
    private String nombre;
}
