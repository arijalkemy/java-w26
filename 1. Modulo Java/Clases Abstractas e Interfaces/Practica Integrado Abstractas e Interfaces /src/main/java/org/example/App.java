package org.example;

import org.example.Clases.Basic;
import org.example.Clases.Cobrador;
import org.example.Clases.Ejecutivo;
import org.example.EjercicioDos.ClasesDocumentos.Curriculums;
import org.example.EjercicioDos.ClasesDocumentos.Informe;
import org.example.EjercicioDos.ClasesDocumentos.Pdf;
import org.example.EjercicioTres.ClasesAnimales.Animal;
import org.example.EjercicioTres.ClasesAnimales.Gato;
import org.example.EjercicioTres.ClasesAnimales.Perro;
import org.example.EjercicioTres.ClasesAnimales.Vaca;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*
        Basic personaBasic = new Basic();
        Cobrador personaCobrador = new Cobrador();
        Ejecutivo personaEjecutivo = new Ejecutivo();

        personaBasic.pagarServicios();
        personaBasic.consultarSaldo();
        personaBasic.retirarEfectivo();
        personaBasic.transaccionOk();
        personaBasic.transaccionNoOk();

        personaCobrador.consultarSaldo();
        personaCobrador.retirarEfectivo();
        personaCobrador.transaccionNoOk();
        personaCobrador.transaccionOk();

        personaEjecutivo.RealizarDeposito();
        personaEjecutivo.realizarTransferencia();
        personaEjecutivo.transaccionNoOk();
        personaEjecutivo.RealizarDeposito();
        */

        /*
        Curriculums curriculums = new Curriculums();
        Informe informe = new Informe();
        Pdf pdf = new Pdf();
        curriculums.imprimirArchivo();
        informe.imprimirArchivo();
        pdf.imprimirArchivo();

         */

        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        gato.comerCarne();
        gato.hacerSonido();

        perro.comerCarne();
        perro.hacerSonido();

        vaca.comerHierba();
        vaca.hacerSonido();


    }
}
