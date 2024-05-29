package com.w26.movies.demo.entity.CompositeKey;

import java.io.Serializable;
import java.util.Objects;

public class PassWordResetId implements Serializable {
    private String email;
    private String token;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    @Override
    public int hashCode() {
        return Objects.hash(email, token);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || this.getClass() != obj.getClass()) return false;
        PassWordResetId id = (PassWordResetId) obj;

        return Objects.equals(email, id.email) && Objects.equals(token, id.token);
    }


}
