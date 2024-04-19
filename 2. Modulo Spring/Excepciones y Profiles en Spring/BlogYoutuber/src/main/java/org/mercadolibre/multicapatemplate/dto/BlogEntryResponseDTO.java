package org.mercadolibre.multicapatemplate.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogEntryResponseDTO implements Serializable {
    @JsonIgnore
    private Integer id;
    private String title;
    private String authorName;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate publicationDate;
}
