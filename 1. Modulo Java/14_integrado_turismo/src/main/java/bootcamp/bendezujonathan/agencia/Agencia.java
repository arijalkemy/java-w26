package bootcamp.bendezujonathan.agencia;

import java.util.List;

import bootcamp.bendezujonathan.cliente.Cliente;
import bootcamp.bendezujonathan.localizador.Localizador;
import bootcamp.bendezujonathan.localizador.Reserva;
import bootcamp.bendezujonathan.repositorios.RepositorioCliente;

public class Agencia {
    private Integer id;
    private String nombre;
    private double discountForFidelity;
    private int fidelityBase;

    private List<Localizador> localizadores;

    public Agencia(Integer id, String nombre, List<Localizador> localizadores, double discountForFidelity, int fidelityBase) {
        this.id = id;
        this.nombre = nombre;
        this.localizadores = localizadores;
        this.discountForFidelity = discountForFidelity;
        this.fidelityBase = fidelityBase;
    }

    public Localizador agregarLocalizador(Cliente client, List<Reserva> reservas) {

        if (!RepositorioCliente.exist(client.getId())) {
            RepositorioCliente.add(client);
        }

        client.aplicaADescuento(alMenosReservasPrevias(client.getId(), fidelityBase));
        Localizador nuevo = new Localizador(1, client, reservas);
        nuevo.applyDiscounts(discountForFidelity);
        this.localizadores.add(nuevo);
        return nuevo;

    }

    public boolean alMenosReservasPrevias(int clienteId, int cantidad) {
        return this.localizadores
                .stream()
                .filter(localizador -> localizador.getId() == clienteId)
                .count() >= cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

}
