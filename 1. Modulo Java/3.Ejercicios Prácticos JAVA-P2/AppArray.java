public class AppArray{
    
    public static void main(String[]args){
        double sueldoBase = 21000; //monto de ejemplo
        String dni = "12345678"; //dni de ejemplo
        double sueldoConAumento = 0;
        
        double aumento = 0;
        
        if (sueldoBase <= 20000) {
            aumento = 0.20;
        } else if ((sueldoBase > 20000) && (sueldoBase < 45000) ){
            aumento = 0.10;
        } else {
            aumento = 0.05;
        }
        
        sueldoConAumento = sueldoBase + sueldoBase*aumento;
        System.out.println ("El nuevo sueldo del empleado con dni " + dni + "es de: " + sueldoConAumento);
            }
}