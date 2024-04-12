package com.example.ejercicioDos.DocumentTypes;

import com.example.ejercicioDos.Interfaces.IPrint;

public class Report implements IPrint<Report>{

    private String text;
    private int numOfPages;
    private String author;
    private String reviewer;

    public Report(String text, int numOfPages, String author, String reviewer){
        this.text = text;
        this.numOfPages = numOfPages;
        this.author = author;
        this.reviewer = reviewer;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public void print(Report report){
        System.out.println("--------------------" + "\n" +
                            "Texto: " + report.getText() + "\n" +
                            "Autor: " + report.getAuthor() + "\n" +
                            "Revisor: " + report.getNumOfPages() + "\n" +
                            "Número de páginas: " + report.getNumOfPages()  );   
    }

}
