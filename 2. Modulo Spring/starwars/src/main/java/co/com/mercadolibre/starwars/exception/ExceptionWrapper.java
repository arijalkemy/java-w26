package co.com.mercadolibre.starwars.exception;

import lombok.*;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@Setter
@Getter
public class ExceptionWrapper {

    private LocalTime timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public ExceptionWrapper(Integer status, String error, String message, String path) {
        this.timestamp = LocalTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
