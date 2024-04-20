package com.w26.linktracker.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Link {
    private int id;
    private String password;
    private String url;
    private boolean isValid;


    private static int counterId = 0;
    public static int generateId(){
        int toReturn = counterId;
        counterId++;
        return toReturn;
    }
}
