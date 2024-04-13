package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardarRopa {
   private Map<Integer, List<Prenda>> guardaropa;
   private Integer counter;

    public GuardarRopa() {
        this.guardaropa = new HashMap<>();
        this.counter = 1;
    }
    public Integer guardarPrendas(List<Prenda> listaDePrendas){
        Integer currentIndex = this.counter;
        this.guardaropa.put(currentIndex,listaDePrendas);
        this.counter++;
        return currentIndex;
    }
    public List<Prenda> devolverPrendas(Integer index){
        return guardaropa.get(index);
    }
}
