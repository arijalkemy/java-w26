package EjerciciosIntegradores.P1.AgenciaTurismo;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private List<Reserva> reservas;
    private Cliente cliente;
    private double costoTotal = 0;
    private int dosBoletos = 0;
    private int dosHoteles = 0;
    private boolean contieneHotel = false;
    private boolean contieneBoleto = false;
    private boolean contieneComida = false;
    private boolean contieneTransporte = false;
    private boolean descuentoMasDeDosCompras = false;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.reservas = new ArrayList<Reserva>();
    }

    public void agregarReserva(Reserva reserva) {
        this.reservas.add(reserva);

        if(reserva.getProducto() instanceof Hotel){
            this.contieneHotel = true;
            if(!reserva.isDescuentoAplicado() && this.dosHoteles < 2){
                this.dosHoteles++;
            }
        }else if(reserva.getProducto() instanceof Boletos){
            this.contieneBoleto = true;
            if(!reserva.isDescuentoAplicado() && this.dosBoletos < 2){
                this.dosBoletos++;
            }
        }else if(reserva.getProducto() instanceof Transporte){
            this.contieneTransporte = true;
        }else if(reserva.getProducto() instanceof Comida){
            this.contieneComida = true;
        }

        if(this.dosHoteles == 2){
            descontarHotel();
            this.dosHoteles = 0;
        }else if(this.dosBoletos == 2){
            descontarBoletos();
            this.dosBoletos = 0;
        }

        calcularCosto();
    }

    private void descontarHotel(){
        int contadorHotel = 0;
        for(Reserva reserva : this.reservas){
            if(!reserva.isDescuentoAplicado() && reserva.getProducto() instanceof Hotel){
                if(contadorHotel == 2){
                    break;
                }
                reserva.setCosto(reserva.getCosto() - (reserva.getCosto() * 0.05));
                contadorHotel++;
            }
        }
    }

    public void setDescuento10() {
        this.descuentoMasDeDosCompras = true;
    }

    private void descontarBoletos(){
        int contadorBoleto = 0;
        for(Reserva reserva : this.reservas){
            if(!reserva.isDescuentoAplicado() && reserva.getProducto() instanceof Boletos){
                if(contadorBoleto == 2){
                    break;
                }
                reserva.setCosto(reserva.getCosto() - (reserva.getCosto() * 0.05));
                contadorBoleto++;
            }
        }
    }

    public void calcularCosto(){
        this.costoTotal = 0;

        for(Reserva reserva : this.reservas){
            this.costoTotal += reserva.getCosto();
        }

        if(this.contieneHotel && this.contieneBoleto && this.contieneTransporte && this.contieneComida){
            this.costoTotal -= this.costoTotal * 0.1;
        }

        if(descuentoMasDeDosCompras){
            this.costoTotal -= this.costoTotal * 0.05;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Localizador{");
        sb.append("reservas=");
        for(Reserva re : this.reservas){
            sb.append(re.toString() + "\n");
        }
        //sb.append("reservas=").append(reservas);
        sb.append(", cliente=").append(cliente);
        sb.append(", costoTotal=").append(costoTotal);
        sb.append(", descuentoMasDeDosCompras=").append(descuentoMasDeDosCompras);
        sb.append('}');
        return sb.toString();
    }
}
