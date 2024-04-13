package org.example;

public class Repositorio {

    private Localizador localizador;

    public Repositorio(Localizador localizador) {
        this.localizador = localizador;
    }

    public Localizador getLocalizador() {
        return localizador;
    }

    public void setLocalizador(Localizador localizador) {
        this.localizador = localizador;
    }

    /*
    * Nos devuelve un string con las reservas del repositorio
     */
    public String listadoReservas(){
        String aux = "";
        for(Reserva reserva: localizador.getReservas()){
            aux += "-" + reserva.getTipoReserva() + "; Precio: " + reserva.getPrecio() + "\n";
        }
        return aux;
    }


    @Override
    public String toString(){
        return "Detalles compra\n" +
                "<---- Cliente ---->\n" +
                "Nombre: " + localizador.getCliente().getNombre() + "\n" +
                "Apellido: " + localizador.getCliente().getApellido() + "\n" +
                "<---- Reservas ---->\n" +
                this.listadoReservas() + "\n" +
                "Total: " + localizador.getTotal() + "\n";
    }
}
