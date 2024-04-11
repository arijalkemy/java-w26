public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Agustin", 22, "Programación, Diseño Gráfico");
        LibroPDF libro = new LibroPDF(200, "Charles", "Tecnología", "Educación");
        Informe informe = new Informe("Informe sobre ventas del último trimestre", 10, "Martin", "Pedro");

        // Imprimir los documentos
        Impresora.imprimirDocumento(curriculum);
        Impresora.imprimirDocumento(libro);
        Impresora.imprimirDocumento(informe);
    }
}
