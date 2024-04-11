package org.main.ejercicio2;
import org.main.ejercicio2.clases.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Informe informe = new Informe(10, "Juan", "Pedro", "Contenido del informe");
        informe.imprimir(informe);

    }
}
