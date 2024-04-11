package Ejercicio2;

public class Informe implements Imprimible{

    String texto;
    int cantidadPaginas;
    String Autor;
    String revisor;

    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }

    public Informe(String texto, int cantidadPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        Autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "texto='" + texto + '\'' +
                ", cantidadPaginas=" + cantidadPaginas +
                ", Autor='" + Autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }
}
