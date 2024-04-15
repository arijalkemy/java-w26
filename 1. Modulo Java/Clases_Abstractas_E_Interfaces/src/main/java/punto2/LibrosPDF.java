package punto2;
/*Clase que implementa la interfaz Imprimible*/
public class LibrosPDF implements Imprimible{
    private int numPaginas;
    private String titulo;
    private String autor;
    private String genero;
/*Contructor*/
    public LibrosPDF(int numPaginas, String titulo, String autor, String genero) {
        this.numPaginas = numPaginas;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
    }
//Override del obtenerContenidoParaImprimir establecido en la interfaz Imprimible
    @Override
    public String obtenerContenidoParaImprimir() {
        return "Num paginas: "+numPaginas+" - Titulo: "+titulo+" - Autor - :"+autor+" - Género :"+genero;
    }
}
