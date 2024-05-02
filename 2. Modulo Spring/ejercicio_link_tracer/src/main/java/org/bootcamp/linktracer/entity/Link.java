package org.bootcamp.linktracer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Link {

    private Integer id;
    private Integer visitAmount;
    private String url;
    private Boolean validUrl;
    private String password;

}
