import java.util.List;

public class Main {
    public static void main(String[] args) {
        Curriculum exampleCv = new Curriculum("CV Bruno", 23, List.of(new String[]{"java", "Springboot"}));
        Pdf examplePdf = new Pdf(600, "Viaje al centro de la tierra", "Julio Verne", "Ciencia Ficcion");
        Report exampleReport = new Report("El libro es excelente", 500, "Julio Verne" , "Viaje al centro de la tierra", "Ciencia Ficcion");
        exampleCv.print();
        examplePdf.print();
        exampleReport.print();
    }
}
