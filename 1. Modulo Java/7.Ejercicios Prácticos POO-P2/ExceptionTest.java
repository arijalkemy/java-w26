public class ExceptionTest{
    
    public static void main(String[]args){
        try{
            int[] numeros = new int[5];
            numeros[6] = 10;
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        } finally{
            String mensajeFinal = "Este es el último mensaje";
            System.out.println(mensajeFinal);
        }
        
    }
}