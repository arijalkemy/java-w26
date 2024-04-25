package org.example.be_java_hisp_w26_g07.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Followers {
    private Integer userId;
    private Integer sellerId;
}
