import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Arrays;

public class Loader {

    public static String[] cities;
    public static int[][] temp;

    private static final String CITY_MESSAGE = "%d) %s  Min: %d°C Max: %d°C";
    private static final String DELIMITER = ",";

    public static void load() {
        Scanner scan = new Scanner(System.in);
        System.out.println(">> Welcome! How are you going to load the data? \n1) Manual \n2) Default");
        int opt = Integer.parseInt(scan.nextLine());
        if (opt == 1)
            manualLoad(scan);
        else {
            if (opt != 2) System.out.println(">> Wrong option!! Using default");
            defaultLoad();
        }
        scan.close();
        printResult();
    }

    private static void manualLoad(Scanner scan) {
        System.out.println(">> How many cities are you going to load?");
        int numberOfCities = Integer.parseInt(scan.nextLine());
        cities = new String[numberOfCities];
        temp = new int[numberOfCities][2];
        System.out.println(">> Load the data of the cities using ',' as delimiter, one city per line.\neg: name,min,max ");
        for (int i = 0; i < numberOfCities; i++) {
            String cityData = scan.nextLine();
            String[] cityDataDecomposed = cityData.split(DELIMITER);
            cities[i] = capitalize(cityDataDecomposed[0]);
            temp[i][0] = Integer.parseInt(cityDataDecomposed[1].trim());
            temp[i][1] = Integer.parseInt(cityDataDecomposed[2].trim());
        }
    }

    private static String capitalize(String city) {
        return Arrays.stream(city.split("\\s+"))
                    .map(word ->  (word.length() < 3) ? word : word.substring(0, 1).toUpperCase() + word.substring(1))
                    .collect(Collectors.joining(" "));
    }
    
    private static void defaultLoad() {
        cities = new String[] {
                "Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción",
                "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"
        };

        temp = new int[][] {
                { -2, 3 }, { -3, 32 }, { -8, 27 }, { 4, 37 }, { 6, 42 },
                { 5, 43 }, { 0, 39 }, { -7, 26 }, { -1, 31 }, { -10, 35 }
        };
    }

    private static void printResult() {
        System.out.println("Load complete");
        for (int i = 0; i < cities.length; i++) {
            System.out.println(String.format(CITY_MESSAGE, i + 1, cities[i], temp[i][0], temp[i][1]));
        }
    }

}
