import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vehiculo vehiculo12 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo vehiculo13 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo vehiculo14 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo vehiculo15 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo vehiculo16 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo vehiculo17 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo vehiculo18 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo vehiculo19 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo vehiculo20 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo vehiculo21 = new Vehiculo("Renault", "Logan", 950);

        List<Vehiculo> listaVehiculos = new ArrayList<>();
        listaVehiculos.add(vehiculo12);
        listaVehiculos.add(vehiculo13);
        listaVehiculos.add(vehiculo14);
        listaVehiculos.add(vehiculo15);
        listaVehiculos.add(vehiculo16);
        listaVehiculos.add(vehiculo17);
        listaVehiculos.add(vehiculo18);
        listaVehiculos.add(vehiculo19);
        listaVehiculos.add(vehiculo20);
        listaVehiculos.add(vehiculo21);

        Garaje garaje = new Garaje(1, listaVehiculos);
        System.out.println("ORDENADO POR PRECIO ASCENDENTE");
        garaje.ordenarVehiculos();
        System.out.println("ORDENADOR POR MARCA Y PRECIO");
        garaje.ordenarPorMarcaYprecio();
        System.out.println("FILTRAR COCHES MENORES A MIL");
        garaje.cochesMenoresAMil();
        System.out.println("FILTRA COCHES MAYOR A MIL");
        garaje.cochesMayoresAMil();
        System.out.println("PROMEDIO DE PRECIOS");
        garaje.promedioDePrecio();
    }
}