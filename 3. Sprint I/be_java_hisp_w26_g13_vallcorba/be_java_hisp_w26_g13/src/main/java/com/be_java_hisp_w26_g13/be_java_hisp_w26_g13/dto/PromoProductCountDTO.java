package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PromoProductCountDTO {

    private int userId;

    private String userName;

    private int productCount;
}
