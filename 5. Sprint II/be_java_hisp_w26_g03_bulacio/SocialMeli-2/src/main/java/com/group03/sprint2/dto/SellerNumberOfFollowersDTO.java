package com.group03.sprint2.dto;

import lombok.*;

import java.io.Serializable;

@Data
@EqualsAndHashCode()
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SellerNumberOfFollowersDTO implements Serializable{
    Integer userId;
    String username;
    Integer followers;
}
