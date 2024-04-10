package org.example;

public class PracticaExcepciones {
    public static double Division(int a, int b){
        try{
            if(b ==0){
                throw new IllegalArgumentException("No se puede dividir por 0");
            }
            return a/b;
        }catch(Exception e){
            throw new Error(e);
        }
    }
}
