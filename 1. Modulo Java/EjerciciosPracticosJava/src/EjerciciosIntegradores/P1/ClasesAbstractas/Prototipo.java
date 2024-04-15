package EjerciciosIntegradores.P1.ClasesAbstractas;

public abstract class Prototipo <T extends Number> {
    protected T suma;
    protected T valorSerie;

    public abstract T siguienteNumero();

    public void reiniciarSerie(){
        valorSerie = null;
    }

    public abstract T comenzarSerie(T valorIncial);
}
