package com.example.ejercicio_recapitulando_spring_p2_vivo.dto;

public class LinkDto {
    private Integer linkId;
    private String link;
    private String password;
    private int count;

    public LinkDto() {}

    public LinkDto(Integer linkId, String link, String password, int count) {
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
}
