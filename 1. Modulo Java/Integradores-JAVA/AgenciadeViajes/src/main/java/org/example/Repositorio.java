package org.example;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    private List<Localizador> localizadoresLista;

    public Repositorio(){
        this.localizadoresLista = new ArrayList<>();
    }
    public Repositorio(List<Localizador> localizadoresLista) {
        this.localizadoresLista = localizadoresLista;
    }

    public List<Localizador> getLocalizadoresLista() {
        return localizadoresLista;
    }

    public void setLocalizadoresLista(List<Localizador> localizadoresLista) {
        this.localizadoresLista = localizadoresLista;
    }

    public void agregarLocalizador(Localizador loc){
        //Agregar llamada a descuentos
        if(cantidadDeLocalizadoresPorCliente(loc.getCliente().getDni())>2){
            loc.modificarDescuento(0.05);
        }
        this.localizadoresLista.add(loc);
    }

    public long cantidadDeLocalizadoresPorCliente(Integer dni){
        return this.localizadoresLista.stream().filter(l->l.getCliente().getDni()==dni).count();
    }


}
