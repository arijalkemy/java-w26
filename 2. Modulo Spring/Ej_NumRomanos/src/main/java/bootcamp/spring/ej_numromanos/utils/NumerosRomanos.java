package bootcamp.spring.ej_numromanos.utils;

public class NumerosRomanos {

    public static String convertirDecimalARomano(Integer number){
        int[] valores = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] simbolos = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder resultado = new StringBuilder();
        int indice = 0;
        while (number > 0) {
            if (number - valores[indice] >= 0) {
                resultado.append(simbolos[indice]);
                number -= valores[indice];
            } else {
                indice++;
            }
        }
        return resultado.toString();

    }
}
