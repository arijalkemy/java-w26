package com.group03.sprint1.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.group03.sprint1.dto.PublicationDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerResponseDTO implements Serializable {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("user_name")
    private String userName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<UserDataResponseDTO> followers;
    @JsonIgnore
    @JsonProperty("posts")
    private List<PublicationDTO> publications;
}