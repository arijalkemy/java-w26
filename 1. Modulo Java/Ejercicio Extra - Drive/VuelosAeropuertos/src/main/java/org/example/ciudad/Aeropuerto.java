package org.example.ciudad;

public class Aeropuerto {
    private Ciudad ciudad;

    public Aeropuerto(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
}
