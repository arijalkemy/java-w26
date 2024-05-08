package com.group03.sprint2.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode()
public class SellerNumberOfFollowersDTO implements Serializable{
    Integer userId;
    String username;
    Integer followers;
}
