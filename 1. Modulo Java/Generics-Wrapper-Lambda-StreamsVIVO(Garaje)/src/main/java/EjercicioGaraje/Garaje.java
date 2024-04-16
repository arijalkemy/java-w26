package EjercicioGaraje;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Garaje {
    private int id;
    private List<Vehiculo> listaVehiculos = new ArrayList<>();


    public void agregarVehiculos(){
        this.listaVehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        this.listaVehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        this.listaVehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        this.listaVehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        this.listaVehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        this.listaVehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        this.listaVehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        this.listaVehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        this.listaVehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        this.listaVehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        this.listaVehiculos.add(new Vehiculo("Renault", "Logan", 950));

    }

    public void mostrarVehiculos(){
        for (Vehiculo vehiculo: listaVehiculos){
            System.out.println("Vehiculo:" + vehiculo.getMarca() + " "
                    + vehiculo.getModelo() + " " + vehiculo.getCosto()
            );
        }
    }
    //Haciendo uso del método sort en la lista de Vehículos con expresiones lambda,
    // obtén una lista de vehículos ordenados por precio de menor a mayor, imprime por pantalla el resultado.
    public void ordenarPorPrecio(){
        listaVehiculos.sort(Comparator.comparingDouble(Vehiculo::getCosto));
    }
//De la misma forma que el ejercicio anterior, imprime una lista ordenada por marca y a su vez por precio.

    public void ordenarPorMarcaYPrecio(){
        listaVehiculos.sort(
         Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getCosto));
    }
    //Se desea extraer una lista de vehículos con precio no mayor a 1000, luego otra con precios mayor o igual 1000 y por último,
    // obtén el promedio total de precios de toda la lista de vehículos.

    public List<Vehiculo> obtenerVehiculosConPrecioNoMayorAMil(){
        //itero la lista y devuelvo los menores de 1000 guardo los menores en una lista

        List<Vehiculo> vehiculosMenores =  new ArrayList<>();

       for(Vehiculo vehiculo : listaVehiculos){
           if (vehiculo.getCosto() <= 1000){
               vehiculosMenores.add(vehiculo);
           }
       }
       return vehiculosMenores;
    }

    public List<Vehiculo> obtenerVehiculosConPrecioMayorAMil(){
        //itero la lista y devuelvo los menores de 1000 guardo los menores en una lista

        List<Vehiculo> vehiculosMayores =  new ArrayList<>();

        for(Vehiculo vehiculo : listaVehiculos){
            if (vehiculo.getCosto() >= 1000){
                vehiculosMayores.add(vehiculo);
            }
        }
        return vehiculosMayores;
    }

    //promedio sumo todos los veiculos de la lista y divido por el total

    public double promedioTotalPrecios(){
        double total = 0;

        for (Vehiculo vehiculo : listaVehiculos){
            total += vehiculo.getCosto();
        }
        return total/listaVehiculos.size();
    }


    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
}
