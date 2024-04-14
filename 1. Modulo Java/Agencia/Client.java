package org.example.tourist;

import java.util.List;

public class Client {
    private Integer id;
    private String name;
    private String lastname;
    private boolean discount;

    public Client(Integer id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.discount = false;
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

    public boolean getDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "[Client]" + " id: " + this.id + " name: " + name + " lastname: " + lastname + " discount: " + discount + '\n';
    }
}
