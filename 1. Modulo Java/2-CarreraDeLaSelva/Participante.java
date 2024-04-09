public class Participante {
    private static int contador = 0; //lo uso para definir el id del participante
    private int id;
    private int dni;
    private String nombreApellido;
    private int edad;
    private String categoria;
    private int monto;

    public Participante(int dni, String nombreApellido, int edad, String categoria) {
        contador++;
        this.id = contador;
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.edad = edad;
        this.categoria = categoria;
        if (edad > 18) {
            switch (categoria) {
                case "Chico":
                    this.monto = 1500;
                    break;
                case "Medio":
                    this.monto = 2300;
                    break;
                case "Avanzado":
                    this.monto = 2800;
                    break;
                //al usar carga manual, en caso de existir typo, le asigno valor 0 para no modificar el resultado final
                default:
                    this.monto = 0;
                    break;
            }
        } else {
            switch (categoria) {
                case "Chico":
                    this.monto = 1300;
                    break;
                case "Medio":
                    this.monto = 2000;
                    break;
                default:
                //en caso que sea menor o haya typo, no es contabilizado en el monto total de esta forma.
                    this.monto = 0;
                    break;
            }
        }
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public int getDni() {
        return dni;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getMonto() {
        return monto;
    }
}
