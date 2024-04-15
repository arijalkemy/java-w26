package model.decorators;

import Interfaces.ILocalizador;
import enums.ReservaNombres;
import model.Reserva;

import java.util.List;

public class DescuentoLocalizadorReserva extends DescuentoLocalizadorDecorator {

    private double descuento = 0.05;

    public DescuentoLocalizadorReserva(ILocalizador localizador) {
        super(localizador);
        this.setTotal(this.getTotal());
    }

    @Override
    public double getTotal() {

        if(fueElDescuentoAplicado){
            return this.getLocalizador().getTotal();
        }

        this.fueElDescuentoAplicado = true;

        List<Reserva> reservas = this.getLocalizador().getReservaList();

        double descuentoAAplicar = 0;
        int descuentosAplicados = 0;

        for(int i = 0; i< reservas.size(); i++){

            if(descuentosAplicados >=2){
                break;
            }

            if(reservas.get(i).getNombre() == ReservaNombres.HOTEL
                    || reservas.get(i).getNombre() == ReservaNombres.BOLETO_DE_VIAJE){
                descuentoAAplicar += reservas.get(i).getPrecio() * this.descuento;
                descuentosAplicados++;
            }
        }

        return this.getLocalizador().getTotal() - descuentoAAplicar;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}
