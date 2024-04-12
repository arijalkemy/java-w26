package com.example.ejercicioDos.DocumentTypes;

import com.example.ejercicioDos.Interfaces.IPrint;

public class DocumentPDF implements IPrint<DocumentPDF>{

    private String author;
    private String title;
    private String genre;
    private String numOfPage;

    public DocumentPDF(String author, String title, String genre, String numOfPage){
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.numOfPage = numOfPage;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getNumOfPage() {
        return numOfPage;
    }
    public void setNumOfPage(String numOfPage) {
        this.numOfPage = numOfPage;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void print(DocumentPDF pdf){
        System.out.println("-----------------------------------" + "\n" +
                             "Título:" + pdf.getTitle() + "\n" +
                             "Autor: " + pdf.getAuthor() + "\n" + 
                             "Género: " + pdf.getGenre() + "\n" +
                             "Número de páginas: " + pdf.getNumOfPage());
    }

}
