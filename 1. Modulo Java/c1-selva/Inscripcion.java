public class Inscripcion{
    private Categoria categoria;
    private Participante participante;
    private int abono;

    public Inscripcion(Categoria categoria, Participante participante, int abono){
        this.categoria=categoria;
        this.participante=participante;
        this.abono=abono;

    }
    public int getAbono(){
        return abono;
    }
    public int getInscripcionCategoria(){
        return categoria.getId();
    }

    public void mostrarInscripcion(){
        System.out.println("=================");
        System.out.println("Categoria:\n Id:"+categoria.getId()+" Nombre:"+categoria.getNombre()+" Descripcion:"+categoria.getDescripcion()+"\nParticipante:\nNombre:"+participante.getNombre()+" Edad:"+participante.getEdad()+"\n Abono:"+abono);
    }
}