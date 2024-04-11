public class Pdf implements Printer {
    int pages;
    String author;
    String title;
    String genre;

    public Pdf(int pages, String author, String title, String genre) {
        this.pages = pages;
        this.author = author;
        this.title = title;
        this.genre = genre;
    }

    @Override
    public void print() {
        System.out.println("Numero de paginas: " + pages);
        System.out.println("Autor: " + author);
        System.out.println("Titulo: " + title);
        System.out.println("Genero: " + genre);
    }
}
