package bootcamp.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkDTO {
    private Integer linkId;
    private String originalUrl;
    private Integer redirectCount;
    private boolean valid;
}
