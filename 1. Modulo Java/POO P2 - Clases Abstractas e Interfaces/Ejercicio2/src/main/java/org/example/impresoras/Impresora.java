package org.example.impresoras;

import org.example.archivos.Archivo;

public class Impresora{
    public static void imprimir(Archivo archivo){
        System.out.println(archivo.getContenido());
    }
}
