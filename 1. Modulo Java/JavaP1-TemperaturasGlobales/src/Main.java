public class Main {
    public static void main(String[] args) {
        String[] ciudades = {"Lonpdres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperaturas = {{-2, 33},{-3, 32},{-8, 27},{4, 37},{6, 42},{5, 43},{0, 39},{-7, 26},{-1, 31},{-10, 35}};

        int max = 0;
        int min = 100;
        String minCiudad = "";
        String maxCiudad = "";


        for (int i = 0; i < 10; i++) {
            if (max < temperaturas[i][1]){
                max = temperaturas[i][1];
                maxCiudad = ciudades[i];
            }
            if (min > temperaturas[i][0]) {
                min = temperaturas[i][0];
                minCiudad = ciudades[i];
            }
        }

        System.out.println("La menor temperatura es : " + min + " en " + minCiudad);
        System.out.println("La mayor temperatura es : " + max + " en " + maxCiudad);
    }
}