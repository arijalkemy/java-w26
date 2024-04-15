import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Curriculum implements IPrintable {
    private List<String> habilities;
    private Person person;

    public Curriculum(Person person, String... habilities) {
        this.person = person;
        this.habilities = Arrays.asList(habilities);
    }

    @Override
    public String toString() {
        return this.person + " [Habilities] " + String.join(", ", habilities);
    }
}
