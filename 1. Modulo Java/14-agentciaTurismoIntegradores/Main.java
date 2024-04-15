public class Main {
    public static void main(String[] args){
        //se instancia repositorio de localizadores
        RepositorioLocalizador repoLocalizadores = new RepositorioLocalizador();

        //se instancia un cliente
        Cliente cliente1 = new Cliente("Andres", "Garcia", 1234);

        //se instancia un localizador de reservas
        Localizador reserva1 = new Localizador();
        //se realizan las reservas pedidas por el ejercicio
        reserva1.reservar();
        Localizador reserva2 = new Localizador();
        reserva2.reservar();
        Localizador reserva3 = new Localizador();
        reserva3.reservar();


        //se agrega reserva a cliente1 y a repositoriolocalizador
        cliente1.agregarLocalizador(reserva1, reserva2, reserva3);
        repoLocalizadores.agregarLocalizador(reserva1, reserva2, reserva3);

        System.out.println(cliente1.getTotalCliente());
    }
}
