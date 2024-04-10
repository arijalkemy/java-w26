public class Main {
    
    private static final String MAX_MESSAGE = ">> The highest temperature was %d°C in %s ";
    private static final String MIN_MESSAGE = ">> The lowest temperature was %d°C in %s";

    public static void main(String[] args) {
        Loader.load();
        showMaxMinTemps(Loader.cities, Loader.temp);
    }


    public static void showMaxMinTemps(String[] cities, int[][] temp ) {
        int minIndex = 0;
        int maxIndex = 0;
        int min = temp[0][0];
        int max = temp[0][1];
        for (int i = 0; i < cities.length; i++) {
            int minCuidad = temp[i][0];
            int maxCuidad = temp[i][1];
            if (minCuidad < min) {
                minIndex = i;
                min = minCuidad;
            }
            if (maxCuidad > max) {
                maxIndex = i;
                max = maxCuidad;
            }
        }
        System.out.println();
        System.out.println(String.format(MAX_MESSAGE, max, cities[maxIndex]));
        System.out.println(String.format(MIN_MESSAGE, min, cities[minIndex]));
    }
}
