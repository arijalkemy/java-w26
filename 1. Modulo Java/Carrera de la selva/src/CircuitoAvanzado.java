public class CircuitoAvanzado extends Categoria{
    public CircuitoAvanzado(int id) {
        super(id);
        this.setMinimaEdadRequerida(18);
        this.setNombre("CircuitoAvanzado");
        this.setDescripcion("10 km por selva, arroyos, barro y escalada en piedra.");
    }
}
