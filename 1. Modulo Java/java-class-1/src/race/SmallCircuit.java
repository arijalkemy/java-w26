package race;

public class SmallCircuit extends Category {
    public SmallCircuit() {
        super(" 2 km por selva y arroyos.");
    }

    @Override
    public int calculateCost(int age) {
        if (age < 18) {
            return 1300;
        } else {
            return 1500;
        }
    }

    @Override
    public void addParticipant(Participant participant) {
        this.participants.add(participant);
    }
}
