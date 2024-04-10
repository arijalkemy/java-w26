public class main {

    public static void main(String[] args) {
        String[] ciudades = {"Londres","Madrid", "Nueva York","Buenos Aires",
                             "Asunción","São Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};

        int[][] temperaturas = {{-2,-33},{-3,32},{-8,27},{4,37},{6,42},
                                {5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int highestTemp = Integer.MIN_VALUE; // Inicializar con un valor muy bajo
        int lowestTemp = Integer.MAX_VALUE;   // Inicializar con un valor muy alto
        int highestTempIndex = -1;
        int lowestTempIndex = -1;
        
        for (int index = 0; index < ciudades.length; index++){
            if (temperaturas[index][0] < lowestTemp){
                lowestTemp = temperaturas[index][0];
                lowestTempIndex = index;
            } 

            if (temperaturas[index][1] > highestTemp){
                highestTemp = temperaturas[index][1];
                highestTempIndex = index;
            }

        }
        
        // Verificamos si se encontró al menos una ciudad
        if (lowestTempIndex != -1 && highestTempIndex != -1) {
            System.out.println("Min Temp: " + temperaturas[lowestTempIndex][0] + " - Ciudad: " + ciudades[lowestTempIndex]); 
            System.out.println("Max Temp: " + temperaturas[highestTempIndex][1] + " - Ciudad: " + ciudades[highestTempIndex]); 
        } else {
            System.out.println("No se encontraron datos de temperatura.");
        }
    }
}
