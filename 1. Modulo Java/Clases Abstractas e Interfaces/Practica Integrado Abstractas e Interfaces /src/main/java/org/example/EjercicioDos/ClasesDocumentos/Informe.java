package org.example.EjercicioDos.ClasesDocumentos;

import org.example.EjercicioDos.InterfacesDocumentos.Imprimir;

public class Informe implements Imprimir {

    String texto = "25";
    int cantidadPaginas= 23;
    String autor = "Juan";
    String revisor = "Facundo";

    @Override
    public void imprimirArchivo() {
        String mensaje = this.toString();
        System.out.println(mensaje);
    }
    @Override
    public String toString() {
        return "Informe{" +
                "texto='" + texto + '\'' +
                ", cantidadPaginas=" + cantidadPaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }
}
