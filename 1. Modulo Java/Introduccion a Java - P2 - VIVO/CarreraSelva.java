import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarreraSelva {
    public static void main(String[] args) {

        Set<Inscripcion> listaDeInscripciones = new HashSet<>();

        Categoria circuitoChico = new Categoria("1", "Circuito chico","2 km por selva y arroyos.");
        Categoria circuitoMedio = new Categoria("2", "Circuito medio","5 km por selva, arroyos y barro.");
        Categoria circuitoAvanzado = new Categoria("3", "Circuito avanzado","0 km por selva, arroyos, barro y escalada en piedra.");

        Participante participanteUno = new Participante(1, 111, "Participante", "Uno",
                21, 111, 111, "0");
        Participante participanteDos = new Participante(2, 111, "Participante", "Dos",
                21, 111, 111, "0");
        Participante participanteTres = new Participante(3, 111, "Participante", "Tres",
                21, 111, 111, "0");

        Inscripcion inscripcionUno = new Inscripcion(1, circuitoChico, participanteUno);
        Inscripcion inscripcionDos = new Inscripcion(2, circuitoMedio, participanteDos);
        Inscripcion inscripcionTres = new Inscripcion(3, circuitoAvanzado, participanteTres);

        listaDeInscripciones.add(inscripcionUno);
        listaDeInscripciones.add(inscripcionDos);
        listaDeInscripciones.add(inscripcionTres);

        System.out.println("Inscripcion participante: "+ inscripcionUno.participante.apellido + " monto a pagar: " + inscripcionUno.monto);

        List<Inscripcion> listaFiltrada = listaDeInscripciones.stream()
                .filter(elem -> elem.categoria.nombre.equals("Circuito chico")).toList();
        System.out.println(listaFiltrada);
    }
}

class Categoria {
    String id;
    String nombre;
    String descripcion;
    public Categoria(String id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}

class Participante {
    int numero;
    int dni;
    String nombre;
    String apellido;
    int edad;
    int celular;
    int numeroEmergencia;
    String grupoSanguineo;

    @Override
    public String toString() {
        return "Participante{" +
                "numero=" + numero +
                ", dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", celular=" + celular +
                ", numeroEmergencia=" + numeroEmergencia +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                '}';
    }

    public Participante(int numero, int dni, String nombre, String apellido, int edad, int celular,
                        int numeroEmergencia, String grupoSanguineo) {
        this.numero = numero;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}

class Inscripcion {
    int numeroInscripcion;
    Categoria categoria;
    Participante participante;
    double monto;

    @Override
    public String toString() {
        return "Inscripcion{" +
                "numeroInscripcion=" + numeroInscripcion +
                ", categoria=" + categoria +
                ", participante=" + participante +
                ", monto=" + monto +
                '}';
    }

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = montoAPagar();
    }

    public Integer montoAPagar() {
        if (this.categoria.nombre.equals("Circuito chico")) {
            if (this.participante.getEdad() < 18) {
                return 1300;
            } else {
                return 1500;
            }
        }
        if (this.categoria.nombre.equals("Circuito medio")) {
            if (this.participante.getEdad() < 18) {
                return 2000;
            } else {
                return 2300;
            }
        }
        if (this.categoria.nombre.equals("Circuito avanzado")) {
            if (this.participante.getEdad() >= 18) {
                return 2800;
            }
        }
        throw new RuntimeException("No se pudo realizar la inscripcion");
    }
}
