package org.example;

public class App
{
    public static void main( String[] args )
    {

        PDF pdf1 = new PDF(1, "pedro", "la vie", "novela");

        Curriculum curriculum1 = new Curriculum("pedro", "developer", "c++");

        Informe informe1 = new Informe(1, 2, "informe", "pedro");

        pdf1.imprimiendo();
        System.out.println("--------------------------");
        curriculum1.imprimiendo();
        System.out.println("--------------------------");
        informe1.imprimiendo();
    }
}
