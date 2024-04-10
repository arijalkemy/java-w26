package org.example;

public class Main {
    public static void main(String[] args) {
        int a = 0, b = 10;
        try{
            int res = division(a, b);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println("Se ha producido un error");
        }
        finally {
            System.out.println("Programa finalizado");
        }
    }

    public static int division(int a, int b) {
        if (a == 0) throw new IllegalArgumentException("No se puede divir entre cero");
        return b/a;
    }
}