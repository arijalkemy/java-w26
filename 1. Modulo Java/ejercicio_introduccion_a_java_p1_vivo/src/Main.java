public class Main {
    public static void main(String[] args) {
        String ciudades[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunsión", "San Pablo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int temperaturas[][] = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
        int indiceMenorTemp = 0;
        int indiceMayorTemp = 0;

        for (int i = 0; i < ciudades.length; i++) {
            if(temperaturas[i][0] < temperaturas[indiceMenorTemp][0]) {
                indiceMenorTemp = i;
            }
            if(temperaturas[i][1] > temperaturas[indiceMayorTemp][1]) {
                indiceMayorTemp = i;
            }
        }

        System.out.println("La menor temperatura la tuvo " + ciudades[indiceMenorTemp] + ", con " + temperaturas[indiceMenorTemp][0] + " °C.");
        System.out.println("La mayor temperatura la tuvo " + ciudades[indiceMayorTemp] + ", con " + temperaturas[indiceMayorTemp][1] + " °C.");

    }
}