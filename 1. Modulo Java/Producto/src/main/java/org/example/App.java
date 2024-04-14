package org.example;

public class App 
{
    public static void main( String[] args )
    {
        Producto[] productos = new Producto[10];
        double total = 0.00f;

        for(int i = 0; i < productos.length; i++){
            productos[i] = i < 5 ?
                productos[i] =  new NoPerecedero("Producto No Perecedero " + i, (int)(Math.random() * 200 + 1), "No Pedecedero") :
                    new Perecedero("Producto Perecedero " + i, (int)(Math.random() * 200 + 1), (int)(Math.random() * 4 + 1));

        }

        for(int i = 0; i<productos.length; i++){
            total = total + productos[i].calcular(i + 5);
        }
        for (Producto producto : productos) {
            System.out.println(producto.toString() + '\n');
        }

        System.out.println("Total: " + total);
    }
}
