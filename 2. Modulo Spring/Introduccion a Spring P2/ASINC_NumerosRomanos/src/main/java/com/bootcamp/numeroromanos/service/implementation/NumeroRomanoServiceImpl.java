package com.bootcamp.numeroromanos.service.implementation;

import com.bootcamp.numeroromanos.service.INumeroRomanoService;
import org.springframework.stereotype.Service;

import java.util.TreeMap;

@Service
public class NumeroRomanoServiceImpl implements INumeroRomanoService {

    private TreeMap<Integer, String> map;

    public NumeroRomanoServiceImpl () {
        map = new TreeMap<Integer, String>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }
    @Override
    public String convertirARomano(int numero) {
        int l =  map.floorKey(numero);
        if ( numero == l ) {
            return map.get(numero);
        }
        return map.get(l) + convertirARomano(numero-l);
    }
}
