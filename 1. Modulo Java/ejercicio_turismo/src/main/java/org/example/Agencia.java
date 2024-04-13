package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Agencia {

    private HashMap<Cliente, List<Repositorio>> clientesYRepositorios;

    private HashMap<TipoReserva, List<Reserva>> diccionarioPorTipoReserva;

    private double totalVentas;


    public Agencia() {
        this.clientesYRepositorios = new HashMap<Cliente, List<Repositorio>>();
        this.diccionarioPorTipoReserva = new HashMap<TipoReserva, List<Reserva>>();
        this.diccionarioPorTipoReserva.put(TipoReserva.HOT, new ArrayList<>());
        this.diccionarioPorTipoReserva.put(TipoReserva.BOL, new ArrayList<>());
        this.diccionarioPorTipoReserva.put(TipoReserva.TRANS, new ArrayList<>());
        this.diccionarioPorTipoReserva.put(TipoReserva.COM, new ArrayList<>());
        this.totalVentas = 0;
    }

    public Agencia(HashMap<Cliente, List<Repositorio>> clientesYRepositorios) {
        this.clientesYRepositorios = clientesYRepositorios;
        this.clientesYRepositorios.forEach((k,v) -> {
            this.totalVentas = this.getTotalCliente(k);
        });
        this.diccionarioPorTipoReserva = new HashMap<TipoReserva, List<Reserva>>();
        this.diccionarioPorTipoReserva.put(TipoReserva.HOT, new ArrayList<>());
        this.diccionarioPorTipoReserva.put(TipoReserva.BOL, new ArrayList<>());
        this.diccionarioPorTipoReserva.put(TipoReserva.TRANS, new ArrayList<>());
        this.diccionarioPorTipoReserva.put(TipoReserva.COM, new ArrayList<>());
        clientesYRepositorios.forEach((k,repositorios) -> {
            repositorios.forEach( repo -> {
                this.agregarRepositorioAClasificacion(repo);
            });
        });
    }


    /*
    * Mostramos todos las reservas por tipo de reserva
     */
    public String mostrarReservasPorTipo(){
        String hotel = "<---- Hotel ---->\n" + this.diccionarioPorTipoReserva.get(TipoReserva.HOT).stream().map(Object::toString).collect(Collectors.joining());
        String comida = "<---- Comida ---->\n" + this.diccionarioPorTipoReserva.get(TipoReserva.COM).stream().map(Object::toString).collect(Collectors.joining());
        String boletos = "<---- Boletos de viaje ---->\n" + this.diccionarioPorTipoReserva.get(TipoReserva.BOL).stream().map(Object::toString).collect(Collectors.joining());
        String transporte = "<---- Transporte ---->\n" + this.diccionarioPorTipoReserva.get(TipoReserva.TRANS).stream().map(Object::toString).collect(Collectors.joining());
        return hotel + comida + boletos + transporte;
    }

    /*
    * Agregamos las reservas del repositorio a un diccionario dependiendo
    * del tipo de reserva
     */
    public void agregarRepositorioAClasificacion(Repositorio repositorio){
        for(Reserva reserva: repositorio.getLocalizador().getReservas()){
            List<Reserva> aux = this.diccionarioPorTipoReserva.get(reserva.getTipoReserva());
            aux.add(reserva);
            this.diccionarioPorTipoReserva.replace(reserva.getTipoReserva(),aux);
        }
    }

    /*
    * Agregamos un cliente con sus repositorios
     */
    public void agregarCliente(Cliente cliente, List<Repositorio> repositorio){
        for(Repositorio repo: repositorio){
            this.agregarRepositorioAClasificacion(repo);
            System.out.println(repo);
        }
        this.clientesYRepositorios.put(cliente, repositorio);
        this.totalVentas += this.getTotalCliente(cliente);
    }

    /*
    * Agregamos solo el cliente
     */
    public void agregarCliente(Cliente cliente){
        this.clientesYRepositorios.put(cliente, new ArrayList<>());
    }

    /*
    *
    * Agregamos repositorio a la lista de clientes
     */
    public void agregarRepositorio(Cliente cliente, Repositorio repositorio) {
        if(existeCliente(cliente)) {
            if(descuento5(cliente)){
                double precio = repositorio.getLocalizador().getTotal();
                repositorio.getLocalizador().setTotal(precio-precio*.05);
            }
            this.agregarRepositorioAClasificacion(repositorio);
            this.totalVentas += repositorio.getLocalizador().getTotal();
            List<Repositorio> aux = this.clientesYRepositorios.get(cliente);
            aux.add(repositorio);
            System.out.println(repositorio);
            this.clientesYRepositorios.replace(cliente, aux);
        }
    }

    public HashMap<Cliente, List<Repositorio>> getClientesYRepositorios() {
        return clientesYRepositorios;
    }

    public void setClientesYRepositorios(HashMap<Cliente, List<Repositorio>> clientesYRepositorios) {
        this.clientesYRepositorios = clientesYRepositorios;
    }

    public double getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(double totalVentas) {
        this.totalVentas = totalVentas;
    }

    public HashMap<TipoReserva, List<Reserva>> getDiccionarioPorTipoReserva() {
        return diccionarioPorTipoReserva;
    }

    public void setDiccionarioPorTipoReserva(HashMap<TipoReserva, List<Reserva>> diccionarioPorTipoReserva) {
        this.diccionarioPorTipoReserva = diccionarioPorTipoReserva;
    }

    /*
    * Funcion que nos regresa el promedio de las ventas totales / el numero de localizadores
     */
    public double promedioDeVentas(){
        return this.totalVentas/this.numeroDeLocalizadores();
    }

    /*
    * Nos muestra los numeros de localizadores
     */
    public int numeroDeLocalizadores(){
        int aux = 0;
        for(Map.Entry<Cliente, List<Repositorio>> entry: this.clientesYRepositorios.entrySet()){
            aux += entry.getValue().size();
        }
        return aux;
    }

    /*
    * Nos muestra el numero de Reservas
     */
    public int numeroDeReservas(){
        int aux = 0;
        for(Map.Entry<Cliente, List<Repositorio>> entry: this.clientesYRepositorios.entrySet()){
            for(Repositorio repo: entry.getValue()){
                aux += repo.getLocalizador().getReservas().size();
            }
        }
        return aux;
    }

    /*
    * Nos dice si un cliente existe en el diccionario
     */
    private boolean existeCliente(Cliente cliente){
        return this.clientesYRepositorios.containsKey(cliente);
    }

    /*
    * Nos dice si se genera el 5% de descuento cuando haya mas de dos localizadores
     */
    public boolean descuento5(Cliente cliente){
        if(!this.existeCliente(cliente))
            return false;
        if(this.getLocalizadoresCliente(cliente).size() >= 2)
            return true;
        return false;
    }



    /*
    * Nos regresa la lista de los localizadores de un cliente
     */
    public List<Repositorio> getLocalizadoresCliente(Cliente cliente){
        if(existeCliente(cliente)){
            return this.clientesYRepositorios.get(cliente);
        }
        return null;
    }

    /*
    * Nos devuelve el total con referencia a un cliente
     */
    public double getTotalCliente(Cliente cliente){
        return this.clientesYRepositorios.get(cliente).stream().mapToDouble(repo -> repo.getLocalizador().getTotal()).sum();
    }

    /*
    * Transforma los localizadores en string
     */
    public String getLocalizadoresToString(Cliente cliente){
        String aux = "";
        for(Repositorio repo : this.clientesYRepositorios.get(cliente)){
            aux += repo.listadoReservas() + "\n";
        }
        return "<---- Cliente ---->\n" +
                "Nombre: " + cliente.getNombre() + "\n" +
                "Apellido: " + cliente.getApellido() + "\n" +
                "<---- Repositorios ---->\n" +
                aux +
                "<---- Total por cliente ---->\n" +
                getTotalCliente(cliente);
    }
}
