package bootcamp.bendezujonathan.covid.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Symptom {

    private int code;
    private String name;
    private SeverityEnum severity;

    @Override
    public String toString(){
        return String.format("%s [Severidad: %s]",name, severity);
    }
}
