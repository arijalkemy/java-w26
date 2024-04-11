package bootcamp.bendezujonathan.imprimible.document;

public class Informe extends Document {


    private String author;
    private String reviewer;
    private String content;
    private int numberOfPages;

    public Informe(String author, String reviewer, String content, int numberOfPages, String path) {
        super(path);
        this.author = author;
        this.reviewer = reviewer;
        this.content = content;
        this.numberOfPages = numberOfPages;
    }

    @Override
    public void imprimir() {
        this.showType();
        System.out.println("--------------- Informe --------------- ");
        System.out.printf(">> Author:  %s Reviewer: %s", this.author, this.reviewer);
        System.out.printf("%n>> Number of pages: %d", this.numberOfPages);
        System.out.println(content);
    }
    

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReviewer() {
        return this.reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
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
