package bootcamp.bendezujonathan.romanNumbers.services.implementation;

import java.util.TreeMap;

import org.springframework.stereotype.Service;

import bootcamp.bendezujonathan.romanNumbers.services.interfaces.IConvertionService;

@Service
public class ConvertionService implements IConvertionService {

    private static final TreeMap<Integer, String> romanNumbers = new TreeMap<>();
    static {
        romanNumbers.put(1, "I");
        romanNumbers.put(4, "IV");
        romanNumbers.put(5, "V");
        romanNumbers.put(9, "IX");
        romanNumbers.put(10, "X");
        romanNumbers.put(40, "XL");
        romanNumbers.put(50, "L");
        romanNumbers.put(90, "XC");
        romanNumbers.put(100, "C");
        romanNumbers.put(400, "CD");
        romanNumbers.put(500, "D");
        romanNumbers.put(900, "CM");
        romanNumbers.put(1000, "M");
    }

    @Override
    public String toRoman(Integer anArabicNumber) {
        int largestNumber = romanNumbers.floorKey(anArabicNumber);
        String largestRepresentation = romanNumbers.get(largestNumber);
        return (largestNumber == anArabicNumber) ? largestRepresentation
                : largestRepresentation + this.toRoman(anArabicNumber - largestNumber);
    }

}
