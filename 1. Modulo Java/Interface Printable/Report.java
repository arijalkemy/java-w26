public class Report implements IPrintable {
    private String text;
    private Integer pages;
    private String author;
    private String revisor;

    public Report(String text, Integer pages, String author, String revisor) {
        this.text = text;
        this.pages = pages;
        this.author = author;
        this.revisor = revisor;
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "[Report] text: " + text + ", pages: " + pages + ", author: " + author + ", revisor: " + revisor;
    }
}
