package modelo;

import interfaces.TipoDeVuelo;

import java.util.ArrayList;
import java.util.List;

public class VueloConEscalas implements TipoDeVuelo {

    private List<Escala> escalas = new ArrayList<>();

    public VueloConEscalas(List<Escala> escalas) {
        this.escalas = escalas;
    }

    @Override
    public double getDuracion() {
        return this.escalas.stream().mapToDouble(e -> e.getDuracionEnHs()).sum();
    }

    public List<Escala> getEscalas() {
        return escalas;
    }

    public void setEscalas(List<Escala> escalas) {
        this.escalas = escalas;
    }
}
