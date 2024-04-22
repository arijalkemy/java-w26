package meli.bootcamp.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkResponseDTO {
    private Integer id;
    private String url;
    private String password;
}
