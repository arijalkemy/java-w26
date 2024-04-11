package org.example.AbstractClass_Interfaces.Ejercicio_2.Implements;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.AbstractClass_Interfaces.Ejercicio_2.Services.Imprimible;

@Data
@AllArgsConstructor
public class BooksPDF implements Imprimible {

    private int amountPages;
    private String author;
    private String title;
    private String gender;

    @Override
    public void imprimir() {
        System.out.println("Amount of pages: " + amountPages);
        System.out.println("Author: " + author);
        System.out.println("Title: " + title);
        System.out.println("Gender: " + gender);
    }
}
