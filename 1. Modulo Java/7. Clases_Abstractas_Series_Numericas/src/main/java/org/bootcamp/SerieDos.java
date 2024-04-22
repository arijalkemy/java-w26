package org.bootcamp;

public class SerieDos extends PrototipoSerieNumerica<Integer>{
    public SerieDos() {
        valorInicial = 0;
    }

    @Override
    public Integer siguienteNumero() {

        return valorInicial += 2;
    }

    @Override
    public void reiniciarSerie() {
        valorInicial = 0;
    }

    @Override
    public void establecerInicio(Integer valorInicial) {
        this.valorInicial = valorInicial;
    }
}
