package categoria;

public class CircuitoAvanzado implements Categoria {

    @Override
    public boolean desinscribir(int dni) {
        return false;
    }

    @Override
    public int getMonto(int edad) {
        if (edad < 18) {
            return -1;
        } else {
            return 2800;
        }
    }

}
