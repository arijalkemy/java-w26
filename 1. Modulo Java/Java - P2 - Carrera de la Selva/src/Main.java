import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void showFilter(List<Inscription> inscriptions, String nameFilter) {
        inscriptions.stream().filter(i -> i.getCategory().getName().equals(nameFilter)).forEach(i -> {
            System.out.println(i.getId() + " -> " + "Name:" + i.getParticipante().getName());
        });
    }

    public static void main(String[] args) {
        Category chico = new Category(1, "chico", "2 km por selva y arroyos.", true, 1300, 1500);
        Category medio = new Category(2, "medio", "5 km por selva, arroyos y barro", true, 2000, 2300);
        Category avanzada = new Category(3, "avanzado", "10 km selva, arroyos, barro y escalada en piedra", false, 0, 2800);

        Participante p1 = new Participante(1, "1020323", "Juanito", "Perez", 21, "3213465774", "3114565454", "O+");
        Participante p2 = new Participante(2, "1020323", "Diana", "Gomez", 21, "3213465774", "3114565454", "O+");
        Participante p3 = new Participante(3, "1020323", "Daniel", "Gonzalez", 18, "3213465774", "3114565454", "O+");
        Participante p4 = new Participante(4, "1020323", "Camila", "Torres", 18, "3213465774", "3114565454", "O+");

        Inscription i1 = new Inscription(1, chico, p1);
        Inscription i2 = new Inscription(2, medio, p2);
        Inscription i3 = new Inscription(3, avanzada, p3);
        Inscription i4 = new Inscription(4, avanzada, p4);


        List<Inscription> inscriptions = new ArrayList<>();
        inscriptions.add(i1);
        inscriptions.add(i2);
        inscriptions.add(i3);
        inscriptions.add(i4);

        List<Inscription> inscriptionsVerify = new ArrayList<>(inscriptions.stream().filter(i -> {
            if (i.getCategory().getAccept()) {
                return true;
            }
            return i.getParticipante().getAge() >= 18;
        }).toList());

        showFilter(inscriptionsVerify, "avanzado");
        inscriptionsVerify.remove(i4);
        // showFilter(inscriptionsVerify, "chico");
    }
}
