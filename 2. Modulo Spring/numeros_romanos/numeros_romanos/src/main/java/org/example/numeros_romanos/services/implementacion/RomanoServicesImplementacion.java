package org.example.numeros_romanos.services.implementacion;

import org.example.numeros_romanos.services.IRomanoServices;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.*;
import java.util.stream.Stream;

@Service
public class RomanoServicesImplementacion implements IRomanoServices {

    Map<Integer, String> numeroRomano;

    public RomanoServicesImplementacion() {
        numeroRomano = new TreeMap<Integer,String>(Comparator.reverseOrder());
        this.numeroRomano.put(1000,"M");
        this.numeroRomano.put(900,"CM");
        this.numeroRomano.put(500,"D");
        this.numeroRomano.put(400,"CD");
        this.numeroRomano.put(100,"C");
        this.numeroRomano.put(90,"XC");
        this.numeroRomano.put(50,"L");
        this.numeroRomano.put(40,"XL");
        this.numeroRomano.put(10,"X");
        this.numeroRomano.put(9,"IX");
        this.numeroRomano.put(5,"V");
        this.numeroRomano.put(4,"IV");
        this.numeroRomano.put(1,"I");
    }

    @Override
    public String convertirARomano(int numero) {


        if(numero >3999) throw new IllegalArgumentException("No es posible convertir un número mayor que 3999");
        if(numero <= 0) throw new IllegalArgumentException("No es posible convertir un número menor que 1");

        String resultado = "";
            int cociente=0;
            for (Map.Entry<Integer,String> entry : this.numeroRomano.entrySet()){
                cociente = numero / entry.getKey();
                resultado = resultado + entry.getValue().repeat(cociente);
                numero -= cociente * entry.getKey();
            }
            return resultado;
    }

    @Override
    public int convertirAEntero(String numeroRomano) {
        int resultado = 0;
        String [] letras = numeroRomano.split("");


        for (int i = 0; i < letras.length; i++) {
            if(!this.numeroRomano.containsValue(letras[i])){
                throw new IllegalArgumentException("Número romano no valido");
            }
            for (Map.Entry<Integer,String> entry : this.numeroRomano.entrySet()){
                if(i+1<letras.length && letras[i].concat(letras[i+1]).equals(entry.getValue())){
                    resultado = resultado + entry.getKey();
                    i++;
                } else if (letras[i].equals(entry.getValue())) {
                        resultado = resultado + entry.getKey();
                    }
                }
        }
        return resultado;
    }

}
