package org.example;

public class Report implements IPrintDoc{
    final int length = 300;
    final int pages = 2;
    final String author = "Martin";
    final String reviewer = "Molly";

    public Report() {
    }

    @Override
    public String printDoc() {
        return "Longitud: "+this.length+" | paginas: "+this.pages+" | autor: "+this.author+" | revisor: "+this.reviewer;
    }
}
