package com.example.ejercicio_recapitulando_spring_p2_vivo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Link {
    @JsonIgnore
    private Integer linkId;
    private String link;
    private String password;
    @JsonIgnore
    private int count;

    public Link() {}

    public Link(Integer linkId, String link, String password, int count) {
        this.linkId = linkId;
        this.link = link;
        this.password = password;
        this.count = count;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Link{" +
            "linkId=" + linkId +
            ", link='" + link + '\'' +
            ", password='" + password + '\'' +
            ", count=" + count +
            '}';
    }
}
