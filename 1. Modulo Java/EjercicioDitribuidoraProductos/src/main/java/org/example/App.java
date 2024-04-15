package org.example;

import java.util.ArrayList;

public class App {
    //Metodo main
    public static void main(String[] args) {
        //Declarando una lista de productos
        ArrayList<Producto> productos=new ArrayList<>();
        //Declarando, inicializando y agregando objetos de tipo Perecedero a la lista productos.
        productos.add(new Perecedero("papas",15,1));
        productos.add(new Perecedero("platano",5,3));
        productos.add(new Perecedero("tomate",8,2));
        productos.add(new Perecedero("uva",3,3));
        productos.add(new Perecedero("cebola",4,1));
        //Declarando, inicializando y agregando objetos de tipo NoPerecedero a la lista productos.
        productos.add(new NoPerecedero("TV",100,"electrodomestico"));
        productos.add(new NoPerecedero("Sillon",200,"mueble"));
        productos.add(new NoPerecedero("Colchon",300,"mueble"));
        productos.add(new NoPerecedero("Celular",200,"electronico"));
        productos.add(new NoPerecedero("Switch",100,"electronico"));


        double resultado=0; //variable double resultado que almacenara el resultado del total de todos los productos
        for(Producto producto: productos){ //bucle que itera la lista productos
            resultado=resultado+producto.calcular((int)(Math.random()*10+1));//crea un numero random sobre el numero de productos y va sumando el total en resultados
        }
        System.out.println("El total de vender 5 productos de cada tipo es:$"+resultado); //Escribiendo en pantalla el total
    }
}
