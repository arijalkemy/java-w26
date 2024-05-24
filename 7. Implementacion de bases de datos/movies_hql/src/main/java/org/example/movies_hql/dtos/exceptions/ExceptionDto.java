package org.example.movies_hql.dtos.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionDto {
    private String message;
    private String uri;
}
