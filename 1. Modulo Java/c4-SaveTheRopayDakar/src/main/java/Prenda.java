public class Prenda {
    private String marca;
    private String modelo;

    public Prenda(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Prenda{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }

    public String getMarca() {
        return marca;
    }

    public Prenda setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public String getModelo() {
        return modelo;
    }

    public Prenda setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }
}
