package bootcamp.bendezujonathan.link.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkRequest {
    private String url;
    private String password;
}
