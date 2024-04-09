public class main {
    public static void main(String[] args){

        String ciudades[] = {"Londres","Madrid","Nueva York","Buenos Aires","Asunción","São Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int temperaturas[][] = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};
        int temperaturaMaxima = Integer.MIN_VALUE;
        int temperaturaMinima = Integer.MAX_VALUE;
        int indiceTemperaturaMaxima = 0;
        int indiceTemperaturaMinima = 0;

        for (int i = 0; i < ciudades.length; i++) {

            int temperaturaActualMax = temperaturas[i][1];
            int temperaturaActualMin = temperaturas[i][0];

            if (temperaturaActualMax > temperaturaMaxima) {
                temperaturaMaxima = temperaturaActualMax;
                indiceTemperaturaMaxima = i;
            }
            if (temperaturaActualMin < temperaturaMinima) {
                temperaturaMinima = temperaturaActualMin;
                indiceTemperaturaMinima = i;
            }
        }

        System.out.println("Ciudad con temperatura mínima: " + ciudades[indiceTemperaturaMinima] + " " + temperaturaMinima + "\n"+ "Indice temperatura máxima: " + ciudades[indiceTemperaturaMaxima] + " " + temperaturaMaxima);
    }
}
