public class Vehiculo {
    private Integer velocidad;
    private Integer aceleracion;
    private Integer anguloDeGiro;
    private String patente;
    private Integer peso;
    private Integer rueda;

    public Vehiculo(Integer velocidad, Integer aceleracion, Integer anguloDeGiro, Integer peso, Integer rueda, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.rueda = rueda;
    }

    public String getPatente(){
        return this.patente;
    }

    public boolean comparePatente(String compare){
        return this.patente.equals(compare);
    }

    public Double velocidadTotal() {
        return (velocidad * 0.5 * aceleracion) / (anguloDeGiro * (peso - rueda * 100));
    }
}
