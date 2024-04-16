package race;

import java.util.ArrayList;
import java.util.List;

public class Race {
    List<Category> categoryList = new ArrayList<>();
    List<Inscription> inscriptionList = new ArrayList<>();

    public static void main(String[] args) {
        Category smallCircuit = new SmallCircuit();
    }

    private static void registerParticipant(
        int participantId,
        int dni,
        String fullName,
        int age,
        int emergencyNumber,
        String bloodType
    ) {
        // create and add participant to participant list circuit
        // create and add inscription to inscriptions list on this race object
    }
}
