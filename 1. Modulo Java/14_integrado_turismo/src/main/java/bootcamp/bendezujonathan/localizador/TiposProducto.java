package bootcamp.bendezujonathan.localizador;

import java.util.List;
import java.util.Arrays;

public enum TiposProducto {
    HOTEL,
    COMIDA,
    TRANSPORTE,
    VUELOS;

    public static List<TiposProducto> asList() {
        return Arrays.asList(TiposProducto.values());
    }
}
