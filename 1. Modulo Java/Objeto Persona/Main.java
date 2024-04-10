import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Edwin", 22, "1004302506");
        Person p2 = new Person("Camila", 22, "1004302506", 156D, 0D);

        int imc = p1.calcularIMC();
        Map<Integer, String> diccionario = new HashMap<>();
        diccionario.put(1, "Peso Saludable");
        diccionario.put(-1, "Bajo Peso");
        diccionario.put(0, "Sobrepeso");
        System.out.println(diccionario.get(imc));
        System.out.println(p2);
    }
}