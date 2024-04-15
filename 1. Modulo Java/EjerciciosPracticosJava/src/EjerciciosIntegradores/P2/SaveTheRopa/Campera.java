package EjerciciosIntegradores.P2.SaveTheRopa;

public class Campera extends Prenda {
    public Campera(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Campera{");
        sb.append("marca='").append(marca).append('\'');
        sb.append(", modelo='").append(modelo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
