package com.example;

public class Main {
    public static void main(String[] args) {
        Loader.load();
        Garaje garage = new Garaje(Loader.VEHICULOS);

        System.out.println("---------- VEHICULOS SIN PROCESAR ------------");

        Loader.VEHICULOS.forEach(System.out::print);
        
        System.out.println("------------ ORDENA POR PRECIO -------------");
        garage
            .ordenarVehiculosPorPrecioAsc()
            .forEach(System.out::print);

        System.out.println("------------ ORDENA POR MARCA Y PRECIO -------------");
        garage
            .ordenarVehiculoPorMarcaYPrecio()
            .forEach(System.out::print);

        System.out.println("---------- TRAE TODOS LOS VEHICULOS CON COSTO IGUAL O MENOS A 1000 ----------------");
        garage
            .obtenerVehiculosMenoresIgual(1000)
            .forEach(System.out::print);

        System.out.println("---------- TRAE TODOS LOS VEHICULOS CON COSTO IGUAL O MAYOR A 1000 ----------------");
        garage
            .obtenerVehiculosMayorIgual(1000)
            .forEach(System.out::print);

        System.out.println("---------- PROMEDIO DE COSTO DE LOS VEHICULOS ----------------");
        System.out.println(garage.calcularPromedioCostoVehiculos());
    }
}