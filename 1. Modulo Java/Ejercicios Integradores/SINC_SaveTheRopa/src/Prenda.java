public class Prenda {
    private String tipo;
    private String marca;
    private String modelo;

    public Prenda(String tipo, String marca, String modelo) {
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
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

    @Override
    public String toString() {
        return "Tipo: " + tipo + " - Marca: " + marca + " - Modelo: " + modelo;
    }
}
