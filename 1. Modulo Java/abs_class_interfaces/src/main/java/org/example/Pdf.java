package org.example;

public class Pdf implements IPrintDoc {
    final int totalPages = 10;
    final String author = "Carlos";
    final String title = "La odisea";
    final String genre = "Terror";

    public Pdf() {
    }

    @Override
    public String printDoc() {
        return "Paginas: "+this.totalPages+" | autor:"+this.author+" | titulo:"+this.title+" | genero: "+this.genre;
    }
}
