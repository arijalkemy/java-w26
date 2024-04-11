public class Vehiculo {
    private String modelo;
    private String marca;
    private double precio;

    public Vehiculo(String modelo, String marca, double precio){
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", precio=" + precio +
                '}';
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }


}
