import java.util.List;

public class Main {
    public static void main(String[] args) {
        Carretera carretera = new Carretera(10000,
                5000,
                "Dakar 2024",
                10,
                List.of(
                        new Moto(100, 40, 30, "MO10"),
                        new Moto(130, 70, 31, "MO10"),
                        new Moto(90, 56, 22, "MO10"),
                        new Moto(75, 60, 44, "MO10"),
                        new Moto(50, 30, 56, "MO10"),
                        new Moto(66, 60, 43, "MO10")
                )
        );
        Vehiculo ganador = carretera.getGanador();
        if(ganador != null){
            System.out.println(ganador.getPatente());
        }
    }
}
