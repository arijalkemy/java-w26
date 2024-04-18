package bootcamp.bendezujonathan.blogs.dto.request;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaDeBlogRequest {
    @Positive
    private int id;
    @NonNull
    private String titulo;
    @NonNull
    private String nombreAutor;
}
