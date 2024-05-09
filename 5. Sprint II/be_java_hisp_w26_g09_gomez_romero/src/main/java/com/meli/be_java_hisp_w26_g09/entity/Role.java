package com.meli.be_java_hisp_w26_g09.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    public static final Integer ID_CUSTOMER = 1;
    public static final Integer ID_SELLER = 2;

    @JsonProperty("id_role")
    private Integer idRole;
    @JsonProperty("name_role")
    private String nameRole;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return idRole.equals(role.idRole) && nameRole.equals(role.nameRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRole, nameRole);
    }
}
