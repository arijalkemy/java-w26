public class Participante {

    public int edad;
    public String nombre;
    public String apellido;
    public int dni;
    public int numeroDeInscripcion;
    public Categoria categoriaInscripto;

    public Participante (int edad, String nombre, String apellido, int dni){
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    @Override
    public String toString(){
        return "Nombre: " + this.nombre
            + " Apellido: " + this.apellido
            + " Edad: " + this.edad
            + " DNI: " + this.dni
            + " Nro de inscripción: " + this.numeroDeInscripcion;
    }

    public String getNombreCompleto(){
        return this.nombre + this.apellido;
    }

    public void inscribir (Categoria categoria){
        this.numeroDeInscripcion = categoria.inscribir();
        this.categoriaInscripto = categoria;
    }

    public void desinscribir(){
        if(this.categoriaInscripto != null) this.categoriaInscripto = null;
    }

    public boolean estaInscripto(){
        return this.categoriaInscripto != null;
    }

    public boolean puedeInscribir(Categoria categoria) {
        return categoria.puedeInscribir(this.edad);
    }

    public double precioInscripcion(){
        if(categoriaInscripto == null) return 0;
        return categoriaInscripto.calcularInscripcion(this.edad);
    }

    public String getCategoria(){
        if(this.categoriaInscripto == null) return "";
        return this.categoriaInscripto.getCategoria();
    }
}
