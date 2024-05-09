package org.example.SocialMeli2.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
public class BasicCustomerDto implements Serializable {
    @JsonProperty("user_id")
    private int customerId;
    @JsonProperty("user_name")
    private String userName;
    @JsonIgnore
    private List<Integer> following;
}
