public class Main {
    public static void main(String[] args) {

        String cities[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int temperatures[][] = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
        int maxTemperature = Integer.MIN_VALUE;
        int minTemperature = Integer.MAX_VALUE;
        int maxTemperatureIndex = 0;
        int minTemperatureIndex = 0;

        for (int i = 0; i < cities.length; i++) {

            int maxActualTemp = temperatures[i][1];
            int minActualTemp = temperatures[i][0];

            if (maxActualTemp > maxTemperature) {
                maxTemperature = maxActualTemp;
                maxTemperatureIndex = i;
            }
            if (minActualTemp < minTemperature) {
                minTemperature = minActualTemp;
                minTemperatureIndex = i;
            }
        }

        System.out.printf("La temperature mínima la tiene %s, con %s°C \n",cities[minTemperatureIndex], minTemperature);
        System.out.printf("La temperature máxima la tiene %s, con %s°C",cities[maxTemperatureIndex], maxTemperature);

    }
}