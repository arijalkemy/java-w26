package com.group03.sprint1.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class SellerNumberOfFollowersDTO implements Serializable{
    Integer userId;
    String username;
    Integer followers;
}
