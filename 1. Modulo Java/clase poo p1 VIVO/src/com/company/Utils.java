package com.company;

public class Utils {
    public static void output(int mc){
        switch (mc){
            case -1 :
                System.out.println("Bajo peso");
                break;
            case 0:
                System.out.println("Peso saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
            default:
                System.out.println("Invalid output");
                break;
        }
    }
}
