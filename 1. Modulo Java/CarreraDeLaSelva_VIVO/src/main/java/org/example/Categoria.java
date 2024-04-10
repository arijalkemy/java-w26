package org.example;

public class Categoria {
    int id;
    String nombre;
    String descripcion;

    int precio = 0;

    public Categoria(int id) {
        switch (id) {
            case 1:
                this.id = 1;
                this.nombre = "Circuito chico";
                this.descripcion = "2 km por selva y arroyos";
                break;
            case 2:
                this.id = 2;
                this.nombre = "Circuito mediano";
                this.descripcion = "5 km por selva, arroyos y barro";
                break;
            case 3:
                this.id = 3;
                this.nombre = "Circuito grande";
                this.descripcion = "10 km por selva, arroyos, barro y escalada en piedra";
                break;
        }
    }
    public int validarCategoria(Participante participante) {
        boolean mayorEdad = participante.edad >= 18;
        switch (this.id) {
            case 1:
                if (mayorEdad) {
                    this.precio = 1500;
                    System.out.println("Monto a abonar: " + this.precio);
                    return 1;
                } else {
                    this.precio = 1300;
                    System.out.println("Monto a abonar: " + this.precio);
                    return 1;
                }
            case 2:
                if (mayorEdad) {
                    this.precio = 2300;
                    System.out.println("Monto a abonar: " + this.precio);
                    return 1;
                } else {
                    this.precio = 2000;
                    System.out.println("Monto a abonar: " + this.precio);
                    return 1;
                }
            case 3:
                if (mayorEdad) {
                    this.precio = 2800;
                    System.out.println("Monto a abonar: " + this.precio);
                    return 1;
                } else {
                    return -1;
                }
            default:
                return -1;
        }
    }
}
