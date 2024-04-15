package modelo;

public class Escala {

    private Aeropuerto aeropuertoInicio;
    private Aeropuerto aeropuertoLlegada;
    private double duracionEnHs;
    private Escala siguienteEscala = null;

    public Escala(Aeropuerto aeropuertoInicio, Aeropuerto aeropuertoLlegada, double duracionEnHs, Escala siguienteEscala) {
        this.aeropuertoInicio = aeropuertoInicio;
        this.aeropuertoLlegada = aeropuertoLlegada;
        this.duracionEnHs = duracionEnHs;
        this.siguienteEscala = siguienteEscala;
    }

    public Aeropuerto getAeropuertoInicio() {
        return aeropuertoInicio;
    }

    public void setAeropuertoInicio(Aeropuerto aeropuertoInicio) {
        this.aeropuertoInicio = aeropuertoInicio;
    }

    public Aeropuerto getAeropuertoLlegada() {
        return aeropuertoLlegada;
    }

    public void setAeropuertoLlegada(Aeropuerto aeropuertoLlegada) {
        this.aeropuertoLlegada = aeropuertoLlegada;
    }

    public double getDuracionEnHs() {
        return duracionEnHs;
    }

    public void setDuracionEnHs(double duracionEnHs) {
        this.duracionEnHs = duracionEnHs;
    }

    public Escala getSiguienteEscala() {
        return siguienteEscala;
    }

    public void setSiguienteEscala(Escala siguienteEscala) {
        this.siguienteEscala = siguienteEscala;
    }
}
