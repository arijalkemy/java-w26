package com.company;

import com.company.classes.Curriculum;
import com.company.classes.Informe;
import com.company.classes.Pdf;
import com.company.interfaces.Imprimible;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> habilidades = new ArrayList<String>();
        habilidades.add("Java");
        habilidades.add("Jira");

        Imprimible curriculum = new Curriculum(
             "Jose PErez",
             "joseperez@gmail.com",
            habilidades
        );
        curriculum.imprimir();

        Imprimible pdf = new Pdf(
                12,
                "Pepito",
                "Resumen de programacion",
                "programacion"
        );
        pdf.imprimir();

        Imprimible informe = new Informe(
                "texto del informe",
                500,
                "Juan Rodriguez",
                "Carlos Tevez"
        );
        informe.imprimir();
    }
}
