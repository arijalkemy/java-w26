import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Se crea la lista de vehiculos y se carga la información
        List<Vehiculo> v = new ArrayList<>();
        v.add(new Vehiculo("Ford","Fiesta",1000));
        v.add(new Vehiculo("Ford","Focus",1200));
        v.add(new Vehiculo("Ford","Explorer",2500));
        v.add(new Vehiculo("Fiat","Uno",500));
        v.add(new Vehiculo("Fiat","Cronos",1000));
        v.add(new Vehiculo("Fiat","Torino",1250));
        v.add(new Vehiculo("Chevrolet","Aveo",1250));
        v.add(new Vehiculo("Chevrolet","Spin",2500));
        v.add(new Vehiculo("Toyota","Corola",1200));
        v.add(new Vehiculo("Toyota","Fortuner",3000));
        v.add(new Vehiculo("Renault","Logan",950));
        //Se crea el garaje y se cargan los vehiculos almacenados en él
        Garaje g = new Garaje(1,v);
        //Se hace uso del metodo ordenar por precio y se imprime
        g.ordenaPrecio();
        System.out.println("*************************************");
        //Se hace uso del metodo ordenar por marca y precio y se imprime
        g.ordenaMarcaPrecio();
        System.out.println("*************************************");
        //Se hace uso del metodo obtener todos los vehiculos y se imprime
        g.seleccionVehiculos();
    }
}