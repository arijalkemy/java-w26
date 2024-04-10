

public class MaxMinTemperaturas {
    public static void main(String[] args){
        
        String ciudades[] = {"Londres","Madrid","Nueva York","Buenos Aires","Asunción","São Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int temperaturas[][] = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        if (ciudades.length > 0 && ciudades.length == temperaturas.length){
            
            int temperaturaMinima = temperaturas[0][0];
            int indiceMinima = 0;
            int temperaturaMaxima = temperaturas[0][1];
            int indiceMaxima = 0;

            for (int i = 1; i < ciudades.length; i++) {
                if (temperaturas[i][0] < temperaturaMinima) {
                    temperaturaMinima = temperaturas[i][0];
                    indiceMinima = i;
                } 
                if (temperaturas[i][1] > temperaturaMaxima) {
                    temperaturaMaxima = temperaturas[i][1];
                    indiceMaxima = i;
                }
            }
            System.out.println("La menor temperatura se registro en " + ciudades[indiceMinima] + " y fue de " + temperaturaMinima + "°C.");
            System.out.println("La mayor temperatura se registro en " + ciudades[indiceMaxima] + " y fue de " + temperaturaMaxima + "°C.");
        } else {
            System.out.println("Faltan datos sobre ciudades y temperaturas.");
        }
    }
}