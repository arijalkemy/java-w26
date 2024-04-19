package com.example.multicapatemplate.model;

import lombok.Data;

import java.util.List;

@Data
public class Plato {
    String nombre;
    List<Ingrediente> ingredientes;


}
