package org.example;

import java.util.*;

import org.example.Productos.Producto;
import org.example.Productos.Hotel;

public class Gestor<T> {
    static private App app;

    public static void setApp(App app)
    {
        Gestor.app = app;
    }
    // Localizadores = Reserva
    // Reserva = Paquete
    public static void mostrarTotalLocalizadores()
    {
        System.out.println("Total de localizadores: " + app.getReservaciones().getListaReserva().size());
    }

    public static void mostrarCantidadProductos()
    {
        int cantidadProductos = app.getReservaciones().getListaReserva().stream().mapToInt(Reserva::cantidadProductosPaquete).sum();
        System.out.println("Total de productos: " + cantidadProductos);
    }

    //AQUI DICCIONARIO PRO :)


    public static double calcularTotalDeVentas(boolean conDescuento)
    {
        double totalVentas = 0;

        if (!conDescuento) {
            totalVentas = app.getReservaciones().getListaReserva().stream().mapToDouble(Reserva::getValorTotal).sum();
            return totalVentas;
        }
        totalVentas = app.getReservaciones().getListaReserva().stream().mapToDouble(Reserva::getValorFinal).sum();
        return totalVentas;
    }

    public static void mostrarPromedioVentas(double ventasTotales)
    {
        int cantidadReservas = app.getReservaciones().getListaReserva().size();
        double promedio = (ventasTotales/cantidadReservas);
        System.out.printf("Promedio: %.3f \n", promedio);
    }

    public static void obtenerDiccionario()
    {
        Map<String, List<Producto> > diccionario = new HashMap<>();

        List<Producto> hoteles = new ArrayList<>();
        diccionario.put("Hotel", hoteles);

        List<Producto> comida = new ArrayList<>();
        diccionario.put("Comida", comida);

        List<Producto> transporte = new ArrayList<>();
        diccionario.put("Transporte", transporte);

        List<Producto> boleto = new ArrayList<>();
        diccionario.put("Boleto", boleto);

        app.getReservaciones().getListaReserva().stream().forEach(reserva -> {
            diccionario.get("Hotel").addAll(reserva.getPaquete().getHotels());
            diccionario.get("Comida").addAll(reserva.getPaquete().getComidas());
            diccionario.get("Transporte").addAll(reserva.getPaquete().getTransportes());
            diccionario.get("Boleto").addAll(reserva.getPaquete().getBoletos());
        });

        for (Map.Entry<String, List<Producto>> keyValue: diccionario.entrySet()) {
            System.out.println(keyValue.toString());
        }
    }


}
