package punto2;
/*Creación de la clase Informe que implementa Imprimible*/
public class Informe implements Imprimible {
    private int longitud;
    private int cantPaginas;
    private String autor;
    private String revisor;
/*Constructor*/
    public Informe(int longitud, int cantPaginas, String autor, String revisor) {
        this.longitud = longitud;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }
//Override del obtenerContenidoParaImprimir establecido en la interfaz Imprimible
    @Override
    public String obtenerContenidoParaImprimir() {
        return "Longitu: "+longitud+"Cant pag: "+cantPaginas+"Autor: "+autor+"Revisor: "+revisor;
    }
}
