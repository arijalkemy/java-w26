public class Participante {
    private int id;
    private String dni;
    private String name;
    private String lastname;
    private int age;
    private String phone;
    private String emergencyContact;
    private String groupBlood;
    public Participante() {
    }

    public Participante(int id, String dni, String name, String lastname, int age, String phone, String emergencyContact, String groupBlood) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.phone = phone;
        this.emergencyContact = emergencyContact;
        this.groupBlood = groupBlood;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getGroupBlood() {
        return groupBlood;
    }

    public void setGroupBlood(String groupBlood) {
        this.groupBlood = groupBlood;
    }
}
