/*

Una empresa de paquetería desea realizar una actualización de los sueldos de sus empleados. Para ello, desean la creación de un programa que al asignar un dni y un monto determine si al empleado en cuestión le corresponde o no un aumento. Para ello tiene en cuenta las siguientes condiciones:

a) Si el sueldo es menor o igual a $20.000 le corresponde un 20% de aumento.

b) Si el sueldo es mayor a $20.000 pero menor o igual a $45.000 le corresponde un 10% de aumento.

c) Si el sueldo es mayor a $45.000 le corresponde un 5% de aumento.

    Un programador comenzó con el planteo, pero necesita un poco de ayuda para determinar las condiciones para cada uno de los casos y qué acciones deberían hacerse... ¿Podrías ayudarlo a terminar?
     */
public class Main{

    public static void main(String[] args){
        double sueldoBase = 21000; //monto de ejemplo
        String dni = "12345678"; //dni de ejemplo
        double sueldoConAumento;

        if (sueldoBase <= 20000) {
            sueldoConAumento = sueldoBase * 0.2;
        }
        else {
            if (sueldoBase > 20000 && sueldoBase <= 45000){
                sueldoConAumento = sueldoBase * 0.1;
            }
            else  {
                sueldoConAumento = sueldoBase * 0.5;
            }
        }

        System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);
    }
}
