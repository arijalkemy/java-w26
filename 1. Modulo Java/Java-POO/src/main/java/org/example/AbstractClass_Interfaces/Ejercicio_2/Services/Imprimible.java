package org.example.AbstractClass_Interfaces.Ejercicio_2.Services;

public interface Imprimible {

    static void viewData(Imprimible document){
         System.out.println("---------------------------");
         document.imprimir();
         System.out.println("---------------------------");
    }

    void imprimir();

}
