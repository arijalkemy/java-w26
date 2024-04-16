package org.example.Ejercio2;

import java.util.ArrayList;
import java.util.List;

public class Persona {
   private   String nombreYApellido;
   private int edad;
   private String dni;
   private Curriculum cv;

   public Persona(String nombreYApellido, int edad, String dni) {
      this.nombreYApellido = nombreYApellido;
      this.edad = edad;
      this.dni = dni;

   }

   public String getNombreYApellido() {
      return nombreYApellido;
   }

   public int getEdad() {
      return edad;
   }

   public String getDni() {
      return dni;
   }


}
