package org.example.carrera;


import org.example.vehiculos.corredores.NombreVehiculo;
import org.example.vehiculos.corredores.Vehiculo;
import org.example.vehiculos.socorristas.Socorrista;
import org.example.vehiculos.socorristas.SocorristaAuto;
import org.example.vehiculos.socorristas.SocorristaMoto;

import java.util.*;

public class Carrera {

    private int id;
    private String nombre;
    private List<Vehiculo> corredores;
    private List<Socorrista> soccoristasAuto;
    private List<Socorrista> soccoristasMoto;

    private static final Random randomizer = new Random();

    public Carrera(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.corredores = new ArrayList<>();
        this.soccoristasAuto = new ArrayList<>();
        this.soccoristasMoto = new ArrayList<>();

    }

    public void eliminarVehiculo(String patente) {
        this.corredores
                .stream()
                .filter(corredor -> corredor.getPatente().equals(patente))
                .findFirst()
                .ifPresentOrElse(this::eliminarVehiculo,
                        () -> System.out.println("No se pudo elminar el vehiculo con la patente " + patente));
    }

    public Optional<Vehiculo> ganador() {
        return this.corredores
                .stream()
                .max(Comparator.comparing(Vehiculo::result));
    }

    public void anunciarInicio() {
        System.out.printf(">> Dando inicio al Dakar de %s numero %d!!%n", this.nombre, this.id);
        System.out.println(">> Los corredores son: ");
        this.corredores.forEach(System.out::println);
        System.out.printf(">> Hoy contamos con %d Socorristas de autos y %d Socorristas de moto",
                this.soccoristasAuto.size(),
                this.soccoristasMoto.size());
    }

    public void simAccidente() {
        int accidentadoIndice = randomizer.nextInt(this.corredores.size());
        Vehiculo accidentado = this.corredores.get(accidentadoIndice);
        if (accidentado.isType(NombreVehiculo.AUTO))
            this.soccoristasAuto.get(0).socorrer(accidentado);
        else
            this.soccoristasMoto.get(0).socorrer(accidentado);
    }

    public void agregarSocorristaAuto(SocorristaAuto toAdd) {
        this.soccoristasAuto.add(toAdd);
    }

    public void agregarSocorristaAutoAll(SocorristaAuto... toadd) {
        this.soccoristasAuto.addAll(Arrays.asList(toadd));
    }

    public void agregarSocorristaMoto(SocorristaMoto toAdd) {
        this.soccoristasMoto.add(toAdd);
    }

    public void agregarSocorristaMotoAll(SocorristaMoto... toadd) {
        this.soccoristasMoto.addAll(Arrays.asList(toadd));
    }

    public void agregarVehiculo(Vehiculo toAdd) {
        this.corredores.add(toAdd);
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        this.corredores.remove(vehiculo);
    }

}
