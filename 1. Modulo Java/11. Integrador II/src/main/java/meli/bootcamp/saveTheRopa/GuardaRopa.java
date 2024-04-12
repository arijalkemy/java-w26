package meli.bootcamp.saveTheRopa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
  Map<Integer, List<Prenda>> diccionarioDePrendas;
  Integer contador;

  public GuardaRopa() {
    this.diccionarioDePrendas = new HashMap<>();
    this.contador = 0;
  }

  public Integer guardarPrendas(List<Prenda> prendas) {
    this.diccionarioDePrendas.put(contador, prendas);
    return contador++;
  }

  public void mostrarPrendas() {
    for (Map.Entry<Integer, List<Prenda>> entry : diccionarioDePrendas.entrySet()) {
      System.out.println("Clave = " + entry.getKey() + ", Valor = " + entry.getValue());
    }
  }

  public List<Prenda> devolverPrendas(Integer numero) {
    return diccionarioDePrendas.get(numero);
  }

}
