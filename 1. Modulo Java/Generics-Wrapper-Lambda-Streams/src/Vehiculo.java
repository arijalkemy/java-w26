public class Vehiculo {
    String modelo;
    String marca;
    Integer costo;

    @Override
    public String toString() {
        return "Vehiculo{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", costo=" + costo +
                '}';
    }

    public boolean esMenorQueMil(){
        if(costo < 1000){
            return true;
        }else return false;
    }

    public boolean esMayorQueMil(){
        if(costo > 1000){
            return true;
        }else return false;
    }
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public Vehiculo(String modelo, String marca, Integer costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }
}
