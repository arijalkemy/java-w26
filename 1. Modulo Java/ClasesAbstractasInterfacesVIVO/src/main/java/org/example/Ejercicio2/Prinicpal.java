package org.example.Ejercicio2;

public class Prinicpal implements ImprirmirDocumentos{
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Juan", "Ingeniero en Sistemas", "Desarrollador de Software","5511223344","hola@adios.com","Volar, correr, nadar");
        LibroPDF libroPDF = new LibroPDF("Java", 1000, "Juan", "Programacion");
        Informe informe = new Informe("Juan", 300, "Desarrollador de Software", "Programacion");
        ImprirmirDocumentos.imprimirDocumento(curriculum.toString());
        ImprirmirDocumentos.imprimirDocumento(libroPDF.toString());
        ImprirmirDocumentos.imprimirDocumento(informe.toString());
    }
}
