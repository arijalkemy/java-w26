package org.ejercicio.numerosromanos.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

@Service
public class RomanoImpl implements  IRomano{
    private Map<Integer, String> mapRomano;

    public RomanoImpl() {
        mapRomano = new TreeMap<>(Collections.reverseOrder());
        mapRomano.put(1, "I");
        mapRomano.put(4, "IV");
        mapRomano.put(5, "V");
        mapRomano.put(9, "IX");
        mapRomano.put(10, "X");
        mapRomano.put(40, "XL");
        mapRomano.put(50, "L");
        mapRomano.put(90, "XC");
        mapRomano.put(100, "C");
        mapRomano.put(400, "CD");
        mapRomano.put(500, "D");
        mapRomano.put(900, "CM");
        mapRomano.put(1000, "M");
    }

    public String getRomano(int num) {
        String cadena="";
        if(num==0){
            return "0";
        }
        while(num>0){
            for(Map.Entry<Integer, String> mapa: mapRomano.entrySet()) {
                if(num>=mapa.getKey()) {
                    num-=mapa.getKey();
                    cadena+=mapa.getValue();
                    break;
                }
            }
        }
        return cadena;
    }
}
