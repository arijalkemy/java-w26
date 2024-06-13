package org.example.documentos;

public class Main {
    public static void main(String[] args) {
        Imprimible curriculum = new Curriculum("Juan", "Perez", new String[]{"Java", "Spring", "SQL"});
        Imprimible libroPDF = new LibroPDF("El Quijote", "Miguel de Cervantes", 500, "Novela");
        Imprimible informe = new Informe("Reporte Anual", 30, "Ana Lopez", "Carlos Garcia");

        ImprimirDocumento.imprimir(curriculum);
        ImprimirDocumento.imprimir(libroPDF);
        ImprimirDocumento.imprimir(informe);
    }
}
