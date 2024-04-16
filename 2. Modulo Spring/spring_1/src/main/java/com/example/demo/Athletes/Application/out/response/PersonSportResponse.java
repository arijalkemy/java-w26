package com.example.demo.Athletes.Application.out.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonSportResponse {

    private String name;
    private String lastName;
    private String sportName;

}
