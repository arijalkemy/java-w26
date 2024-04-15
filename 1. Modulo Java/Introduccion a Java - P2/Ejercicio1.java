public class Ejercicio1 {
    public static void main(String[] args) {
        double sueldoBase = 21000; //monto de ejemplo
        String dni = "12345678"; //dni de ejemplo
        double sueldoConAumento;

        if (sueldoBase>45000) {
            sueldoConAumento = sueldoBase + (sueldoBase * 0.05);
        }
        else {
            if (sueldoBase>20000){
                sueldoConAumento = sueldoBase + (sueldoBase * 0.1);
            }
            else {
                sueldoConAumento = sueldoBase + (sueldoBase * 0.2);
            }
        }
        System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);
    }
}
