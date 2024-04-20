import EjercicioVehiculos.Vehiculo;
import EjercicioVehiculos.VehiculoRepo;
import Supermercado.Cliente;
import Supermercado.Factura;
import Supermercado.Producto;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//EJERCICIO VEHICULOS
        Vehiculo v1=  new Vehiculo("Ford","Fiesta",1000);
        Vehiculo v2=  new Vehiculo("Ford","Focus",1200);
        Vehiculo v3=  new Vehiculo("Ford","Explorer",2500);
        Vehiculo v4=  new Vehiculo("Fiat","Uno",500);
        Vehiculo v5=  new Vehiculo("Fiat","Cronos",1000);
        Vehiculo v6=  new Vehiculo("Fiat","Torino",1250);
        Vehiculo v7=  new Vehiculo("Chevrolet","Aveo",1250);
        Vehiculo v8=  new Vehiculo("Chevrolet","Spin",2500);
        Vehiculo v9=  new Vehiculo("Toyota","Corola",1200);
        Vehiculo v10=  new Vehiculo("Toyota","Fortuner",3000);
        Vehiculo v11=  new Vehiculo("Renault","Logan",950);


        HashMap<Integer,Vehiculo> repoVehiculoHashMap = new HashMap<>();
        repoVehiculoHashMap.put(1,v1);
        repoVehiculoHashMap.put(2,v2);
        repoVehiculoHashMap.put(3,v3);
        repoVehiculoHashMap.put(4,v4);
        repoVehiculoHashMap.put(5,v5);
        repoVehiculoHashMap.put(6,v6);
        repoVehiculoHashMap.put(7,v7);
        repoVehiculoHashMap.put(8,v8);
        repoVehiculoHashMap.put(9,v9);
        repoVehiculoHashMap.put(10,v10);
        repoVehiculoHashMap.put(11,v11);


        System.out.println("--------------------------------");
        repoVehiculoHashMap.
                entrySet().
                stream().sorted(Comparator.comparing(k ->k.getValue().getCosto())).forEach(integerVehiculoEntry -> {
                    System.out.println("Key: "+integerVehiculoEntry.getKey()+" Costo: "+integerVehiculoEntry.getValue().getCosto());
                });
        System.out.println("---------------------------------");
        repoVehiculoHashMap.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<Integer, Vehiculo> entry) -> entry.getValue().getCosto())
                        .thenComparing(entry -> entry.getValue().getMarca()))
                .forEach(entry -> System.out.println(entry.getValue().getMarca() + " " +
                        entry.getValue().getModelo() + " " + entry.getValue().getCosto()));

        System.out.println("---------------------------------");
        repoVehiculoHashMap.entrySet().stream().filter(p -> p.getValue().getCosto()<1000)
                .forEach(q -> System.out.println(q.getValue().getModelo()+"  "+q.getValue().getMarca()+" "+q.getValue().getCosto()));
        System.out.println("---------------------------------");
        repoVehiculoHashMap.entrySet().stream().filter(p -> p.getValue().getCosto()>=1000).
                forEach(q -> System.out.println(q.getValue().getModelo()+"  "+q.getValue().getMarca()+" "+q.getValue().getCosto()));
        System.out.println("---------------------------------");
        double  promedio= repoVehiculoHashMap.entrySet().stream()
                .mapToDouble(x -> x.getValue().getCosto()).average().orElse(0);
        System.out.println("Costo promedio del repo: "+promedio);

        //FIN EJERCICIO VEHICULOS

        //Ejercicio Supermercado

        Cliente cliente1 = new Cliente("1Q2w3e","John","Doe");
        Cliente cliente2 = new Cliente("11223344", "Johana","Doe");
        Cliente cliente3 = new Cliente("1q2w3e4r","Mike","Miers");

        Factura factura1 = new Factura();
        factura1.agregarProductos(new Producto("1","Té",1,25));
        factura1.agregarProductos(new Producto("2","Té",1,50));
        factura1.agregarProductos(new Producto("3","Cacao",5,150));
        cliente1.addFactura(factura1);
        Factura factura2 = new Factura();
        factura2.agregarProductos(new Producto("4","Chocolate",1,100));
        cliente1.addFactura(factura2);

        List<Cliente> listaClientes= new ArrayList<>();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);
        for (Cliente c: listaClientes
             ) {
            imprimir(c.toString());

        }
        listaClientes.remove(cliente3);
        for (Cliente c: listaClientes
        ) {
            imprimir(c.toString());

        }
        factura1.retirarProducto("1");


    }

    public static void imprimir(String msj){
        System.out.println(msj);
    }
}
