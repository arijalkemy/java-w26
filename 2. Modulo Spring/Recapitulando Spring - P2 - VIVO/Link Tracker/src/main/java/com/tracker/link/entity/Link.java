package com.tracker.link.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Link {
    private String publicURL;
    private String privateURL;
    private String password;
    private boolean valid;

    public Link(String publicURL, String privateURL, String password, boolean valid) {
        this.publicURL = publicURL;
        this.privateURL = privateURL;
        this.password = password;
        this.valid = valid;
    }

    public String getPublicURL() {
        return publicURL;
    }

    public void setPublicURL(String publicURL) {
        this.publicURL = publicURL;
    }

    public String getPrivateURL() {
        return privateURL;
    }

    public void setPrivateURL(String privateURL) {
        this.privateURL = privateURL;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
