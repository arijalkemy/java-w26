public class Vehiculo {
    //atributos
    private String modelo;
    private String marca;
    private int costo;

    //constructor
    public Vehiculo(String modelo, String marca, int costo){
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    //metodo para visualizar la informacion de la clase
    @Override
    public String toString() {
        return "Vehiculo{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", costo=" + costo +
                '}';
    }

    //Setters y Getters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
}
