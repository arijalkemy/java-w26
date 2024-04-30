

package spring.obtenerdiploma.exceptions;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import spring.obtenerdiploma.model.ErrorDTO;

@Getter
public class ObtenerDiplomaException extends RuntimeException {

    private final ErrorDTO error;
    private final HttpStatus status;

    public ObtenerDiplomaException(String message, HttpStatus status) {
        this.error = new ErrorDTO(this.getClass().getSimpleName(), message);
        this.status = status;
    }

}