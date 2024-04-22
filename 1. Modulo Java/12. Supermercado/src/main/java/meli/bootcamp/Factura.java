package meli.bootcamp;

import java.util.HashMap;
import java.util.Map;

public class Factura {
  private Cliente cliente;
  private final Map<Item, Integer> items; // <Item, cantidad>

  public Factura(Cliente cliente) {
    this.cliente = cliente;
    this.items = new HashMap<>();
  }

  public void agregarItem(Item item, Integer unidades) {
    if (items.containsKey(item)) {
      items.put(item, items.get(item) + unidades);
    } else {
      items.put(item, unidades);
    }
  }

  public Double obtenerTotal() {
    return items.entrySet().stream()
        .mapToDouble(i -> i.getKey().costo() * i.getValue())
        .sum();
  }
}
