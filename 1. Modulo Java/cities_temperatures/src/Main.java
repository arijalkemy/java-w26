//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] cities = {"Londres", "Madrid", "NuevaYork",
                "Buenos Aires", "Asunción", "Sao Paulo", "Lima",
                "Santiago de Chile", "Lisboa", "Tokyo"};
        int[][] temperatures = {{-2, 33}, {-3, 32}, {-8, 27},
                {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26},
                {-1, 31}, {-10, 35}};

        int min = (int) Double.POSITIVE_INFINITY;
        int max = (int) Double.NEGATIVE_INFINITY;
        int maxTempId = 0;
        int minTempId = 0;
        for(int i = 0; i < cities.length; i++) {
            if (temperatures[i][0] < min) {
                min = temperatures[i][0];
                minTempId = i;
            };
            if (temperatures[i][1] > max) {
                max = temperatures[i][1];
                maxTempId = i;
            };
        }

        System.out.println("Max temperature was "+cities[maxTempId]+" with "+max+"ºC");
        System.out.println("Min temperature was "+cities[minTempId]+" with "+min+"ºC");
    }
}