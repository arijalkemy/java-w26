import EjercicioAnimales.Animal;
import EjercicioAnimales.Gato;
import EjercicioAnimales.Perro;
import EjercicioAnimales.Vaca;
import EjercicioBanco.Cobrador;
import EjercicioBanco.Ejecutivo;
import EjercicioDocumentos.Curriculum;
import EjercicioDocumentos.Informe;
import EjercicioDocumentos.PDF;

import java.util.ArrayList;
import java.util.List;

import static EjercicioDocumentos.Imprimible.imprimirDocumento;
import static EjercicioDocumentos.Imprimible.tipoDocumento;

public class Main {
    public static void main(String[] args) {
        //_____________________BANCO
        List<String> listaEjecutivo= new ArrayList<>();
        listaEjecutivo.add("Depósitos");
        listaEjecutivo.add("Transferencias");
        Ejecutivo ejecutivo1 = new Ejecutivo(listaEjecutivo);
        ejecutivo1.intentarTransaccion("Depósitos");
        ejecutivo1.intentarTransaccion("Transferenciass");

        List<String> listaBasic= new ArrayList<>();
        listaBasic.add("Consultas de saldo");
        listaBasic.add("Pagos de servicios");
        listaBasic.add("Retiro de efectivo");
        Ejecutivo basic1 = new Ejecutivo(listaBasic);
        basic1.intentarTransaccion("Consultas de saldo");
        basic1.intentarTransaccion("Pagos de servicios");
        basic1.intentarTransaccion("Retiro de efectivo");

        List<String> listaCobrador= new ArrayList<>();
        listaCobrador.add("retiro de efectivo");
        listaCobrador.add("consulta de saldos");
        Cobrador cobrador =new Cobrador(listaCobrador);
        cobrador.intentarTransaccion("Pago de servicios");

        //DOCUMENTOS________
        Curriculum curriculum = new Curriculum("Francisco",12,listaBasic);
        System.out.println( imprimirDocumento(curriculum));
        System.out.println(tipoDocumento(curriculum));
        PDF pdf = new PDF("Francisco","12 cosas","listaBasic");
        System.out.println( imprimirDocumento(pdf));
        System.out.println(tipoDocumento(pdf));
        Informe informe = new Informe("Franciscoaaaaa","Pancho","listaBasic,213",234);
        System.out.println( imprimirDocumento(informe));
        System.out.println(tipoDocumento(informe));
        //ANIMALES-----------
        Animal perro = new Perro("Guau","Perro");
        Vaca vaca= new Vaca("Muuu","Vaca");
        Gato gato = new Gato("Miau","Gato");
        perro.getSonido();
        vaca.comerHierba();
        gato.comerAnimal(vaca);

    }

}
