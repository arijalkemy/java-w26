package org.example;

public class Distribuidora {
    public static void main(String[] args) {
        Producto[] productos = new Producto[4];
        productos[0] = new Perecedero("Leche", 1.50, 2);
        productos[1] = new Perecedero("Queso", 5.00, 3);
        productos[2] = new NoPerecedero("Arroz", 0.90, "Alimento Básico");
        productos[3] = new NoPerecedero("Conserva de Atún", 2.50, "Alimento Enlatado");

        for (Producto producto : productos) {
            System.out.println(producto);
            System.out.println("Precio total por 5 unidades: " + producto.calcular(5));
        }
    }
}

