package EjerciciosIntegradores.P2.Dakar;

public class TipoVehiculo {
    private String tipo;
    private int ruedas;
    private int peso;

    public TipoVehiculo(String tipo, int ruedas, int peso) {
        this.tipo = tipo;
        this.ruedas = ruedas;
        this.peso = peso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "tipoVehiculo{" +
                "tipo='" + tipo + '\'' +
                ", ruedas=" + ruedas +
                ", peso=" + peso +
                '}';
    }
}
