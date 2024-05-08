package org.mercadolibre.NotNullTeam.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ExceptionDetails {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime local_date;
    private Object message;
    private String uri;

    public ExceptionDetails(LocalDateTime local_date, Exception exception, HttpServletRequest url) {
        this.local_date = local_date;
        this.message = exception.getMessage();
        this.uri = url.getRequestURI();
    }

}
