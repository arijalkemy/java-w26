package model.decorators;

import Interfaces.ILocalizador;
import model.Cliente;
import model.Localizador;
import model.Reserva;

import java.util.List;

public abstract class DescuentoLocalizadorDecorator implements ILocalizador {

    private ILocalizador localizador;
    protected boolean fueElDescuentoAplicado = false;

    public DescuentoLocalizadorDecorator(ILocalizador localizador) {
        this.localizador = localizador;
    }

    public ILocalizador getLocalizador() {
        return localizador;
    }

    public void setTotal(double total){
        this.localizador.setTotal(total);
    }

    @Override
    public String toString() {
        return localizador.toString();
    }

    public void setLocalizador(ILocalizador localizador) {
        this.localizador = localizador;
    }

    public List<Reserva> getReservaList(){
        return this.localizador.getReservaList();
    }

}
