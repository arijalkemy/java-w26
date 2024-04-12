package org.example.clases;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    List<Localizador> localizadorList;

    public List<Localizador> getLocalizadorList() {
        return localizadorList;
    }

    public void setLocalizadorList(List<Localizador> localizadorList) {
        this.localizadorList = localizadorList;
    }

    public Repositorio(){
        this.localizadorList = new ArrayList<>();
    }

    public Repositorio(List<Localizador> localizadorList) {
        this.localizadorList = localizadorList;
    }

    public void addLocalizador(Localizador localizador){
        aplicarDescuentoPorMasDe2Compras(localizador.getCliente());
        localizadorList.add(localizador);
    }

    private void aplicarDescuentoPorMasDe2Compras(Cliente cliente){
        //si el cliente NO tiene aplicado el descuento, nos fijamos si compro mas de dos veces
        if(!cliente.isTieneEl5DeDescuentoPorTenerMasDe2Localizadores()
            && localizadorList.stream().filter(loc -> loc.getCliente().equals(cliente)).count() >= 2)
            cliente.aplicarDescuento();
    }

    @Override
    public String toString() {
        return "Repositorio{\n" +
                "localizadorList=" + localizadorList +
                '}';
    }
}
