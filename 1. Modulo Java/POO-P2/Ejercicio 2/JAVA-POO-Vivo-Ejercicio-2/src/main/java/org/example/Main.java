package org.example;

public class Main {
    public static void main(String[] args) {
        // Productos Perecederos
        Perishable perishable = new Perishable(10, "Jugo", 10.0d);
        Perishable perishable1 = new Perishable(1, "Fruta", 30.0d);
        Perishable perishable2 = new Perishable(3, "Carne", 40.0d);

        // Productos no perecederos
        NoPerishable noPerishable = new NoPerishable("Natural", "Miel", 10.0);
        NoPerishable noPerishable1 = new NoPerishable("Natural", "Pasta", 5.0d);

        // Cargar productos a la distribuidora
        Distributor distributor = new Distributor();
        distributor.getProductos().add(perishable);
        distributor.getProductos().add(perishable1);
        distributor.getProductos().add(perishable2);
        distributor.getProductos().add(noPerishable);
        distributor.getProductos().add(noPerishable1);

        // Calcular suma de precios
        double sum = 0.0d;
        for(Product pro: distributor.getProductos()){
            System.out.println(pro.toString());
            sum += pro.calculatePrice(5);
        }
        System.out.println(String.format("Sumatoria de los productos: %f", sum));

        distributor.toString();
    }
}