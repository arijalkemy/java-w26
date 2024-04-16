package com.bootcamp.numerosromanos.service.implementation;

import com.bootcamp.numerosromanos.service.INumeroRomanoService;
import org.springframework.stereotype.Service;

import java.util.TreeMap;

@Service
public class NumeroRomanoService implements INumeroRomanoService {
    private TreeMap<Integer, String> map;

    public NumeroRomanoService () {
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
    public String convertirARomano(int nro) {
        int l =  map.floorKey(nro);
        if ( nro == l ) {
            return map.get(nro);
        }
        return map.get(l) + convertirARomano(nro-l);
    }



}
