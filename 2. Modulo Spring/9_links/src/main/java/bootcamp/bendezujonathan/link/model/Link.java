package bootcamp.bendezujonathan.link.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private int id;
    private String url;
    private boolean isValid;
    private String password;
}
