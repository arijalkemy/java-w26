package org.mercadolibre.multicapatemplate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Setter
@Getter
@AllArgsConstructor
public class BlogEntryRequestDTO implements Serializable{
    private Integer id;
    private String title;
    private String authorName;
}
