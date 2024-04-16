package race;

public class Participant {
    int participantId;
    int dni;
    String fullName;
    int age;
    int emergencyNumber;
    String bloodType;

    public Participant(int participantId, int dni, String fullName, int age, int emergencyNumber, String bloodType) {
        this.participantId = participantId;
        this.dni = dni;
        this.fullName = fullName;
        this.age = age;
        this.emergencyNumber = emergencyNumber;
        this.bloodType = bloodType;
    }
}
