public interface Imprimible {
    static <T> void imprimirDocumento(T documento) {
        if (documento instanceof Curriculum) {
            Curriculum curriculum = (Curriculum) documento;
            System.out.println("Imprimiendo Curriculum:");
            System.out.println("Nombre: " + curriculum.getNombre());
            System.out.println("Edad: " + curriculum.getEdad());
            System.out.println("Habilidades:");
            for (String habilidad : curriculum.getHabilidades()) {
                System.out.println("- " + habilidad);
            }
        } else if (documento instanceof LibroPDF) {
            LibroPDF libroPDF = (LibroPDF) documento;
            System.out.println("Imprimiendo Libro en PDF:");
            System.out.println("Título: " + libroPDF.getTitulo());
            System.out.println("Autor: " + libroPDF.getAutor());
            System.out.println("Género: " + libroPDF.getGenero());
            System.out.println("Cantidad de páginas: " + libroPDF.getCantidadPaginas());
        } else if (documento instanceof Informe) {
            Informe informe = (Informe) documento;
            System.out.println("Imprimiendo Informe:");
            System.out.println("Autor: " + informe.getAutor());
            System.out.println("Revisor: " + informe.getRevisor());
            System.out.println("Cantidad de páginas: " + informe.getCantidadPaginas());
            System.out.println("Contenido: " + informe.getTexto());
        } else {
            System.out.println("Tipo de documento no válido.");
        }
    }
}