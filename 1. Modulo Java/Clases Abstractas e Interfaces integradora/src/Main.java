import ex1.Basic;
import ex1.Colaborador;
import ex1.Ejecutivo;
import ex2.Curriculum;
import ex2.Informes;
import ex2.PDF;
import ex2.Persona;
import ex3.Gato;
import ex3.Perro;
import ex3.Vaca;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ///////// EX1
        Basic basic = new Basic();
        Colaborador colaborador = new Colaborador();
        Ejecutivo ejecutivo = new Ejecutivo();
        basic.consultarSaldo();
        basic.transaccionOK();
        colaborador.retiroDeEfectivo();
        ejecutivo.transferencia();


        ////////// EX2
        Utils utils = new Utils();
        Persona persona = new Persona("Carlos","Smith");
        Curriculum curriculum = new Curriculum(persona, List.of("Proactivo","Habil"));
        PDF pdf = new PDF("Luna",312,"Lo que el viento se llevo","Terror");
        Informes informes = new Informes("Habia una vez...", 421,"Yo","El");
        utils.imprimir(curriculum);
        utils.imprimir(pdf);
        utils.imprimir(informes);


        ////////// EX3

        Vaca vaca = new Vaca();
        Gato gato = new Gato();
        Perro perro = new Perro();

        vaca.comerHierba();
        vaca.emitirSonido();

        gato.comerCarne();
        gato.emitirSonido();

        perro.comerCarne();
        perro.emitirSonido();
    }
}