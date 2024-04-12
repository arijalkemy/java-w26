public class Vehiculo {
    private String modelo;
    private String marca;
    private int costo;

    private static int id;

    public Vehiculo(String modelo, String marca, int costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

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

    public boolean getMayor1000(){
        return costo>=1000;
    }

    public boolean getMenor1000(){
        return costo<1000;
    }

    @Override
    public String toString() {
        return "Vehiculo: " +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", costo=" + costo;
    }
}
