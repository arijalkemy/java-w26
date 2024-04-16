package model;

import java.io.Serializable;
import java.util.List;

public class PersonDTO implements Serializable {
    private String name;
    private String lastName;
    private Integer age;
    private List<SportDTO> listaSports;

    public PersonDTO(String name, String lastName, Integer age,List<SportDTO> listaSports ) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.listaSports = listaSports;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
