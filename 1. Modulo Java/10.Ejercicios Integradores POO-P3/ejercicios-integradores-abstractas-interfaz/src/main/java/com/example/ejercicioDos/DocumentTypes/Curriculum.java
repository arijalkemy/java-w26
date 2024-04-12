package com.example.ejercicioDos.DocumentTypes;
import java.util.List;

import com.example.ejercicioDos.Interfaces.IPrint;


public class Curriculum implements IPrint<Curriculum> {

    private String name;
    private String contactNumber;
    private String profession;
    private List<String> capabilities;

    public Curriculum(String name, String contactNumber, String profession, List<String> capabilities){
        this.name = name;
        this.contactNumber = contactNumber;
        this.profession = profession;
        this.capabilities = capabilities;
    };

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public String getContactNumber() {
        return contactNumber;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getProfession() {
        return profession;
    }

    public void setCapabilities(List<String> capabilities) {
        this.capabilities = capabilities;
    }

    public List<String> getCapabilities() {
        return capabilities;
    }

    @Override
    public void print(Curriculum curriculum){
        List<String> capabilities = curriculum.getCapabilities();
        String aux = ""; 

        for (int i = 0; i < capabilities.size(); i++) {
            aux = aux + "\n" + capabilities.get(i);
        }

        System.out.println("---------------------------" + "\n" +
                           "Nombre: " + curriculum.getName() + "\n" +
                           "Contacto: " + curriculum.getContactNumber() + "\n" +
                           "Profesión: " + curriculum.getProfession() + "\n" +
                           "Habilidades: " + "\n" + 
                           aux);
        
    }

}
