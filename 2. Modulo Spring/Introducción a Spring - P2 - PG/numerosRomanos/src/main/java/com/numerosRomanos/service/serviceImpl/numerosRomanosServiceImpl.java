package com.numerosRomanos.service.serviceImpl;

import com.numerosRomanos.service.numerosRomanosService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class numerosRomanosServiceImpl implements numerosRomanosService {


    private static LinkedHashMap<String,Integer> numerosRomanos= new LinkedHashMap<>() {{
        put("M", 1000);
        put("D", 500);
        put("C", 100);
        put("L", 50);
        put("X", 10);
        put("V", 5);
        put("I", 1);
    }};

    @Override
    public String decimalRomano(Integer numero){
        String numeroRomano="";

        if ((numero<3999) && (numero>0) ){
            String claveAnterior="";
            String claveAnteriorx2="";
            for (String clave:numerosRomanos.keySet()) {
                System.out.println(numerosRomanos.get(clave));
                System.out.println(numero/numerosRomanos.get(clave));
                for (int i=0;i<((numero/numerosRomanos.get(clave)));i++){
                    if (numero/numerosRomanos.get(clave)==4){
                        if(claveAnteriorx2!=""){
                            numeroRomano+=claveAnteriorx2;
                        }
                        numeroRomano+=clave+claveAnterior;
                        break;
                    }
                    else if(numero%numerosRomanos.get(clave)==4){
                        if(claveAnterior!=""){
                            claveAnteriorx2=claveAnterior;
                        }
                        claveAnterior=clave;
                        numero=numero%numerosRomanos.get(clave);
                        break;
                    }

                    else {
                        numeroRomano += clave;
                    }
                }
                if (claveAnterior==""){
                    numero=numero%numerosRomanos.get(clave);
                }

                claveAnterior=clave;
            }
            return numeroRomano;
        }
        else{
            return "No es posible convertir " + numero.toString() + " al sistema romano.";
        }

    }

    @Override
    public String romanoDecimal(String numero) {
        return null;
    }
}
