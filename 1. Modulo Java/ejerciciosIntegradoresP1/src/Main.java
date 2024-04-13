import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("Monica", "234", 3456787);
        Localizador localizador = new Localizador(cliente);
        Comida comida = new Comida(2300, 23, LocalDateTime.now(), "frisby");
        ReservaHotel hotel = new ReservaHotel(3400, 23, "paraiso", LocalDate.of(2024, 8,5), LocalDate.of(2024,8,7));
        BoletosViaje tickets = new BoletosViaje(4500, 23, "wingo", LocalDate.of(2024,8,5), LocalDate.of(2024,8,7));
        Transporte transporte = new Transporte(2800, 23, LocalDate.of(2024,8,5));
        localizador.setListaComidas(List.of(comida));
        localizador.setListaBoletosViajes(List.of(tickets));
        localizador.setListaReservaHoteles(List.of(hotel));
        localizador.setListaTransportes(List.of(transporte));

        aplicarDescuentos(cliente, localizador);


        LocalizadorRepositorio.adicionarLocalizador(localizador);


    }

    private static void aplicarDescuentos(Cliente cliente, Localizador localizador) {
        if( ClienteRepositorio.buscarCliente(cliente.getId()) == null) {
            ClienteRepositorio.adicionarCliente(cliente);
        }

        float porcentaje = 0;
        if(LocalizadorRepositorio.aplicaDescuento(cliente)){
            porcentaje += 5;
        }

        if(!localizador.getListaComidas().isEmpty() && !localizador.getListaBoletosViajes().isEmpty() &&
                !localizador.getListaReservaHoteles().isEmpty() && !localizador.getListaTransportes().isEmpty()){
            porcentaje += 10;
        }

        if(localizador.getListaBoletosViajes().size()>= 2){
            for (BoletosViaje boleto: localizador.getListaBoletosViajes()){
                double descuento = boleto.getValor() * 0.05;
                boleto.setValor(boleto.getValor() - descuento);
            }
        }

        if(localizador.getListaReservaHoteles().size()>=2){
            for(ReservaHotel reserva: localizador.getListaReservaHoteles()){
                double descuento = reserva.getValor() * 0.05;
                reserva.setValor(reserva.getValor() - descuento);
            }
        }

        if(porcentaje > 0){
            for(ReservaHotel reserva: localizador.getListaReservaHoteles()){
                double descuento = reserva.getValor() * porcentaje/100;
                reserva.setValor(reserva.getValor() - descuento);
            }
        }

        if(porcentaje > 0){
            for(BoletosViaje reserva: localizador.getListaBoletosViajes()){
                double descuento = reserva.getValor() * porcentaje/100;
                reserva.setValor(reserva.getValor() - descuento);
            }
        }

        if(porcentaje > 0){
            for(Comida reserva: localizador.getListaComidas()){
                double descuento = reserva.getValor() * porcentaje/100;
                reserva.setValor(reserva.getValor() - descuento);
            }
        }

        if(porcentaje > 0){
            for(Transporte reserva: localizador.getListaTransportes()){
                double descuento = reserva.getValor() * porcentaje/100;
                reserva.setValor(reserva.getValor() - descuento);
            }
        }
    }
}