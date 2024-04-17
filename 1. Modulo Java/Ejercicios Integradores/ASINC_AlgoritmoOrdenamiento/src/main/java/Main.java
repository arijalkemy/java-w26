import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    /*Se plantea crear una clase con un método static llamado burbuja, que recibe un arreglo de enteros
    primitivos int[] y devuelve el arreglo, ordenado de forma ascendente.

    Pistas:
    - Recordar que en Java cada línea de código tiene una forma particular de cerrarse.
    - Recordar que Java es un lenguaje FUERTEMENTE TIPADO, por lo que el correcto tipo de dato es muy importante
    en la declaración de cada variable.*/

    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};
        burbuja(array);
        imprimirArreglo(array);

        System.out.println("\n\nOtra solución propuesta:");
        ordenarConStrem(array);
    }

    public static int[] burbuja(int[] array) {
        int n = array.length;
        boolean intercambio;

        for (int paso = 0; paso < n - 1; paso++) {
            intercambio = false;
            for (int i = 0; i < n - paso - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    intercambio = true;
                }
            }
            if (!intercambio) {
                break;
            }
        }

        return array;
    }

    public static void imprimirArreglo(int[] array) {
        for (int elemento : array) {
            System.out.print(elemento + " ");
        }
    }

    public static void ordenarConStrem(int[] lista){
        //Creo una coleccion
        List<Integer> listaNumeros = new ArrayList<>();

        //Convierto el array en una coleccion para trabajar con stream
        for (int i= 0; i < lista.length; i++) {
            listaNumeros.add(lista[i]);
        }

        //Ordeno los numeros de la coleccion y los voy agregando a una nueva lista previamente creada
        List<Integer> listaNumerosOrdenados = new ArrayList<>();
        listaNumeros.stream().sorted().forEach(x -> listaNumerosOrdenados.add(x));

        //Paso los elementos de la coleccion a un array previamente creado ya que así lo requeria el enunciado
        Integer[] arrayOrdenado = listaNumerosOrdenados.toArray(new Integer[0]);
        for (int elemento : arrayOrdenado) {
            System.out.print(elemento + " ");
        }
    };
}

