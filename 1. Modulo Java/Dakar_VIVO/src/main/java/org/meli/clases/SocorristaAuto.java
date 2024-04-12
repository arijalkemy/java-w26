package org.meli.clases;

public class SocorristaAuto {
    public void socorrer(Vehiculo vehiculo){
        if(vehiculo.getCategoria().equals("Auto")){
            System.out.println("Socorriendo auto con patente: "+vehiculo.getPatente());
        }else{
            System.out.println("El vehiculo no es un auto");
        }
    }
}
