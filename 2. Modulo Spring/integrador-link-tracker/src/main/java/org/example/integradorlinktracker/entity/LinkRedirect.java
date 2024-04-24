package org.example.integradorlinktracker.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class LinkRedirect {
    private Link link;
    private int redirectCount;

    public void sumCount(){
        redirectCount++;
    }
}
