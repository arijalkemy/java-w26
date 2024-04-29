package com.meli.obtenerdiploma.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Getter
@Setter
public class ExceptionDetails {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime local_date;
    private String message;
    private String uri;

    public ExceptionDetails(LocalDateTime local_date, String exceptionMessage, HttpServletRequest url) {
        this.local_date = local_date;
        this.message = exceptionMessage;
        this.uri = url.getRequestURI();
    }
}
