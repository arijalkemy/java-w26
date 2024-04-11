import java.util.UUID;

public class Inscripcion {
    int id;
    Participante participante;
    int id_categoria;
    int monto;


   static int inscripciones = 1; 

    public Inscripcion(Participante participante, int monto, int id_categoria) {
        UUID uuid = UUID.randomUUID();
        this.id = uuid.hashCode();
        this.participante = participante;
        this.monto = monto;
        this.id_categoria = id_categoria;
        Inscripcion.inscripciones++;
    }

    @Override
    protected void finalize() throws Throwable {
        Inscripcion.inscripciones--;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + ". Categoria: " + this.id_categoria + ". Participante: " + participante.toString() + ". Monto: " + this.monto;      
    }

    

    @Override
    public int hashCode() {
        int result = this.participante.dni;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
    //if (obj.getClass() != this.getClass()) {
    //    return false;
    //}

    Inscripcion i2 = (Inscripcion) obj;    
    if (i2.hashCode() == this.hashCode()) {
        return true;
    }
    return false;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Participante getParticipante() {
        return participante;
    }
    public void setParticipante(Participante participante) {
        this.participante = participante;
    }
    public int getMonto() {
        return monto;
    }
    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public static int getInscripciones() {
        return inscripciones;
    }

    public static void setInscripciones(int inscripciones) {
        Inscripcion.inscripciones = inscripciones;
    }
 
}
