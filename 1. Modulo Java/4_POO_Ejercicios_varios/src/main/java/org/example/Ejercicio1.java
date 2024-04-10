package org.example;

/**
 * Consigna:
 * <p>
 * Al momento de crear la clase Automovil se han cometido algunos errores en su diseño.
 * ¿Puedes identificarlos y corregirlos siguiendo lo que has aprendido acerca de ellas?
 * <p>
 * Pistas: (opcional)
 * <p>
 * Recuerda las palabras reservadas y la sintáxis que hemos aprendido para la creación de clases
 * y la construcción de los métodos.
 */
public class Ejercicio1
{
    public static class Automovil {

        String marca;
        String color;
        double kilometros;

        public Automovil() {
            this.marca = "Desconocida";
            this.color = "Desconocido";
            this.kilometros = 0;
        }

        public Automovil(String marca, String color, double kilometros) {
            this.marca = marca;
            this.color = color;
            this.kilometros = kilometros;
        }

        public String mostrarMarcaYColor() {
            String marcaYColor = "La marca del auto es: " + this.marca + ". El color del auto es: " + this.color;
            return marcaYColor;
        }
    }
}
