package org.example.dto_p2_covid.symptoms;

import java.io.Serializable;

public class RiskPersonDTO implements Serializable {
    private String personName;
    private String personLastname;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonLastname() {
        return personLastname;
    }

    public void setPersonLastname(String personLastname) {
        this.personLastname = personLastname;
    }
}
