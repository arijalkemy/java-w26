package org.products;


public class Main {
    public static void main(String[] args) {
        Distribuidora distribuidora = new Distribuidora();

        // Perecederos
        for (int i = 0; i < 5; i++) {
            Perecedero nuevoProductoPerecedero = new Perecedero();
            nuevoProductoPerecedero.setDiasPorCaducar(i + 1);
            nuevoProductoPerecedero.setNombre("Perecedero_" + i);
            nuevoProductoPerecedero.setPrecio(10 + i * 5);
            distribuidora.agregarProducto(nuevoProductoPerecedero);
        }

        // No perecederos
        for (int i = 0; i < 5; i++) {
            NoPerecedero nuevoProductoNoPerecedero = new NoPerecedero();
            nuevoProductoNoPerecedero.setNombre("No_Perecedero_" + i);
            nuevoProductoNoPerecedero.setPrecio(10 + i * 5);
            nuevoProductoNoPerecedero.setTipo("Tipo_del_producto_no_perecedero_" + i);
            distribuidora.agregarProducto(nuevoProductoNoPerecedero);
        }

        System.out.println("Productos originalmente: ");
        System.out.println(distribuidora.productos);

        System.out.println("Calculo el precio de los primeros 3 productos perecederos: ");
        distribuidora.calcularPrecioPerecedero("Perecedero_0", 1);
        distribuidora.calcularPrecioPerecedero("Perecedero_1", 1);
        distribuidora.calcularPrecioPerecedero("Perecedero_2", 1);
        System.out.println("Productos ahora: ");
        System.out.println(distribuidora.productos);

        double precioDeLaVenta = 0;

        precioDeLaVenta = precioDeLaVenta + distribuidora.venderProducto("Perecedero_0");
        precioDeLaVenta = precioDeLaVenta + distribuidora.venderProducto("Perecedero_1");
        precioDeLaVenta = precioDeLaVenta + distribuidora.venderProducto("Perecedero_2");
        precioDeLaVenta = precioDeLaVenta + distribuidora.venderProducto("Perecedero_3");
        precioDeLaVenta = precioDeLaVenta + distribuidora.venderProducto("Perecedero_4");
        precioDeLaVenta = precioDeLaVenta + distribuidora.venderProducto("No_Perecedero_0");
        precioDeLaVenta = precioDeLaVenta + distribuidora.venderProducto("No_Perecedero_1");
        precioDeLaVenta = precioDeLaVenta + distribuidora.venderProducto("No_Perecedero_2");
        precioDeLaVenta = precioDeLaVenta + distribuidora.venderProducto("No_Perecedero_3");
        precioDeLaVenta = precioDeLaVenta + distribuidora.venderProducto("No_Perecedero_4");

        System.out.println("Vender productos, precio de la venta = " + precioDeLaVenta +", lista de productos: ");
        System.out.println(distribuidora.productos);

    }
}
