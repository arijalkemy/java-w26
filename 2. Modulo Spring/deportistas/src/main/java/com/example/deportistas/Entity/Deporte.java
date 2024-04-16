package com.example.deportistas.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Deporte implements Serializable {

    private int id;
    private String nombre;
    private int nivel;
}
