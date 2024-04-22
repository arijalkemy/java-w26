package race;

public class Inscription {
    int inscriptionNumber;
    Category category;
    Participant participant;
    int inscriptionCost;

    public Inscription(int inscriptionNumber, Category category, Participant participant, int inscriptionCost) {
        this.inscriptionNumber = inscriptionNumber;
        this.category = category;
        this.participant = participant;
        this.inscriptionCost = inscriptionCost;
    }
}
