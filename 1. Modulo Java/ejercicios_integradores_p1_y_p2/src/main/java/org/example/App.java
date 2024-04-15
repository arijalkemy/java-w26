package org.example;

import org.example.ejercicio_clases_abstractas.SerieProductoEnteros;
import org.example.ejercicio_clases_abstractas.SerieSumaEnteros;
import org.example.ejercicio_integrador_parte_1_y_2.Client;
import org.example.ejercicio_integrador_parte_1_y_2.Factura;
import org.example.ejercicio_integrador_parte_1_y_2.Item;
import org.example.ejercicio_integrador_parte_1_y_2.Supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    // Ejercicio Algoritmos de Ordenamiento
    public static int[] burbuja(int[] array) {
        int n = array.length;
        boolean intercambio;

        for (int paso = 0; paso < n - 1; paso++) {
            intercambio = false;
            for (int i = 0; i < n - paso - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    intercambio = true;
                }
            }
            if (!intercambio) {
                break;
            }
        }
        return array;
    }

    public static void imprimirArreglo(int[] array) {
        for (int elemento : array) {
            System.out.print(elemento + " ");
        }
    }

    public static void main( String[] args ) {
        // Ejercicio Algoritmos de Ordenamiento
        int[] array = {5, 2, 9, 1, 5, 6};
        burbuja(array);
        imprimirArreglo(array);
        System.out.println("\n");

        // Ejercicio Clases Abstractas
        System.out.println("Serie de Suma de Enteros con valor inicial 2:");
        SerieSumaEnteros serieSumaEnteros = new SerieSumaEnteros();
        serieSumaEnteros.setValorInicial(2);
        for(int i = 0; i < 10; i++) {
            System.out.println(serieSumaEnteros.obtenerValorSiguiente());
        }

        System.out.println("\nReiniciamos la Serie de Suma de Enteros y volvemos a obtener valores:");
        serieSumaEnteros.reiniciar();
        for(int i = 0; i < 10; i++) {
            System.out.println(serieSumaEnteros.obtenerValorSiguiente());
        }

        System.out.println("\nEstablecemos nuevo valor inicial para la Serie de Suma de Enteros:");
        serieSumaEnteros.setValorInicial(3);
        for(int i = 0; i < 10; i++) {
            System.out.println(serieSumaEnteros.obtenerValorSiguiente());
        }

        System.out.println("\nSerie de Suma de Producto de Enteros con valor inicial 2:");
        SerieProductoEnteros serieProductoEnteros = new SerieProductoEnteros();
        serieProductoEnteros.setValorInicial(2);
        for(int i = 0; i < 10; i++) {
            System.out.println(serieProductoEnteros.obtenerValorSiguiente());
        }

        // Ejercicio Integrador Parte 1
        List<Client> clientes = new ArrayList<>();
        Client clienteUno = new Client("39001122", "Jose", "Fernandez");
        Client clienteDos = new Client("39445566", "Juan", "Hernandez");
        Client clienteTres = new Client("39556677", "Matias", "Sosa");
        Client clienteCuatro = new Client("47885566", "Santiago", "Giordano");
        clientes.add(clienteUno);
        clientes.add(clienteDos);
        clientes.add(clienteTres);

        Supermercado supermercado = new Supermercado("Supermercadito 'El Económico'");
        supermercado.setClientes(clientes);

        System.out.println("\nDatos de los Clientes:");
        supermercado.mostrarDatosDeClientes();

        System.out.println("\nLa lista de Clientes resultantes luego de eliminar al Cliente con DNI " + clienteDos.getDni() + " es:");
        supermercado.eliminarCliente(clienteDos);
        supermercado.mostrarDatosDeClientes();

        System.out.println("\nIngrese el DNI del cliente que busca:");
        Scanner scanner = new Scanner(System.in);
        String dniIngresado = scanner.nextLine();
        scanner.close();
        supermercado.buscarCliente(dniIngresado);

        // Ejercicio Integrador Parte 2
        List<Item> items = new ArrayList<>() {{
            add(new Item(1, "Fideos", 10, 10));
            add(new Item(2, "Atún", 3, 30));
            add(new Item(3, "Gaseosa", 5, 15));
        }};
        Factura factura = new Factura(clienteCuatro, items);
        supermercado.agregarFactura(factura);

        System.out.println("\nLista de Clientes actualizada del supermercado:");
        supermercado.mostrarDatosDeClientes();
    }
}
