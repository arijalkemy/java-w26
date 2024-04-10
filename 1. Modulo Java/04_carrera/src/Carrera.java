
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Carrera {

    private int numero;
    private String nombre;
    private List<Inscripcion> inscripciones;
    private List<Categoria> categorias;
    private int inscripcionNumber;

    public Carrera(int numero, String nombre, List<Categoria> categorias) {
        this.numero = numero;
        this.nombre = nombre;
        this.inscripciones = new ArrayList<>();
        this.categorias = categorias;
    }

    public void inscribir(Participante nuevoParticipante, int numeroCategoria) {
        Categoria categoria = this.findCategoria(numeroCategoria);
        if (categoria == null) {
            System.out.println("[ERROR]: La categoria indicada para la inscripcion de " + nuevoParticipante.getNombre() + " no existe.");
            return;
        }

        if (!categoria.allowParticipant(nuevoParticipante.getEdad())) {
            System.out.println("[ERROR]: El participante " + nuevoParticipante.getNombre() + " no cumple los requisitos de edad de la categoria " + categoria.getNombre());
            return;
        }

        boolean alreadyExists = this.inscripciones
                .stream()
                .anyMatch((inscripcion) -> inscripcion.getParticipante().equals(nuevoParticipante)
                        &&
                        inscripcion.getCategoria().equals(categoria));

        if (alreadyExists) {
            System.out.println(
                    "[ERROR]: El parcipante " + nuevoParticipante.getNumero() + " Ya esta inscripto en la categoria");
            return;
        }

        int newInscripcionNumber = this.inscripcionNumber + 1;
        Inscripcion nuevaInscripcion = new Inscripcion(newInscripcionNumber, categoria, nuevoParticipante);
        this.inscripciones.add(nuevaInscripcion);
    }

    public void desinscribir(Participante eliminadoParticipante, int numeroCategoria) {
        Categoria categoria = this.findCategoria(numeroCategoria);
        if(categoria == null) {
            System.out.println("[ERROR]: La categoria indicada para la inscripcion de " + eliminadoParticipante.getNombre() + " no existe.");
            return;
        }

        Inscripcion inscripcionABorrar = this.inscripciones.stream()
                                        .filter(inscripcion -> inscripcion.getParticipante().equals(eliminadoParticipante)
                                                &&
                                                inscripcion.getCategoria().equals(categoria))
                                        .findFirst()
                                        .get();

        this.inscripciones.remove(inscripcionABorrar);
    }

    @Override
    public String toString() {
       return this.inscripciones
       .stream()
       .map((ins) -> ">> El participante " + ins.getParticipante().getNombre() + 
                    " esta inscripto en la categoria " + ins.getCategoria().getNombre()
       + " con un costo de: " + ins.getMonto())
       .collect(Collectors.joining("\n"));
    }

    private Categoria findCategoria(int numero) {
        for (Categoria categoria : categorias) {
            if (categoria.getId() == numero)
                return categoria;
        }
        return null;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getNumero() {
        return this.numero;
    }
}
