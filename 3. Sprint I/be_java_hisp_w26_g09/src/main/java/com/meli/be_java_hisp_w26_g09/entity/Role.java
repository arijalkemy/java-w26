package com.meli.be_java_hisp_w26_g09.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    public static final Integer ID_CUSTOMER = 1;
    public static final Integer ID_SELLER = 2;

    @JsonProperty("id_role")
    private Integer idRole;
    @JsonProperty("name_role")
    private String nameRole;

}
