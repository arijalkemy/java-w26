public class Main {
    public static void main(String[] args) {
        double sueldoBase = 17000; //monto de ejemplo
        String dni = "12345678"; //dni de ejemplo
        double sueldoConAumento;

        if (sueldoBase <= 20000) {
            sueldoConAumento = sueldoBase * 1.20;
        } else if (sueldoBase > 20000 && sueldoBase <= 45000) {
            sueldoConAumento = sueldoBase * 1.10;
        } else {
            sueldoConAumento = sueldoBase * 1.05;

        }

        System.out.println("El nuevo sueldo del empleado es de: " + sueldoConAumento);

    }
}


