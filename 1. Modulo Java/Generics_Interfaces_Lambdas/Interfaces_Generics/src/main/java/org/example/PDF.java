package org.example;

public class PDF implements IDocument{
    private String title;
    private String author;
    private String genre;
    private int numberPages;

    public PDF(String title, String author, String genre, int numberPages) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.numberPages = numberPages;
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "PDF{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", numberPages=" + numberPages +
                '}';
    }
}
