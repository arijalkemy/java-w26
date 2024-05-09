package com.meli.be_java_hisp_w26_g09.util;


import java.util.List;

import com.meli.be_java_hisp_w26_g09.dto.UserDTO;



public class FactoryUserDTO {
    

    /**
     * @return Return followers for ID 2
     */
    public static UserDTO getFollowersDTOWithOrderDesc() {
        List<UserDTO> followers = List.of(
            UserDTO.builder().userId(20).userName("OliviaKing").build(),
            UserDTO.builder().userId(1).userName("JohnDoe").build(),
            UserDTO.builder().userId(6).userName("JessicaWilson").build()
        );

        return UserDTO.builder()
                .userId(2)
                .userName("AliceSmith")
                .followers(followers)
                .build();
     }


    /**
     * @return Return followers for ID 1
     */
    public static UserDTO getFollowedDTOWithOrderDesc() {
        List<UserDTO> followeds = List.of(
            UserDTO.builder().userId(4).userName("EmilyBrown").build(),
            UserDTO.builder().userId(2).userName("AliceSmith").build()
        );

        return UserDTO.builder()
                .userId(1)
                .userName("JohnDoe")
                .followed(followeds)
                .build();
     }



}
