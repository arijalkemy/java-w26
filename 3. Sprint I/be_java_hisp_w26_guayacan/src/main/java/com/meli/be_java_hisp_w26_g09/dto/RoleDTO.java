package com.meli.be_java_hisp_w26_g09.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {

    @JsonProperty("id_role")
    private Integer idRole;
    @JsonProperty("nameRole")
    private String nameRole;
}
