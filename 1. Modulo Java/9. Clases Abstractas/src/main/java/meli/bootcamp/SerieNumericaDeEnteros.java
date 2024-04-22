package meli.bootcamp;

public class SerieNumericaDeEnteros extends SerieProgresiva<Integer> {

  public SerieNumericaDeEnteros(Integer valorInicial, Integer salto) {
    super(valorInicial, salto);
  }

  @Override
  public Integer siguienteValor() {
    return this.valorActual += this.salto;
  }

  @Override
  public void setValorInicial(Integer nuevoValor) {
    this.valorInicial = nuevoValor;
    this.reiniciarSerie();
  }
}
