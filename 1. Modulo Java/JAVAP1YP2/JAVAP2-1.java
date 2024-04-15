public class Main{
    public static void main(String[] args){
        double sueldoBase = 18500; //monto de ejemplo
        int dni = 38146945;
        double sueldoConAumento;

        if (sueldoBase <= 20000) { //corresponde un aumento del 20%
            sueldoConAumento= sueldoBase * 1.2;
            }
            else {
        if (sueldoBase > 20000 && sueldoBase<=45000){// corresponde un aumento del 10%
            sueldoConAumento= sueldoBase * 1.2;
            } 
            else { //correspnde un aumento del 5%
                sueldoConAumento= sueldoBase * 1.2;
            }
        }

    System.out.println ("El nuevo sueldo del empleado con dni: "+ dni + " es de: " + sueldoConAumento);

    }
}