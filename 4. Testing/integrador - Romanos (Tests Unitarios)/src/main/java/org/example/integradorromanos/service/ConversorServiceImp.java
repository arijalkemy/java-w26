package org.example.integradorromanos.service;


import org.springframework.stereotype.Service;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ConversorServiceImp implements IConversorService{

    private final Map<Integer, String> conversionReference = new LinkedHashMap<>(){{
        put(1000, "D");
        put(900, "CM");
        put(500, "D");
        put(400, "CD");
        put(100, "C");
        put(90, "XC");
        put(50, "L");
        put(40, "XL");
        put(10, "X");
        put(9, "IX");
        put(5, "V");
        put(4, "IV");
        put(1, "I");
    }};

    public int returnValueForModulo(int number){
        double powValue = String.valueOf(number).length() - 1;
        double result = Math.pow(10, powValue);

        return Double.valueOf(result).intValue();
    }

    public String convertToRoman(int decimal){

        String resultSTR = "";
        int moduloValue = 0;

        int modulo = 0;
        int result = decimal;

        for (Map.Entry<Integer, String> entry: conversionReference.entrySet()){
            int checker = entry.getKey();
            String str = entry.getValue();

            moduloValue = returnValueForModulo(result);
            modulo = result%moduloValue;

            while (result >= checker) {
                resultSTR = resultSTR + str;

                result -= checker;
            }
        }

        return resultSTR;
    }
}
