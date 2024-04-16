import java.util.TreeMap;

public class testr {

    private static final TreeMap<Integer, String> ROMAN_NUMERALS = new TreeMap<>();

    static {
        ROMAN_NUMERALS.put(1000, "M");
        ROMAN_NUMERALS.put(900, "CM");
        ROMAN_NUMERALS.put(500, "D");
        ROMAN_NUMERALS.put(400, "CD");
        ROMAN_NUMERALS.put(100, "C");
        ROMAN_NUMERALS.put(90, "XC");
        ROMAN_NUMERALS.put(50, "L");
        ROMAN_NUMERALS.put(40, "XL");
        ROMAN_NUMERALS.put(10, "X");
        ROMAN_NUMERALS.put(9, "IX");
        ROMAN_NUMERALS.put(5, "V");
        ROMAN_NUMERALS.put(4, "IV");
        ROMAN_NUMERALS.put(1, "I");
    }

    public static String intToRoman(int number) {
        int floorKey = ROMAN_NUMERALS.floorKey(number);
        if (number == floorKey) {
            return ROMAN_NUMERALS.get(number);
        }
        return ROMAN_NUMERALS.get(floorKey) + intToRoman(number - floorKey);
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        int number = 561;
        String romanNumber = intToRoman(number);
        System.out.println(number + " en números romanos es: " + romanNumber);
    }
}
