public class main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Lionel Messi");
        IImpribile.imprimir(curriculum);

        LibroPDF libroPDF = new LibroPDF(12, "Ray Bradbury", "Fahrenheit 451", "Ciencia ficcion");
        IImpribile.imprimir(libroPDF);

        Informe informe = new Informe("Historial Academico", 5, "UTN", "Oficina de alumnos");
        IImpribile.imprimir(informe);

    }
}
