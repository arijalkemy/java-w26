package org.meli.clases;

public class SocorristaMoto {
    public void socorrer(Vehiculo vehiculo){
        if(vehiculo.getCategoria().equals("Moto")){
            System.out.println("Socorriendo moto con patente: "+vehiculo.getPatente());
        }else{
            System.out.println("El vehiculo no es una moto");
        }
    }
}
