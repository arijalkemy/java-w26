import java.util.Optional;

public class Categoria {

    private static int contadorId = 0;

    private int id;
    private String nombre;
    private String descripcion;

    private boolean aceptaMenor;

    private double precioMayor;

    private double precioMenor;

    public Categoria(String nombre, String descripcion,double precioMayor, Optional<Double> precioMenor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id = contadorId;
        this.precioMayor = precioMayor;
        if(precioMenor.isPresent()){
            this.precioMenor = precioMenor.get();
            this.aceptaMenor = true;
        }else{
            this.aceptaMenor = false;
        }
        contadorId++;
    }

    public int getId(){
        return this.id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isAceptaMenor() {
        return aceptaMenor;
    }

    public void setAceptaMenor(boolean aceptaMenor) {
        this.aceptaMenor = aceptaMenor;
    }

    public double getPrecioMayor() {
        return precioMayor;
    }

    public void setPrecioMayor(double precioMayor) {
        this.precioMayor = precioMayor;
    }

    public double getPrecioMenor() {
        return precioMenor;
    }

    public void setPrecioMenor(double precioMenor) {
        this.precioMenor = precioMenor;
    }






}
