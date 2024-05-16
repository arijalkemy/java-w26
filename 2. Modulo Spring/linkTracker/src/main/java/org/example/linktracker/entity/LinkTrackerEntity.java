package org.example.linktracker.entity;

import lombok.Data;

import java.util.UUID;


@Data
public class LinkTrackerEntity {
    private UUID id;
    private String link;
    private String password;
    private int counter = 0;

    public LinkTrackerEntity(int counter, String link) {
        this.counter = counter + counter;
        this.link = link;
        this.id = UUID.randomUUID();
    }

    public LinkTrackerEntity(String link, String password) {
        this.id = UUID.randomUUID();
        this.link = link;
        this.password = password;
    }

    public LinkTrackerEntity() {

    }

    public void sumaCounter(){
        int coun = 1;
        counter += coun;
        coun ++;
    }
}


