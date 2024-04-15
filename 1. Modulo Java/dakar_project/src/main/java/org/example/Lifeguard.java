package org.example;

public class Lifeguard <T extends Vehicle>{

    public void help(T vehicle) {
        String msg = "Socorriendo vehicle";
        if(vehicle instanceof Motorcycle) {
            msg = "Socorriendo moto";
        } else if(vehicle instanceof Car){
            msg = "Socorriendo auto";
        }
        System.out.println(msg + ": " + vehicle.getPlate());
    }
}
