package org.bootcamp.linktracer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Builder
public class LinkDTO implements Serializable {

    private Integer id;
    @NotEmpty
    private String url;
    @NotEmpty
    private String password;
    private Integer visitAmount;
    private Boolean validUrl;

}
