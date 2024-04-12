package bootcamp.bendezujonathan.garage;
import java.util.Objects;

public class Vehiculo {
    private String marca;
    private String modelo;
    private Double costo;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, Double costo) {
        this.marca = marca;
        this.modelo = modelo;
        this.costo = costo;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getCosto() {
        return this.costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Vehiculo)) {
            return false;
        }
        Vehiculo vehiculo = (Vehiculo) o;
        return this.modelo.equals(vehiculo.modelo) && 
             this.marca.equals(vehiculo.marca) && 
             this.costo.equals(vehiculo.costo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.modelo, this.marca, this.costo) + 7;
    }
    
    
}
