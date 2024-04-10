package org.example.Temperaturas;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Temperaturas {

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();

        Map<String,int[]> citiesTemps = new HashMap<>();

        citiesTemps.put("Londres", new int[]{-2,33});
        citiesTemps.put("Madrid", new int[]{-3,32});
        citiesTemps.put("Nueva York", new int[]{-8,27});
        citiesTemps.put("Buenos Airesa", new int[]{4,37});
        citiesTemps.put("Asuncion", new int[]{6,42});
        citiesTemps.put("Sao Paulo", new int[]{5,43});
        citiesTemps.put("Lima", new int[]{0,39});
        citiesTemps.put("Chile", new int[]{-7,26});
        citiesTemps.put("Lisboa", new int[]{-1,31});
        citiesTemps.put("Tokio", new int[]{-10,35});

        int minusTemp = 0;
        int maxTemp = 0;
        String cityMinTemp = "";
        String cityMaxTemp = "";

        Iterator<Map.Entry<String, int[]>> iterator = citiesTemps.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, int[]> entry = iterator.next();
            String key = entry.getKey();
            int[] value = entry.getValue();
            int min = value[0];
            int max = value[1];
            if (min < minusTemp) {
                minusTemp = min;
                cityMinTemp = key;
            }
            if (max > maxTemp){
                maxTemp = max;
                cityMaxTemp = key;
            }

            // System.out.println("Clave: " + key + ", Valor: " + Arrays.toString(value));
        }

        System.out.println("minus temp: " + minusTemp);
        System.out.println("max temp: " + maxTemp);

        System.out.println("cityMaxTemp: " + cityMaxTemp);
        System.out.println("cityMinTemp: " + cityMinTemp);


        long fin = System.currentTimeMillis();
        long tiempoTranscurrido = fin - inicio;

        // Imprimir el tiempo transcurrido
        System.out.println("La función tardó " + tiempoTranscurrido + " milisegundos en ejecutarse.");

    }
}
