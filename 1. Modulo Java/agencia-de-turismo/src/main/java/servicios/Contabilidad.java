package servicios;

import Interfaces.ILocalizador;
import repositorios.RepositorioCliente;

import java.util.List;

public class Contabilidad {
    private RepositorioCliente repositorioCliente;

    public Contabilidad(){
        this.repositorioCliente = RepositorioCliente.obtenerInstancia();
        System.out.println(repositorioCliente.obtenerTodosLosClientes());
    }


    public int obtenerCantidadLocalizadoresVendidos(){
        return repositorioCliente.obtenerTodosLosClientes().stream().mapToInt(c -> c.getLocalizadorList().size()).sum();
    }

    public int obtenerCantidadDeReservas(){
        return repositorioCliente.obtenerTodosLosClientes().stream()
                .mapToInt(c -> c.getLocalizadorList().stream().mapToInt(l -> l.getReservaList().size()).sum()).sum();
    }

    public double totalDeVentas(){
        List<ILocalizador> localizadores = repositorioCliente.obtenerTodosLosClientes().stream()
                .flatMap(c-> c.getLocalizadorList().stream()).toList();
        return localizadores.stream().mapToDouble(l -> l.getTotal()).sum();
    }

    public double promedioTotalDeVentas(){
        return this.totalDeVentas()/this.obtenerCantidadLocalizadoresVendidos();
    }

}
