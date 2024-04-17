package meli.bootcamp.covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import meli.bootcamp.covid19.entities.Symptom;

import java.io.Serializable;
import java.util.List;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonSymptomDto implements Serializable {
    private String fullName;
    private Integer age;
    private List<Symptom> symptoms;
}
