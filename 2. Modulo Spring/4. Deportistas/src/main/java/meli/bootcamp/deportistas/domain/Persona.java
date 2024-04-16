package meli.bootcamp.deportistas.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Persona {
  String nombre;
  String apellido;
  int edad;
  public Deporte deporte;

  public Persona(String nombre, String apellido, int edad) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.edad = edad;
  }

  public void asignarDeporte(Deporte deporte) {
    this.deporte = deporte;
  }

  public boolean esDeportista() {
    return this.deporte != null;
  }

}
