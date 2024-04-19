package org.mercadolibre.multicapatemplate.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogEntry {
    private Integer id;
    private String title;
    private String authorName;

    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate publicationDate;
}
