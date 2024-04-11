package org.example;

import org.example.animal.Gato;
import org.example.animal.Perro;
import org.example.animal.Vaca;
import org.example.cliente.Basic;
import org.example.imprimible.Curriculum;
import org.example.imprimible.Imprimible;
import org.example.imprimible.Informe;
import org.example.imprimible.LibroPDF;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Ejercicio 1
        System.out.println( " EJERCICIO 1 : \n\n");
        Basic b = new Basic();
        b.consultarSaldo();
        b.transaccionOk();

        //Ejercicio 2
        System.out.println( "\n\n EJERCICIO 2 : \n\n");
        Curriculum cv = new Curriculum("Franco", "fmoises@gmail.com",List.of("Proactividad", "Autodidacta"));
        Informe inf = new Informe(123, 56, "Borges", "Franco");
        LibroPDF libro = new LibroPDF(32, "Stephen King","IT", "Terror");
        List<Imprimible> documentos = List.of(cv, inf, libro);
        documentos.forEach(Imprimible::imprimir);

        //Ejercicio 3
        System.out.println( "\n\n EJERCICIO 3 : \n\n");
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        gato.comerCarne();
        gato.emitirSonido();

        vaca.comerHierba();
        vaca.emitirSonido();

        perro.comerCarne();
        perro.emitirSonido();
    }
}
