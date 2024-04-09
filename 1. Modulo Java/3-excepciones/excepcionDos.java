public class excepcionDos {
    public static void main(String[] args) {

    //Mensaje final
    String mensajeFinal = "Este es el ultimo mensaje";

    //Código que arroja excepción
    try{
        int[] numeros = new int[5];
        numeros[5]=10;}
    catch (ArrayIndexOutOfBoundsException exception){
        System.out.println("Excediste el rango del array.");
        }
    finally{
        System.out.println(mensajeFinal);
    }
}
}
