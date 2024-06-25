package com.mercadolibre.project_be_java_hisp_w26_t7.dtos.errors;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExceptionDto {
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate time;
    private String message;
    private String uri;

    public ExceptionDto(String message, String uri) {
        this.time = LocalDate.now();
        this.message = message;
        this.uri = uri.replace("uri=", "");
    }
}
