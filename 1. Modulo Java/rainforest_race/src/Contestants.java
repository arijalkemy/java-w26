public class Contestants {
    // AKA the contestant number
    private int contestantId;
    private long dni;
    private String name;
    private String lastname;
    private int age;
    private String cellphoneNumber;
    private String emergencyNumber;
    private char bloodGroup;

    public Contestants(int contestantId, long dni, String name, String lastname, int age, String cellphoneNumber, String emergencyNumber, char bloodGroup) {
        this.contestantId = contestantId;
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.cellphoneNumber = cellphoneNumber;
        this.emergencyNumber = emergencyNumber;
        this.bloodGroup = bloodGroup;
    }

    public int getContestantId() {
        return contestantId;
    }

    public void setContestantId(int contestantId) {
        this.contestantId = contestantId;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
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

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    public String getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setEmergencyNumber(String emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    public char getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(char bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getUserStrData() {
        return "Nombre: "+this.name+" "+this.lastname+" | Edad: "+this.age+" | DNI: "+this.dni+" | Tipo sangre:"+this.bloodGroup;
    }
}
