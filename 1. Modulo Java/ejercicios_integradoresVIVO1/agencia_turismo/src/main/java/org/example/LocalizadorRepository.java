package org.example;

import java.util.ArrayList;
import java.util.List;

public class LocalizadorRepository {
    List<Localizador> localizadores;

    public LocalizadorRepository() {
        this.localizadores = new ArrayList<Localizador>();
    }
    public void agregarLocalizador(Localizador localizador){

        Cliente cliente = localizador.getCliente();
        if (tieneMasDeDosLocalizadores(cliente)) {
            localizador.aplicarDescuento(0.95);
        }
        this.localizadores.add(localizador);
    }

    private boolean tieneMasDeDosLocalizadores(Cliente cliente){
        int countLocalizadorxCliente =0;
        for (Localizador localizador: this.localizadores){
            if (countLocalizadorxCliente==2){
                return true;
            }
            if(localizador.getCliente().equals(cliente)){
                countLocalizadorxCliente++;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        String resultado ="Listado de Localizadores {";
        for (Localizador localizador: localizadores)
        {
            resultado+=localizador.toString()+",\n";
        }
        resultado+="}";
        return resultado;
    }
}
