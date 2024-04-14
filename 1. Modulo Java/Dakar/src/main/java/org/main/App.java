package org.main;

import org.entities.*;
import org.interfaces.ISocorrista;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Creación de Socorristas
        ISocorrista socorristaMoto = new SocorristaMoto();
        ISocorrista socorristaAuto = new SocorristaAuto();


        //Carrera de Autos
        Vehiculo autoUno = new Auto(300,50,45,"ATD345");
        Vehiculo autoDos = new Auto(200,70,40,"ATS355");
        Vehiculo autoTres = new Auto(100,20,34,"ABN267");
        Vehiculo autoCuatro = new Auto(400,30,45,"ALS980");
        Vehiculo autoCinco = new Auto(145,100,90,"PPO098");
        Vehiculo autoSeis = new Auto(240,45,70,"OPL765");
        Vehiculo autoSiete = new Auto(190,90,45,"UIL645");
        List<Vehiculo> autos = new ArrayList<>();
        autos.add(autoUno);
        autos.add(autoDos);
        autos.add(autoTres);
        autos.add(autoCuatro);
        autos.add(autoCinco);
        autos.add(autoSeis);
        autos.add(autoSiete);
        Carrera carreraAutos = new Carrera(3000,"Copa Piston", 10,autos,socorristaAuto,socorristaMoto);
        carreraAutos.socorrerAuto("PPO098");
        carreraAutos.eliminarVehiculoConPatente("ABN267");
        carreraAutos.eliminarVehiculo(autoUno);
        carreraAutos.darDeAltaAuto(300,50,45,"HTL756");
        carreraAutos.ganador();

        System.out.println();
        //Motos
        Vehiculo motoUno = new Auto(300,50,45,"AR45");
        Vehiculo motoDos = new Auto(200,70,40,"BT45");
        Vehiculo motoTres = new Auto(100,20,34,"GP42");
        Vehiculo motoCuatro = new Auto(400,30,45,"GL90");
        Vehiculo motoCinco = new Auto(200,100,45,"IO87");
        Vehiculo motoSeis = new Auto(240,45,70,"RT46");
        Vehiculo motoSiete = new Auto(190,90,45,"TY76");
        List<Vehiculo> motos = new ArrayList<>();
        motos.add(motoUno);
        motos.add(motoDos);
        motos.add(motoTres);
        motos.add(motoCuatro);
        motos.add(motoCinco);
        motos.add(motoSeis);
        motos.add(motoSiete);
        Carrera carreraMotos = new Carrera(3000,"Copa Piston", 10,motos,socorristaAuto,socorristaMoto);
        carreraMotos.socorrerMoto("GL90");
        carreraMotos.eliminarVehiculoConPatente("GL90");
        carreraMotos.eliminarVehiculo(motoUno);
        carreraMotos.darDeAltaMoto(300,50,45,"HTL756");
        carreraMotos.ganador();
    }
}
