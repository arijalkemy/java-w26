public class Main {
    public static void main(String[] args) {
        Report r = new Report("lorem ipsum", 1, "Edwin", "Santiago");
        r.print();

        Book book = new Book(1200, "biblia", "xd", "religion");
        book.print();

        Curriculum curriculum = new Curriculum(
                new Person("Edwin", "Villarraga", 22),
                "Java",
                "Node",
                "Golang"
        );
        curriculum.print();
    }
}
