package com.bootcamp.documentos;

public class App {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Juan", "Perez", "example@email.com", "123456789", new String[] { "Java", "Python", "C++" });
        LibroPDF libro = new LibroPDF("El Quijote", "Cervantes", 200, "Novela");
        Informe informe = new Informe("Informe de ventas", 10, "Juan", "Pedro");

        DocumentoImprimible.imprimirDocumento(curriculum);
        System.out.println("--------------------------------------------------");
        DocumentoImprimible.imprimirDocumento(libro);
        System.out.println("--------------------------------------------------");
        DocumentoImprimible.imprimirDocumento(informe);
    }
}
