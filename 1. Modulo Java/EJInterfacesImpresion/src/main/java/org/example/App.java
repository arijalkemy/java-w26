package org.example;


public class App {
    public static void main(String[] args) {
        //Instanciando cada uno de los objetos curriculum, pdf e informes
        Curriculum curriculum = new Curriculum("manu","inge","En todo es bueno");
        PDF pdf = new PDF(50,"Manuel","Malacara","Harry popotes","Comedia");
        Informes informes = new Informes(30,40,"Manuel","Malacara");

        //llamando a los metodos imprimir de cada uno de los objetos
        curriculum.imprimir();
        informes.imprimir();
        pdf.imprimir();
    }

}
