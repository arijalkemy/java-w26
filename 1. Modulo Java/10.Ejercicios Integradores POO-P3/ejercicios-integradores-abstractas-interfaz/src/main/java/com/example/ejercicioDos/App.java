package com.example.ejercicioDos;

import java.util.ArrayList;
import java.util.List;

import com.example.ejercicioDos.DocumentTypes.Curriculum;
import com.example.ejercicioDos.DocumentTypes.DocumentPDF;
import com.example.ejercicioDos.DocumentTypes.Report;

public class App {

    public static void main(String[] args) {
        List<String> capabilities = new ArrayList<>();
        capabilities.add("Proactivo");
        capabilities.add("Bueno Jugando Brawlhalla");
        capabilities.add("Fan del Barça");
        capabilities.add("Analítico");

        Curriculum curriculum = new Curriculum("Andrés", "", null, capabilities);
        DocumentPDF pdf = new DocumentPDF("Pepe", "Cómo ser como mi amigo Pepe", "Pepeología", "5000");
        Report report = new Report("Este es un reporte, sí.", 78000, "mesi", "critiano");

        curriculum.print(curriculum);
        pdf.print(pdf);
        report.print(report);
    }
}
