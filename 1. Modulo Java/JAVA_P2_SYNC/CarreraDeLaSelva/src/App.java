import java.util.HashSet;
import java.util.Set;

import categoria.Categoria;
import categoria.CircuitoChico;
import categoria.CircuitoMedio;
import categoria.CircuitoAvanzado;

enum CATEGORIAS {
    CHICO(new CircuitoChico(), 1),
    MEDIO(new CircuitoMedio(), 2),
    AVANZADO(new CircuitoAvanzado(), 3);

    private Categoria categoria;
    private int id;

    private CATEGORIAS(Categoria categoria, int id) {
        this.categoria = categoria;
        this.id = id;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public int getId() {
        return this.id;
    }

}

public class App {

    Set<Inscripcion> inscritos;

    public App() {
        this.inscritos = new HashSet<Inscripcion>();
    }

    public void inscribir(int dni, String nombre, String apellido, int edad, String celular, String numero_emergencia,
            String rh, CATEGORIAS categoria) {
        Categoria categoriaSeleccionada = categoria.getCategoria();
        int monto = categoriaSeleccionada.getMonto(edad);

        if (monto == -1) {
            System.out.println("No puede registrarse en esta categoria!\n");
            return;
        }

        Participante participante = new Participante(monto, dni, nombre, apellido, edad, celular, numero_emergencia,
                rh);

        Inscripcion inscripciones_nueva = new Inscripcion(participante, monto, categoria.getId());

        if (this.inscritos.add(inscripciones_nueva)) {
            System.out.println("Participante inscrito correctamente!!!");
        } else {
            System.out.println("El participante ya se encuentra inscrito en alguna categoria.");
        }

    }

    public void desinscribir(int dni) {
        for (Inscripcion inscripcion : inscritos) {
            if (inscripcion.participante.dni == dni) {
                if (inscritos.remove(inscripcion)) {
                    System.out.println("El participante con el DNI " + dni + " fue removido.");
                } else
                {
                    System.out.println("Imposible de realizar!!!");
                }
                return; 
            }
        }
        System.out.println("No se encontro el usuario");
    }

    public void listarInscritos(CATEGORIAS categoria) {

        if (this.inscritos.isEmpty()) {
            System.out.println("No hay ningun inscrito aún.");
            return;
        }

        System.out.println("Lista de inscripciones. Categoria => " + categoria.getId());
        for (Inscripcion inscripcion : inscritos) {
            if (inscripcion.getId_categoria() == categoria.getId()) {
                System.out.println(inscripcion.toString());

            }
        }

        System.out.println("\n");

    }

    public void listarInscritos() {
        if (this.inscritos.isEmpty()) {
            System.out.println("No hay ningun inscrito aún.\n");
            return;
        }

        System.out.println("Lista de inscripciones");
        for (Inscripcion inscripcion : inscritos) {
            System.out.println(inscripcion.toString());
        }
        System.out.println("\n");
    }

    public void totalRecaudado()
    {
        int total = 0;
        for (Inscripcion inscripcion : inscritos) {
            total += inscripcion.getMonto();
        }
        System.out.println("Total carrera");
        System.out.println("Total recaudado: " + total + "\n");
    }

    public void totalRecaudado(CATEGORIAS categoria)
    {
        int total = 0;
        for (Inscripcion inscripcion : inscritos) {
            if (inscripcion.getId_categoria() == categoria.getId()) {
                total += inscripcion.getMonto();
            }
        }
        System.out.println("Categoria #"+categoria.getId());
        System.out.println("Total recaudado: " + total + "\n");
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        app.inscribir(0, "Arturo", "Vargas", 22, "3194362362", "3204843724", "O+", CATEGORIAS.CHICO);
        app.inscribir(1, "Federico", "Vargas", 17, "3194362362", "3204843724", "O+", CATEGORIAS.CHICO);
        
        app.inscribir(2, "Antonio", "Vargas", 17, "3194362362", "3204843724", "O+", CATEGORIAS.MEDIO);
        app.inscribir(3, "Alvaro", "Vargas", 22, "3194362362", "3204843724", "O+", CATEGORIAS.MEDIO);
        
        app.inscribir(4, "Aldo", "Vargas", 17, "3194362362", "3204843724", "O+", CATEGORIAS.AVANZADO);
        app.inscribir(5, "Daniel", "Vargas", 22, "3194362362", "3204843724", "O+", CATEGORIAS.AVANZADO);
        
        app.listarInscritos();

        app.desinscribir(0);
        app.listarInscritos(CATEGORIAS.CHICO);

        app.totalRecaudado(CATEGORIAS.CHICO);
        app.totalRecaudado(CATEGORIAS.MEDIO);
        app.totalRecaudado(CATEGORIAS.AVANZADO);
        app.totalRecaudado();



    }
}
