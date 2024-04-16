package agencia;

import agencia.productos.Producto;
import agencia.productos.ProductoTypes;
import agencia.productos.Repositorio;

public class Main {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("11222333", "Juan Lopez");
        Localizador localizador = new Localizador(cliente);
        Repositorio repo = new Repositorio();

        System.out.println("Agrego un paquete completo");
        localizador.agregarProducto(new Producto(10.0, ProductoTypes.BOLETO));
        localizador.agregarProducto(new Producto(10.0, ProductoTypes.COMIDA));
        localizador.agregarProducto(new Producto(10.0, ProductoTypes.TRANSPORTE));
        localizador.agregarProducto(new Producto(10.0, ProductoTypes.RESERVA_HOTEL));
        localizador.cerrarOrden(repo);

        // Como agrege un paquete completo deberia tener descuento del 10%
        System.out.println(localizador.getPrecio());

        System.out.println("Agrego promo 2 boletos + 2 reservas");
        localizador.agregarProducto(new Producto(20.0, ProductoTypes.BOLETO));
        localizador.agregarProducto(new Producto(20.0, ProductoTypes.BOLETO));
        localizador.agregarProducto(new Producto(30.0, ProductoTypes.RESERVA_HOTEL));
        localizador.agregarProducto(new Producto(30.0, ProductoTypes.RESERVA_HOTEL));
        localizador.cerrarOrden(repo);

        // Como agrege una promo del 5% deberia tener descuento del 10% + el de 5%
        System.out.println(localizador.getPrecio());

        // Agrego al repo el localizador
        repo.agregarARepositorio(cliente.getDni(), localizador);

        // Otro localizador del mismo cliente
        Localizador otroLocalizador = new Localizador(cliente);
        otroLocalizador.agregarProducto(new Producto(100.0, ProductoTypes.BOLETO));
        otroLocalizador.cerrarOrden(repo);

        // Agrego al repo el nuevo localizador
        repo.agregarARepositorio(cliente.getDni(), otroLocalizador);

        // Otro localizador del mismo cliente
        Localizador otroLocalizadorMas = new Localizador(cliente);
        otroLocalizadorMas.agregarProducto(new Producto(100.0, ProductoTypes.BOLETO));
        otroLocalizadorMas.cerrarOrden(repo);

        // Agrego al repo el nuevo localizador
        repo.agregarARepositorio(cliente.getDni(), otroLocalizadorMas);

        System.out.println("Como tengo 2 localizadores deberia tener descuento del 0.05");
        System.out.println(otroLocalizadorMas.getPrecio());


    }
}
