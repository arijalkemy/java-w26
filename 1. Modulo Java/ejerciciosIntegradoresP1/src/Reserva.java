import java.util.Objects;

public abstract class Reserva {

    private double valor;
    private int reservaId;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Reserva(double valor, int reservaId) {
        this.valor = valor;
        this.reservaId = reservaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return reservaId == reserva.reservaId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(reservaId);
    }

}
