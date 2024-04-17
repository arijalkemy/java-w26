package com.example._06_starwars.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter @Setter
public class Personaje {
    private String nombre;
    private String colorDePelo;
    private String colorDePiel;
    private String colorDeOjos;
    private String anioDeNacimiento;
    private String genero;
    private String mundoNatal;
    private String especie;
    private int peso;
    private int altura;

    public Personaje(String nombre, String colorDePelo, String colorDePiel, String colorDeOjos,
                     String anioDeNacimiento, String genero, String mundoNatal, String especie, int peso, int altura) {
        this.nombre = nombre;
        this.colorDePelo = colorDePelo;
        this.colorDePiel = colorDePiel;
        this.colorDeOjos = colorDeOjos;
        this.anioDeNacimiento = anioDeNacimiento;
        this.genero = genero;
        this.mundoNatal = mundoNatal;
        this.especie = especie;
        this.peso = peso;
        this.altura = altura;
    }
}
