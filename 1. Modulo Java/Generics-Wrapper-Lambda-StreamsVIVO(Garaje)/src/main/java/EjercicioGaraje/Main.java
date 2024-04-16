package EjercicioGaraje;
import java.util.ArrayList;
import java.util.List;


//Inicia creando una clase Vehículo con los atributos modelo, marca y costo.
// Luego crea una clase garaje con los atributos id o identificador único y
// una lista de vehículos. Crea además los constructores de las clases y los métodos Setter y Getter.

//Haz una clase Main con el método main para representar un escenario donde se crea una instancia de
// la clase garaje con una lista de vehículos según la tabla
public class Main {
    public static void main(String[] args) {

    Garaje garaje = new Garaje();
    List<Vehiculo> vehiculos = new ArrayList<>();

    garaje.agregarVehiculos();
    garaje.mostrarVehiculos();
    /*
        // Obtener lista de vehículos con precio menor o igual a 1000
        List<Vehiculo> vehiculosPrecioMenorOIgualA1000 =  garaje.obtenerVehiculosConPrecioNoMayorAMil();

        System.out.println("Vehículos con precio menor o igual a 1000:");
        for (Vehiculo vehiculo : vehiculosPrecioMenorOIgualA1000) {
            System.out.println(vehiculo.getMarca() + " " + vehiculo.getModelo() + " Precio: " + vehiculo.getCosto());
        }
        System.out.println();

        // Obtener lista de vehículos con precio mayor o igual a 1000
        List<Vehiculo> vehiculosPrecioMayorOIgualA1000 = garaje.obtenerVehiculosConPrecioMayorAMil();
        System.out.println("Vehículos con precio mayor o igual a 1000:");
        for (Vehiculo vehiculo : vehiculosPrecioMayorOIgualA1000) {
            System.out.println(vehiculo.getMarca() + " " + vehiculo.getModelo() + " Precio: " + vehiculo.getCosto());
        }
        System.out.println();

        // Calcular el promedio de precios de todos los vehículos
        double promedioPrecios = garaje.promedioTotalPrecios();
        System.out.println("Promedio de precios de todos los vehículos: " + promedioPrecios);
    }

*/

    }
}