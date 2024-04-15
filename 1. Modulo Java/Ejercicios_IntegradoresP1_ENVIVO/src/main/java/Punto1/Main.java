package Punto1;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private Repositorio repositorio1 = new Repositorio();
    public void ejecutarEscenario() {
        System.out.println("--------------------------------------------");
        Cliente cliente = new Cliente("1A","Juan Rodriguez");
        Cliente cliente1 = new Cliente("1B","Juana Rodriguez");
        repositorio1.agregarCliente(cliente);
        Localizador localizador1 = new Localizador("Locc001",cliente);
        localizador1.agregarReserva(new Reserva("Hotel", 21000));
        localizador1.agregarReserva(new Reserva("Comida", 100000));
        localizador1.agregarReserva(new Reserva("Boleto de viaje", 158788));
        localizador1.agregarReserva(new Reserva("Transporte", 500393));
        localizador1.agregarDescuento(10);
        localizador1.imprimirDetalle();
        System.out.println("--------------------------------------------");
        Localizador localizador2 = new Localizador("LOC002", cliente);
        localizador2.agregarReserva(new Reserva("Hotel", 200000));
        localizador2.agregarReserva(new Reserva("Hotel", 2000000));
        localizador2.agregarReserva(new Reserva("Boleto de viaje", 1500000));
        localizador2.agregarReserva(new Reserva("Boleto de viaje", 150000));
        localizador2.agregarDescuento(5);
       localizador2.imprimirDetalle();
        System.out.println("--------------------------------------------");
        Localizador localizador3 = new Localizador("LOC003", cliente1);
        localizador3.agregarReserva(new Reserva("Hotel", 200000));
        localizador3.agregarDescuento(5);
        localizador3.imprimirDetalle();
        System.out.println("--------------------------------------------");
        /*Parte 2*/
        List<Localizador> localizares = Arrays.asList(localizador1,localizador2,localizador3);
        Analizador analizar = new Analizador(localizares);
        System.out.println("Total de analizadores vendidos: "+analizar.getCantidadLocalizadoresv());
        System.out.println("Total de reservas: "+analizar.getCatidadRevervas());
        Map<String, Integer> reservasPorTipo = analizar.getReservasPorTipo();
        System.out.println("Reservas por tipo: ");
        reservasPorTipo.forEach((tipo, cantidad) -> System.out.println(tipo + ": " + cantidad));
        System.out.println("Total de ventas: $" + analizar.getTotalDeVentas());
        System.out.println("Promedio de ventas: $" + analizar.getPromedioVentas());
    }
    public static void main(String[] args) {
        new Main().ejecutarEscenario();
    }
}