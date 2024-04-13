public class Informe implements IDocumento{
    private String texto;
    private int cantidadDePaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, int cantidadDePaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Informe{");
        sb.append("texto='").append(texto).append('\'');
        sb.append(", cantidadDePaginas=").append(cantidadDePaginas);
        sb.append(", autor='").append(autor).append('\'');
        sb.append(", revisor='").append(revisor).append('\'');
        sb.append('}');
        return sb.toString();
    }
}