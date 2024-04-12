package org.example;

public class Main {
    public static void main(String[] args) {

        Prototipo<Integer> serie = new SerieInteger();

        Integer valorInicial = 1;
        serie.setValorInicial(valorInicial);
        System.out.println("Valor incial " + valorInicial);
        for (int i = 1; i < 5; i++) {
            System.out.println(i + ": " + serie.siguiente());
        }

        serie.reiniciar();
        System.out.println("Reinicio a " + valorInicial);
        for (int i = 1; i < 5; i++) {
            System.out.println(i + ": " + serie.siguiente());
        }

    }
}

