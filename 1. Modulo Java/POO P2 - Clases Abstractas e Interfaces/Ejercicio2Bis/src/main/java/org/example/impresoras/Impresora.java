package org.example.impresoras;

import org.example.archivos.Archivo;

public class Impresora <T extends Archivo>{
    public void imprimir(T archivo){
        System.out.println(archivo.getContenido());
    }
}
