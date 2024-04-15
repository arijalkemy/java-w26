package dakar;

public class Main {
    public static void main(String[] args) {
        Carrera granPremioCOL = new Carrera(50000, 10000.553, "Gran Premio de Colombia",10);
        granPremioCOL.darDeAltaAuto(150,13,60,"Sol-Solecito");
        granPremioCOL.darDeAltaAuto(180,20,60,"Sol-Solecito2");
        granPremioCOL.darDeAltaAuto(128,39,89,"Ferrari");

        System.out.println("Vehículos en la carrera");
        granPremioCOL.listaDeVehiculos.forEach(v-> System.out.println(v.patente + "- Velocidad "+v.velocidad+" Aceleración: "+v.aceleracion));

        //Eliminar
        granPremioCOL.eliminarVehiculoPatente("Ferrari");
        System.out.println("Vehiculo con patente Ferrari ha sido eliminado");

        //Mostrar Vehiculos
        System.out.println("Vehiculos en la carrera post eliminación: ");
        granPremioCOL.listaDeVehiculos.forEach(v-> System.out.println(v.patente + " -Velocidad :"+v.velocidad+" -Aceleración :"+v.aceleracion));

        Vehiculo ganador = granPremioCOL.definirGanador();
        if(ganador != null){
            System.out.println("Ganador: "+ganador.patente);
        }else{
            System.out.println("No hay ganador");
        }

    }
}
