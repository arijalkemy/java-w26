import java.util.List;

public class App {
    public static void main(String[] args)  {
        List<Categoria> categorias = setUpCategorias();
        Carrera selva = new Carrera(1, "Carrera De la Selva", categorias);
        List<Participante> participantes = setUpParticipantes();
        selva.inscribir(participantes.get(0), 1);
        selva.inscribir(participantes.get(1), 1);
        selva.inscribir(participantes.get(1), 2);
        selva.inscribir(participantes.get(1), 3);

        selva.inscribir(participantes.get(2), 3);
        selva.inscribir(participantes.get(2), 2);

        selva.desinscribir(participantes.get(1), 2);
        System.out.println(selva);

    }

    private static List<Categoria> setUpCategorias() {
        Categoria chico = new Categoria(1, "chico", "2Km por selva y arroyos", 1300, 1500, -1);
        Categoria medio = new Categoria(2, "medio", "5Km por selva, arroyos y barro", 2000, 2300, -1);
        Categoria avanzado = new Categoria(3, "avanzado", "10Lm por selva, arroyos, barro y escalada en piedra.", 0,2800, 18);
        return List.of(chico, medio, avanzado);
    }

    private static List<Participante> setUpParticipantes() {
        Participante uno = new Participante(1, "1", "Juan", "Perez", 20, "3511111", "32", "-O");
        Participante dos = new Participante(2, "2", "Julian", "Alravez", 18, "33", "33", "A");
        Participante tres = new Participante(3, "3", "Lionel", "Messsi", 17, "333", "33", "B");
        return List.of(uno, dos, tres);
    }

}
