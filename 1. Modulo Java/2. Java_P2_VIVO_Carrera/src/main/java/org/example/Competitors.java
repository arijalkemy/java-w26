package org.example;

public class Competitors {
    private int idCompetitor;
    private String dni;
    private String name;
    private String lastName;
    private int age;
    private String phone;
    private String emergencyPhone;
    private String bloodType;
    
    public Competitors(int idCompetitor, String dni, String name, String lastName, int age, String phone,
            String emergencyPhone, String bloodType) {
        this.idCompetitor = idCompetitor;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.emergencyPhone = emergencyPhone;
        this.bloodType = bloodType;
    }

    public int getIdCompetitor() {
        return idCompetitor;
    }

    public void setIdCompetitor(int idCompetitor) {
        this.idCompetitor = idCompetitor;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    @Override
    public String toString() {
        return "Competitors [idCompetitor=" + idCompetitor + ", dni=" + dni + ", name=" + name + ", lastName="
                + lastName + ", age=" + age + ", phone=" + phone + ", emergencyPhone=" + emergencyPhone + ", bloodType="
                + bloodType + "]";
    }

    
}
