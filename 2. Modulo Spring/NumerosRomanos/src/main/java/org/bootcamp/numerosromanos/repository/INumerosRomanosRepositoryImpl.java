package org.bootcamp.numerosromanos.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
@Repository
public class INumerosRomanosRepositoryImpl implements INumerosRomanosRepository {

    private static final HashMap<Integer, Character> numerosDecimalesARomanos= new HashMap<>();
    private static final HashMap<Character, Integer> numerosRomanosADecimal= new HashMap<>();
    static {
        numerosRomanosADecimal.put('I', 1);
        numerosRomanosADecimal.put('V', 5);
        numerosRomanosADecimal.put('X', 10);
        numerosRomanosADecimal.put('L', 50);
        numerosRomanosADecimal.put('C', 100);
        numerosRomanosADecimal.put('D', 500);
        numerosRomanosADecimal.put('M', 1000);

        numerosDecimalesARomanos.put(1, 'I');
        numerosDecimalesARomanos.put(5, 'V');
        numerosDecimalesARomanos.put(10, 'X');
        numerosDecimalesARomanos.put(50, 'L');
        numerosDecimalesARomanos.put(100, 'C');
        numerosDecimalesARomanos.put(500, 'D');
        numerosDecimalesARomanos.put(1000, 'M');
    }

    public String convertirNroDecimalARomano(Integer numeroDecimal) {
        String nroRomano="";
        List<Integer> numeros= numerosDecimalesARomanos.keySet().stream().sorted().toList();
        do{
            for (int i = 0; i < numeros.size(); i++) {
                for (int j = i+1; j < numeros.size(); j++) {
                    int numero1=numeros.get(i);
                    int numero2=numeros.get(j);
                    if((numeroDecimal>= numeros.get(i) && numeroDecimal<numeros.get(j)) &&
                            numeroDecimal<numeros.get(j)-numeros.get(i)) {
                        nroRomano+=numerosDecimalesARomanos.get(numero1);
                        numeroDecimal=numeroDecimal-numero1;
                    }else if(numeroDecimal==numeros.get(j)-numeros.get(i)){
                        nroRomano+=numerosDecimalesARomanos.get(numero1);
                        nroRomano+=numerosDecimalesARomanos.get(numero2);
                        numeroDecimal=numeroDecimal-numero2-numero1;
                    }
                    break;
                }

            }
        }while(numeroDecimal>0);

        return nroRomano;
    }
    public Integer convertirNroRomanoADecimal(String numeroRomano) {
        Integer nroDecimal=0;
        char[] nroRomanosList=numeroRomano.toCharArray();
        for (int i = 0; i < nroRomanosList.length; i++) {
            int indice = i;
            nroDecimal += numerosRomanosADecimal.entrySet().stream().
                    filter(entry -> entry.getKey().equals(nroRomanosList[indice])).mapToInt(Map.Entry::getValue).sum();
        }
        return nroDecimal;
    }

}*/import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class INumerosRomanosRepositoryImpl implements INumerosRomanosRepository {

    private static final Map<Character, Integer> numerosRomanosADecimal = new HashMap<>();
    private static final Map<Integer, String> numerosDecimalesARomanos = new HashMap<>();

    static {
        numerosRomanosADecimal.put('I', 1);
        numerosRomanosADecimal.put('V', 5);
        numerosRomanosADecimal.put('X', 10);
        numerosRomanosADecimal.put('L', 50);
        numerosRomanosADecimal.put('C', 100);
        numerosRomanosADecimal.put('D', 500);
        numerosRomanosADecimal.put('M', 1000);

        for (Map.Entry<Character, Integer> entry : numerosRomanosADecimal.entrySet()) {
            numerosDecimalesARomanos.put(entry.getValue(), String.valueOf(entry.getKey()));
        }
    }

    public String convertirNroDecimalARomano(Integer numeroDecimal) {
        StringBuilder nroRomano = new StringBuilder();
        for (int decimal : numerosDecimalesARomanos.keySet()) {
            while (numeroDecimal >= decimal) {
                nroRomano.append(numerosDecimalesARomanos.get(decimal));
                numeroDecimal -= decimal;
            }
        }
        return nroRomano.toString();
    }

    public Integer convertirNroRomanoADecimal(String numeroRomano) {
        int nroDecimal = 0;
        int prevValor = 0;

        for (int i = numeroRomano.length() - 1; i >= 0; i--) {
            int valor = numerosRomanosADecimal.get(numeroRomano.charAt(i));
            if (valor < prevValor) {
                nroDecimal -= valor;
            } else {
                nroDecimal += valor;
            }
            prevValor = valor;
        }

        return nroDecimal;
    }
}

