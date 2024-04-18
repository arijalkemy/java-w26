package org.mercadolibre.multicapatemplate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Setter
@Getter
@AllArgsConstructor
public class BlogEntryResponseDTO implements Serializable {
    private Integer id;
    private String title;
    private String authorName;
    private LocalDateTime publicationDate;
}
