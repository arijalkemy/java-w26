package EjercicioDocumentos;

public class Informe {
    public Informe(String texto, String autor, String revisor, Integer numeroPaginas) {
        this.texto = texto;
        this.autor = autor;
        this.revisor = revisor;
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "texto='" + texto + '\'' +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                '}';
    }
    private String texto, autor,revisor;
    private Integer numeroPaginas;

}
