package diseno_de_clases_y_metodos;

public class Automovil {
    String marca;
    String color;
    double kilometros;

    public Automovil() {

    }

    public Automovil(String marca, String color, double kilometros) {
        this.marca = marca;
        this.color = color;
        this.kilometros = kilometros;
    }

    public String mostrarMarcaYColor() {
        String marcaYColor = "La marca del auto es: " + this.marca + ". El color del auto es: " + this.color;
        return marcaYColor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setKilometros(double kilometros) {
        this.kilometros = kilometros;
    }
}
