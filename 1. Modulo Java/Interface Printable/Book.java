public class Book implements IPrintable {
    private Integer pages;
    private String name;
    private String author;
    private String gender;

    public Book(Integer pages, String name, String author, String gender) {
        this.pages = pages;
        this.name = name;
        this.author = author;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "[BOOK] pages: " + pages + ", name: " + name + ", author: " + author + ", gender: " + gender;
    }
}
