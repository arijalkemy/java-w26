public class Player {

    private String id;
    private String dni;
    private String name;
    private String lastName;
    private int age;
    private String cellphone;
    private String auxCellphone;
    private String bloodType;

    public Player() {

    }

    public Player(String id, String dni, String name, String lastName, int age, String cellphone, String auxCellphone,
            String blooType) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.cellphone = cellphone;
        this.auxCellphone = auxCellphone;
        this.bloodType = blooType;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAuxCellphone(String auxCellphone) {
        this.auxCellphone = auxCellphone;
    }

    public String getAuxCellphone() {
        return auxCellphone;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
