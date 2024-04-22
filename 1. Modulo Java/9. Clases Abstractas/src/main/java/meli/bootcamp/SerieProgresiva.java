package meli.bootcamp;

public abstract class SerieProgresiva<T extends Number> {
  T valorInicial;
  T salto;
  T valorActual;

  public SerieProgresiva(T valorInicial, T salto) {
    this.valorInicial = valorInicial;
    this.salto = salto;
    this.valorActual = valorInicial;
  }

  abstract public T siguienteValor();

  abstract public void setValorInicial(T nuevoValor);

  public void reiniciarSerie() {
    this.valorActual = this.valorInicial;
  }
}
