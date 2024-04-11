package categoria;
public class CircuitoChico implements Categoria {
    public CircuitoChico()
    {

    }

    @Override
    public int getMonto(int edad) {
        
        if (edad < 18) {
            return 1300;
        } else {
            return 1500;
        }
    }

    @Override
    public boolean desinscribir(int dni) {
        throw new UnsupportedOperationException("Unimplemented method 'desinscribir'");
    }
}