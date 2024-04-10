public class App {
    public static void main(String[] args) throws Exception {
        String ciudades[] = new String[] {"Londres","Madrid","Nueva York","Buenos Aires","Asunción","Sao Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int temperaturas[][] = new int[][] { {-2,33}, {-3,32},{-8,27}, {4,37},{6,42}, {5,43},{0,39}, {-7,26},{-1,31}, {-10,35} };

        //Primer indice la temperatura, segundo indice de la ciudad
        int max_temp[] = new int[] {0,0};
        int min_temp[] = new int[] {100,0};

        for(int i=0;i<ciudades.length;i++){
           
            //Fijarse si hay nueva temp min
            if( temperaturas[i][0] < min_temp[0]){
                min_temp[0] = temperaturas[i][0];
                min_temp[1] = i;
            }
            //Fijarse si hay nueva temp max
            if( temperaturas[i][1] > max_temp[0]){
                max_temp[0] = temperaturas[i][1];
                max_temp[1] = i;
            }
        }
        System.out.println("Resultados:");
        System.out.println("Temperatura mínima de " + min_temp[0] + " en la ciudad: " + ciudades[min_temp[1]]);
        System.out.println("Temperatura máxima de " + max_temp[0] + " en la ciudad: " + ciudades[max_temp[1]]);
    }
}
