package modelo;

public class Pasajero {
    private Persona persona;
    private int nroAsiento;
    private Vuelo vuelo;

    public Pasajero(Persona persona, int nroAsiento, Vuelo vuelo) {
        this.persona = persona;
        this.nroAsiento = nroAsiento;
        this.vuelo = vuelo;
    }
}
