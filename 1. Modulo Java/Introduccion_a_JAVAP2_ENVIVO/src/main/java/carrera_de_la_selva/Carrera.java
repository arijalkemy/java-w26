package carrera_de_la_selva;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
/*Clase que por medio de listas crea categorias, participantes e inscripción*/
public class Carrera {
    private List<Categoria> categorias;
    private List <Participante> participantes;
    private List <Inscripcion> inscripciones;

    public Carrera() {
        this.categorias = new ArrayList<>();
        this.participantes = new ArrayList<>();
        this.inscripciones = new ArrayList<>();
    }
    /*Función agregar categoria*/
    public void agregarCategoria(Categoria categoria) {
        this.categorias.add(categoria);
    }
    /*Función inscribir participantes*/
    public void inscribirParticipante(Participante participante, Categoria categoria) {
        Inscripcion inscripcion = new Inscripcion(categoria, participante);
        this.participantes.add(participante);
        this.inscripciones.add(inscripcion);
    }
    /*Función desincribir participantes*/
    public void desinscribirParticipante(int numero) {
        for(Iterator<Inscripcion> iterator = inscripciones.iterator(); iterator.hasNext();) {
            Inscripcion inscripcion = iterator.next();
            if(inscripcion.getParticipante().getNumero()==numero){
                iterator.remove();
                System.out.println("Participante desinscrito: "+inscripcion.getParticipante()) ;
            }
            return;
        }
        System.out.println("Participante no encontrado: "+numero);
    }
    /*Función mostrar participantes por categorias*/
    public void mostrarParticipantesPorCategoria(int id) {
        /*Uso del .strea y el filter*/
        List<Inscripcion> inscritos = inscripciones.stream().filter(inscripcion -> inscripcion.getCategoria().getId()==id).collect(Collectors.toList());
        System.out.println("Lista de participantes inscritos en la categoria "+id+":" );
        for(Inscripcion inscripcion: inscritos){
            Participante p = inscripcion.getParticipante();
            System.out.println("Número: "+p.getNumero()+", Nombre: "+p.getNombre()+" "+p.getApellido());
        }
    }
    /*Función calcular recaudos con stream más map*/
    public void calcularRecaudos(){
        int total=inscripciones.stream().mapToInt(Inscripcion::getMonto).sum();
        System.out.println("Total de recaudo: "+total);
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }
}