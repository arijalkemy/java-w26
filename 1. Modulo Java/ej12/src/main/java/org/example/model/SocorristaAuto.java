package org.example.model;

import java.util.Optional;

public class SocorristaAuto extends Vehiculo{
    Vehiculo auto;

    public SocorristaAuto(Vehiculo auto) {
        super(auto.getVelocidad(), auto.getAceleracion(), auto.getAnguloDeGiro(), auto.getPatente(), auto.getPeso(), auto.getRuedas());
        this.auto = auto;
    }

    @Override
    public Boolean isSocorrista() {
        super.isSocorrista();
        return true;
    }

    public String socorrer(Optional<Vehiculo> vehiculo){
        String stringRes = "";

        if (vehiculo.isPresent()){
            stringRes = vehiculo.get().patente;
        }
        return "Socorriendo vehículo: "+ stringRes +"\n";
    }

}
