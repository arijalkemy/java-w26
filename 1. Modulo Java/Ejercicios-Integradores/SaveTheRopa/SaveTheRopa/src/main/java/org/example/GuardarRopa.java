package org.example;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class GuardarRopa {
    Map<UUID, List<Prenda>> Dic;

    public GuardarRopa() {
        this.Dic = new HashMap<>();
    }

    public UUID guardarPrendas(List<Prenda> prendasList){
        UUID randomUUID = UUID.randomUUID();
        this.Dic.put(randomUUID, prendasList);
        return randomUUID;
    }

    public void mostrarPrendas(){
        this.Dic.forEach((uuid, prendas) -> {
            String message = prendas.stream().map(prenda -> prenda.toString()).collect(Collectors.joining("\n"));
            System.out.println("UUID: " + uuid.toString() + " Prendas: \n" + message);
        });
    }

    public List<Prenda> devolverPrendas(UUID id){
        return this.Dic.getOrDefault(id, Collections.EMPTY_LIST);
    }
}
