public class Participante {
int id_participante; int dni; String nombre; String apellido; int edad; String celular; String numero_emergencia; String rh;

public Participante(int id_participante, int dni, String nombre, String apellido, int edad, String celular,
        String numero_emergencia, String rh) {
    this.id_participante = id_participante;
    this.dni = dni;
    this.nombre = nombre;
    this.apellido = apellido;
    this.edad = edad;
    this.celular = celular;
    this.numero_emergencia = numero_emergencia;
    this.rh = rh;
}

@Override
public String toString() {
    return this.nombre + " " + this.apellido + ". DNI: " + this.dni;
}

public int getId_participante() {
    return id_participante;
}

public void setId_participante(int id_participante) {
    this.id_participante = id_participante;
}

public int getDni() {
    return dni;
}

public void setDni(int dni) {
    this.dni = dni;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public String getApellido() {
    return apellido;
}

public void setApellido(String apellido) {
    this.apellido = apellido;
}

public int getEdad() {
    return edad;
}

public void setEdad(int edad) {
    this.edad = edad;
}

public String getCelular() {
    return celular;
}

public void setCelular(String celular) {
    this.celular = celular;
}

public String getNumero_emergencia() {
    return numero_emergencia;
}

public void setNumero_emergencia(String numero_emergencia) {
    this.numero_emergencia = numero_emergencia;
}

public String getRh() {
    return rh;
}

public void setRh(String rh) {
    this.rh = rh;
}

}
