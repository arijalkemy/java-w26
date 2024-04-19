package EjercicioDocumentos;

public class PDF {
    public PDF(String autor, String titulo, String genero) {
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    private  String autor, titulo, genero;

    @Override
    public String toString() {
        return "PDF{" +
                "autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
