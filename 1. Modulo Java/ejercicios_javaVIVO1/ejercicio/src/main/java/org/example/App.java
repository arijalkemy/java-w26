package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*
        * Se declaran los vectores de ciudades y la matriz con temperaturas
        * */
        String vectorCiudades[] = { "Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima",
                "Santiago de Chile", "Lisboa", "Tokio" };
        int[][] matrizTemperaturas = { { -2, 33 }, { -3, 32 }, { -8, 27 }, { 4, 37 }, { 6, 42 }, { 5, 43 }, { 0, 39 },
                { -7, 26 }, { -1, 31 }, { -10, 35 } };
        /*
        * Se asigna como ciudad con menor y mayor temperatura la primera ciudad, así como las mayores y menores temperaturas
        * */
        String ciudadMenorTemperatura = vectorCiudades[0];
        String ciudadMayorTemperatura = vectorCiudades[0];
        int menorTemperatura = matrizTemperaturas[0][0];
        int mayorTemperatura = matrizTemperaturas[0][1];
        /*
        * Se itera en la matriz y comparamos si la temperatura actual es mayor que la mayor temperatura que tenemos
        * registrada, lo mismo con la menor temperatura y así también asignamos las ciudades que corresponden
        * */
        for (int i = 1; i < vectorCiudades.length; i++) {
            if (matrizTemperaturas[i][0] < menorTemperatura) {
                menorTemperatura = matrizTemperaturas[i][0];
                ciudadMenorTemperatura = vectorCiudades[i];
            }
            if (matrizTemperaturas[i][1] > mayorTemperatura) {
                mayorTemperatura = matrizTemperaturas[i][1];
                ciudadMayorTemperatura = vectorCiudades[i];
            }
        }
        /*
        * Finalmente imprimimos por consola los valores obtenidos
        * */
        System.out.println("Ciudad con menor temperatura: " + ciudadMenorTemperatura + ", con una temperatura de :"
                + menorTemperatura);
        System.out.println("Ciudad con mayor temperatura: " + ciudadMayorTemperatura + ", con una temperatura de :"
                + mayorTemperatura);
    }
}
