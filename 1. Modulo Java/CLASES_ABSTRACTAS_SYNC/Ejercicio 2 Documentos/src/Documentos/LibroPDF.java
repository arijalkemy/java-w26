package Documentos;

public class LibroPDF implements IDocumento{

    private int cantidadPaginas;

    private String autor;
    private String titulo;
    private String genero;

    

    public LibroPDF(int cantidadPaginas, String autor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    


    @Override
    public String toString() {
        return "LibroPDF [cantidadPaginas=" + cantidadPaginas + ", autor=" + autor + ", titulo=" + titulo + ", genero="
                + genero + "]";
    }




    @Override
    public void imprimir() {
        System.out.println(this);
    }

}
