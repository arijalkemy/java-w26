package org.example;

public class Categoria {
    private long id;
    private TipoCategoria tipoCategoria;
    private String nombre;
    private String descripcion;

    public Categoria(long id, TipoCategoria tipoCategoria, String nombre, String descripcion) {
        this.id = id;
        this.tipoCategoria = tipoCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoCategoria getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(TipoCategoria tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    public double calcularCostoCategoria(boolean esMayor){
        double costoCategoria=0.0;
        switch (tipoCategoria){
            case CIRCUITOCHICO : if(esMayor==true){
                costoCategoria=1500;
            }else{
                costoCategoria=1300;
            }
            break;
            case CIRCUITOMEDIO: if(esMayor==true){
                costoCategoria=2000;
            }else{
                costoCategoria=2300;
            }
            break;
            case CIRCUITOAVANZADO:
                costoCategoria=2800;

        }
        return costoCategoria;

    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", tipoCategoria=" + tipoCategoria +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
