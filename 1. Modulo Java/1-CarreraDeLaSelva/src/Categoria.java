public class Categoria {

    public String categoria;
    public int cantidadKm;
    public int edadLimite;
    public String[] circuitos;
    public double precioMenores;
    public double precioMayores;
    public int cantidadInscriptos;

    public Categoria(String categoria, int cantidadKm, String[] circuitos, int edadLimite, double precioMenores, double precioMayores){
        this.categoria = categoria;
        this.cantidadKm = cantidadKm;
        this.circuitos = circuitos;
        this.edadLimite = edadLimite;
        this.precioMenores = precioMenores;
        this.precioMayores = precioMayores;
    }

    @Override
    public String toString(){
        return "Categoria: " + this.categoria + "Circuito: "+ this.circuitos.toString() + "Total kilometros: " + this.cantidadKm;
    }

    public String getCategoria(){
        return this.categoria;
    }

    public boolean puedeInscribir(int edad){
        return edad >= edadLimite;
    }

    public int inscribir(){
        this.cantidadInscriptos++;
        return this.cantidadInscriptos;
    }

    public double calcularInscripcion(int edad){
        if(edad < edadLimite) return precioMenores;
        return precioMayores;
    }
}
