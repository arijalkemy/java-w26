package bootcamp.bendezujonathan.elastichsearch.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProvinciaRequest {
    private Long provinciaId;
    private String provinciaNombre;
}
