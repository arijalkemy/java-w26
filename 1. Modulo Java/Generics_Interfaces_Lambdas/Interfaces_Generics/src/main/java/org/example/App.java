package org.example;

import java.util.List;
import java.util.ArrayList;

public class App
{
    public static void main( String[] args )
    {
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("SpringBoot");
        skills.add("Databases");


        PDF pdf = new PDF("PDF Title", "PDF Author", "Science",100);
        Curriculum nicolasCV= new Curriculum("Nicolas",28,"Colombia", skills);
        Inform inform = new Inform("Inform Author", "Inform Revisor", "Lorem Ipsum", 50);

        pdf.print();
        nicolasCV.print();
        inform.print();
    }
}
