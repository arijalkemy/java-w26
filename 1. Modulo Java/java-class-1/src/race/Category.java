package race;

import java.util.ArrayList;
import java.util.List;

abstract class Category {
    String description;
    int totalEarnings;
    List<Participant> participants;

    public Category(String categoryDescription) {
        description = categoryDescription;
        totalEarnings = 0;
        List<Participant> participants = new ArrayList<>();
    }

    public abstract int calculateCost(int age);
    public abstract void addParticipant(Participant participant);
}
