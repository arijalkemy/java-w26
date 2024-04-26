package org.example.numerosromanos.interfaces.implement;

import org.example.numerosromanos.interfaces.IConvert;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ConvertRomanImpl implements IConvert {

    final static Map<Integer, String> map = getSymbolMap();

    @Override
    public String convert(Integer num) {
        String symbolNumber = "";
        while (num > 0) {
            symbolNumber += map.get(getFactor(num));
            num-=getFactor(num) ;
        }
        symbolNumber = symbolNumber.replace("VIIII","IX");
        symbolNumber = symbolNumber.replace("DCCCC","CM");
        symbolNumber = symbolNumber.replace("LXXXX","XC");
        symbolNumber = symbolNumber.replace("XXXX","XL");
        symbolNumber = symbolNumber.replace("CCCC","CD");
        symbolNumber = symbolNumber.replace("IIII","IV");
        return symbolNumber;
    }

    private int getFactor(Integer num){
            if(num / 1000000 >= 1) return 1000000;
            if(num / 500000 >= 1) return 500000;
            if(num / 100000 >= 1) return 100000;
            if(num / 50000 >= 1) return 50000;
            if(num / 10000 >= 1) return 10000;
            if(num / 5000 >= 1) return 5000;
            if(num / 1000 >= 1) return 1000;
            if(num / 500 >= 1) return 500;
            if(num / 100 >= 1) return 100;
            if(num / 50 >= 1) return 50;
            if(num / 10 >= 1) return 10;
            if(num / 5 >= 1) return 5;
        return 1;
    }

    private static Map<Integer, String> getSymbolMap(){
        return Stream.of(
                new AbstractMap.SimpleEntry<Integer, String>(1000000, "M̅"),
                new AbstractMap.SimpleEntry<Integer, String>(500000, "D̅"),
                new AbstractMap.SimpleEntry<Integer, String>(100000, "C̅"),
                new AbstractMap.SimpleEntry<Integer, String>(50000, "L̅"),
                new AbstractMap.SimpleEntry<Integer, String>(10000, "X̅"),
                new AbstractMap.SimpleEntry<Integer, String>(5000, "V̅"),
                new AbstractMap.SimpleEntry<Integer, String>(1000, "M"),
                new AbstractMap.SimpleEntry<Integer, String>(500, "D"),
                new AbstractMap.SimpleEntry<Integer, String>(100, "C"),
                new AbstractMap.SimpleEntry<Integer, String>(50, "L"),
                new AbstractMap.SimpleEntry<Integer, String>(10, "X"),
                new AbstractMap.SimpleEntry<Integer, String>(5, "V"),
                new AbstractMap.SimpleEntry<Integer, String>(1, "I")
        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
