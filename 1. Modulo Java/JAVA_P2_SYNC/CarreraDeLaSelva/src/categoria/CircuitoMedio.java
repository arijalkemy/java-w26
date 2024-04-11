package categoria;
public class CircuitoMedio implements Categoria{

    @Override
    public boolean desinscribir(int dni) {
        return false;
    }

    @Override
    public int getMonto(int edad) {
        if (edad < 18 ) {
            return 2000;
        } else {
            return 2300;
        }
    }

}
