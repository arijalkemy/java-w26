public class Participant {
    private int noParticipant;
    private String dni;
    private String name;
    private String lastname;
    private int age;
    private String phone;
    private String emergencyPhone;
    private String bloodGroup;

    public Participant(int noParticipant, String dni, String name, String lastname, int age, String phone, String emergencyPhone, String bloodGroup) {
        this.noParticipant = noParticipant;
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.phone = phone;
        this.emergencyPhone = emergencyPhone;
        this.bloodGroup = bloodGroup;
    }

    public int getNoParticipant() {
        return noParticipant;
    }

    public void setNoParticipant(int noParticipant) {
        this.noParticipant = noParticipant;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
