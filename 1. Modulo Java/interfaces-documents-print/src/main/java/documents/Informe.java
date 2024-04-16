package documents;

public class Informe implements ArchivoImprimible {
    private String text;
    private int cantidadDePaginas;
    private String autor;
    private String revisor;

    public Informe(String text, int cantidadDePaginas, String autor, String revisor) {
        this.text = text;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }


    public void imprimir() {
        System.out.println( "Informe{" +
                "text='" + text + '\'' +
                ", cantidadDePaginas=" + cantidadDePaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}');
    }
}
