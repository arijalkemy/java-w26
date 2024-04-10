import java.util.Arrays;

public class Vivo {

    public static void main(String[] args) {
        arrays();
    }

    public static void arrays() {
        int[] numbersArray = new int[6];
        Arrays.stream(numbersArray)
              .forEach(System.out::println);
    }
}
