package Interfaces;

import model.Localizador;
import model.Reserva;

import java.util.List;

public interface ILocalizador {

    public double getTotal();
    public void setTotal(double total);

    public List<Reserva> getReservaList();
}
