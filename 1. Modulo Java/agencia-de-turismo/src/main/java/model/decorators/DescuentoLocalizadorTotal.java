package model.decorators;

import Interfaces.ILocalizador;

public class DescuentoLocalizadorTotal extends DescuentoLocalizadorDecorator {

    private double porcentajeDeDescuento;


    public DescuentoLocalizadorTotal(ILocalizador localizador, double porcentajeDeDescuento) {
        super(localizador);
        this.porcentajeDeDescuento = porcentajeDeDescuento;
        this.setTotal(this.getTotal());
    }

    @Override
    public double getTotal() {
        if(fueElDescuentoAplicado){
            return this.getLocalizador().getTotal();
        }

        this.fueElDescuentoAplicado = true;

        return this.getLocalizador().getTotal() * (1 - ((double) this.porcentajeDeDescuento/100));
    }

    public double getPorcentajeDeDescuento() {
        return porcentajeDeDescuento;
    }

    public void setPorcentajeDeDescuento(double porcentajeDeDescuento) {
        this.porcentajeDeDescuento = porcentajeDeDescuento;
    }
}
