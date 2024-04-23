import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Creacion de las variables para el manejo de la competencia y las categorias
        Map<Integer, List<String>> competencia = new HashMap<>();
        List<String> CircuitoChico = new ArrayList<>();
        List<String> CircuitoMedio = new ArrayList<>();
        List<String> CircuitoAvanzado = new ArrayList<>();

        //Carga los datps de cada Categoria de la competencia
        CircuitoChico.add("Circuito chico");
        CircuitoChico.add("2 km por selva y arroyos.");
        CircuitoMedio.add("Circuito medio");
        CircuitoMedio.add("5 km por selva, arroyos y barro.");
        CircuitoAvanzado.add("Circuito avanzado");
        CircuitoAvanzado.add("10 km por selva, arroyos, barro y escalada en piedra.");

        //Se agregan las categorias a la competencia
        competencia.put(1,CircuitoChico);
        competencia.put(2,CircuitoMedio);
        competencia.put(3,CircuitoAvanzado);

        //Creacion de las variables para el manejo de los participantes
        Map<Integer,List<String>> participantes = new HashMap<>();
        List<String> participante1 = new ArrayList<>();
        List<String> participante2 = new ArrayList<>();
        List<String> participante3 = new ArrayList<>();

        //Cargue de datos de cada participante
        participante1.add("101010");
        participante1.add("Pablo");
        participante1.add("perez");
        participante1.add("21");
        participante1.add("5550123");
        participante1.add("6669988");
        participante1.add("o+");

        participante2.add("102210");
        participante2.add("Andres");
        participante2.add("Lopez");
        participante2.add("14");
        participante2.add("5554433");
        participante2.add("6646789");
        participante2.add("o-");

        participante3.add("224510");
        participante3.add("Johan");
        participante3.add("Munoz");
        participante3.add("35");
        participante3.add("5554321");
        participante3.add("7770123");
        participante3.add("a+");

        //Se Crean la agrupacion de los participantes inscritos
        participantes.put(1,participante1);
        participantes.put(2,participante2);
        participantes.put(3,participante3);

        //Se vinculan los participantes a una competencia
        Map<List<String>,List<String>> competenciaParticipantes = new HashMap<>();
        competenciaParticipantes.put(competencia.get(1),participantes.get(1));
        competenciaParticipantes.put(competencia.get(2),participantes.get(2));
        competenciaParticipantes.put(competencia.get(3),participantes.get(3));
    }
}