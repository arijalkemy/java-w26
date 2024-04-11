package org.example;

public class Inform implements IDocument {
    private String author;
    private String revisor;
    private String text;
    private int numberPages;

    public Inform(String author, String revisor, String text, int numberPages) {
        this.author = author;
        this.revisor = revisor;
        this.text = text;
        this.numberPages = numberPages;
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Inform{" +
                "author='" + author + '\'' +
                ", revisor='" + revisor + '\'' +
                ", text='" + text + '\'' +
                ", numberPages=" + numberPages +
                '}';
    }
}
