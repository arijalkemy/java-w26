public class Report implements Printer {
    String text;
    int pages;
    String author;
    String title;
    String genre;

    public Report(String text, int pages, String author, String title, String genre) {
        this.text = text;
        this.pages = pages;
        this.author = author;
        this.title = title;
        this.genre = genre;
    }

    @Override
    public void print() {
        System.out.println("Texto: " + text);
        System.out.println("Numero de paginas: " + pages);
        System.out.println("Autor: " + author);
        System.out.println("Titulo: " + title);
        System.out.println("Genero: " + genre);
    }
}
