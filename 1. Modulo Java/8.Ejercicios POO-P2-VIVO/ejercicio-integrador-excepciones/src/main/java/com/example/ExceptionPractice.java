package com.example;
public class ExceptionPractice {

    private static int a = 0;
    private static int b = 300;

    public static void evaluateExpression(){
        try {
            System.out.println("Resultado división: " + ExceptionPractice.b/ExceptionPractice.a);
        } catch (Exception e) {
            System.out.println("Se ha producido un error en operación: " + e.getMessage());
            e.printStackTrace();
        } finally{
            System.out.println("Programa finalizado.");
        }
    }

    public static void manageExpression(){
        try {
            System.out.println("Resultado división: " + ExceptionPractice.b/ExceptionPractice.a);
        } catch (Exception e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }


    



}
