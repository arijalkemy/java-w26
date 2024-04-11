package org.example.AbstractClass_Interfaces.Ejercicio_2;

import org.example.AbstractClass_Interfaces.Ejercicio_2.Implements.BooksPDF;
import org.example.AbstractClass_Interfaces.Ejercicio_2.Implements.Curriculums;
import org.example.AbstractClass_Interfaces.Ejercicio_2.Implements.Person;
import org.example.AbstractClass_Interfaces.Ejercicio_2.Implements.Report;
import org.example.AbstractClass_Interfaces.Ejercicio_2.Services.Imprimible;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        BooksPDF book = new BooksPDF(100, "Jose", "Harry Potter", "Fantasia");
        Report report = new Report("Es un Reporte", 10, "Marta", "Pedro");
        Person person = new Person("Martin", 30);
        Curriculums curriculum = new Curriculums(person, Arrays.asList("Java", "Spring", "Hibernate"));


        List<Imprimible> imprimibles = Arrays.asList(book, report, curriculum);

        imprimibles.forEach(Imprimible::viewData);

    }
}
