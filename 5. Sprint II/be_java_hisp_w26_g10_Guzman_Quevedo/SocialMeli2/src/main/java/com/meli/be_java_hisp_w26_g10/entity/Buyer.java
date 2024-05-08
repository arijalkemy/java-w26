package com.meli.be_java_hisp_w26_g10.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Buyer {
    private Integer user_id;
    private String user_name;
    private List<Seller> followed;
}
