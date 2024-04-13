import java.util.List;

public class Supermercado {
    private String nombre;
    private String cuil;
    private List<Facturas> facturas;


    public Supermercado(String nombre, String cuil, List<Facturas> facturas) {
        this.nombre = nombre;
        this.cuil = cuil;
        this.facturas = facturas;
    }
}
