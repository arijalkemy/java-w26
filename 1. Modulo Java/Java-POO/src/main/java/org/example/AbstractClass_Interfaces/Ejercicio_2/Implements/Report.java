package org.example.AbstractClass_Interfaces.Ejercicio_2.Implements;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.AbstractClass_Interfaces.Ejercicio_2.Services.Imprimible;

@Data
@AllArgsConstructor
public class Report implements Imprimible {

    private String text;
    private int amountPages;
    private String author;
    private String reviewer;

    @Override
    public void imprimir() {
        System.out.println("Text: " + text);
        System.out.println("Amount of pages: " + amountPages);
        System.out.println("Author: " + author);
        System.out.println("Reviewer: " + reviewer);
    }
}
