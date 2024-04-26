package POO;

public class Ejercicio1{
    public static void main(String [] args){
        String mensajeFinal = "Este es el ultimo mensaje";
        
        try{
            int[] numeros = new int[5];
            numeros[5] = 10;
        } catch (Exception e){
            System.out.println(e);
        } finally {
            System.out.println(mensajeFinal);
        }
    }
}