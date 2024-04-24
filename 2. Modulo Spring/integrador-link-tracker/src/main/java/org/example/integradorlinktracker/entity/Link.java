package org.example.integradorlinktracker.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Link {
    private Integer id;
    private String url;
    private String password;
    private int redirectCount;

}
