package com.group03.sprint2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@EqualsAndHashCode()
@AllArgsConstructor
@NoArgsConstructor
public class SellerNumberOfFollowersDTO implements Serializable{
    Integer userId;
    String username;
    Integer followers;

}
