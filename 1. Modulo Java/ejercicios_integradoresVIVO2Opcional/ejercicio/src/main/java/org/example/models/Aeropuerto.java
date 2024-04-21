package org.example;

public class Aeropuerto {

    private Ciudad localizacion;

    public Aeropuerto(Ciudad localizacion) {
        this.localizacion = localizacion;
    }

    public Ciudad getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Ciudad localizacion) {
        this.localizacion = localizacion;
    }

}
