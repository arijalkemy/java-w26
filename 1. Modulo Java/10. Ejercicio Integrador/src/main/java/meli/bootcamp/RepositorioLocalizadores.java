package meli.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizadores {
  public List<Localizador> localizadores;

  public RepositorioLocalizadores() {
    this.localizadores = new ArrayList<>();
  }

  public RepositorioLocalizadores(List<Localizador> localizadores) {
    this.localizadores = localizadores;
  }

  public void agregarLocalizador(Localizador localizador) {
    this.localizadores.add(localizador);
  }

  public boolean adquirioMasDeDosLocalizadores(Cliente cliente) {
    return localizadores.stream().filter(localizador -> localizador.cliente.equals(cliente)).count() > 2;
  }
}
