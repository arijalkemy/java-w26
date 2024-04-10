package org.example;

import java.util.ArrayList;
import java.util.List;

public class Ejemplo {
    private List<String> nombres;

    public Ejemplo(){
                this.nombres = new ArrayList<>();
                this.nombres.add("Eze");
                this.nombres.add("Vani");

                this.nombres.size();

            for (String nombre : this.nombres) {
                System.out.println(nombre);
            }
        }
}
