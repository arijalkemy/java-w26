package bootcamp.bendezujonathan.imprimible.document;

public class Pdf extends Document {

    private String tittle;
    private String author;
    private String genre;
    private String content;
    private int numberOfPages;

    public Pdf(String tittle, String author, String genre, String content, int numberOfPages, String path) {
        super(path);
        this.tittle = tittle;
        this.author = author;
        this.genre = genre;
        this.content = content;
        this.numberOfPages = numberOfPages;
    }
    

    @Override
    public void imprimir() {
        this.showType();
        System.out.printf("---------- %s ----------", this.tittle);
        System.out.printf("%n>> Author: %s", this.author);
        System.out.printf("%n>> Genre: %s",this.genre);
        System.out.printf("%n>> Number of pages: %d", this.numberOfPages);
        System.out.printf("%n%s", this.content);
    }

    public String getTittle() {
        return this.tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    

    public int getNumberOfPages() {
        return this.numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }


    
}
