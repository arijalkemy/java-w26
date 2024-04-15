package meli.bootcamp.AgenciaDeTurismo;

public class Reserva {
    private TipoReserva tipoReserva;
    private Double valor;

    public Reserva(TipoReserva tipoReserva) {
        this.tipoReserva = tipoReserva;
        switch (tipoReserva) {
            case HOTEL:
                this.valor = 100.0;
                break;
            case VIAJE:
                this.valor = 200.0;
                break;
            case COMIDA:
                this.valor = 20.0;
                break;
            case TRANSPORTE:
                this.valor = 30.0;
                break;
            default:
                this.valor = 350.0;
                break;
        }
    }

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(TipoReserva tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public Double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Reserva{" + "tipoReserva=" + tipoReserva + ", valor=" + valor + '}';
    }
}
