package com.meli.obtenerdiploma.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
public class ExceptionDetails {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime local_date;
    private Map<String, String> errors;
    private String uri;

    public ExceptionDetails(LocalDateTime local_date, Map<String, String> errors, HttpServletRequest url) {
        this.local_date = local_date;
        this.errors = errors;
        this.uri = url.getRequestURI();
    }
}
