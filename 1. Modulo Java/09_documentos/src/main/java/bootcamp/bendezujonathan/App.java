package bootcamp.bendezujonathan;

import java.util.List;
import java.util.stream.IntStream;

import bootcamp.bendezujonathan.imprimible.Impresora;
import bootcamp.bendezujonathan.imprimible.Imprimible;
import bootcamp.bendezujonathan.imprimible.document.Curriculum;
import bootcamp.bendezujonathan.imprimible.document.Informe;
import bootcamp.bendezujonathan.imprimible.document.Pdf;
import bootcamp.bendezujonathan.person.*;

public class App {
    public static void main(String[] args) {

        Imprimible pdf = setUpPdf();
        Imprimible cv = setUpCv();
        Imprimible informe = setUpInforme();

        Impresora.imprimirDocumento(pdf);
        System.out.printf("%n%n%n");
        Impresora.imprimirDocumento(cv);
        System.out.printf("%n%n%n");
        Impresora.imprimirDocumento(informe);
    }

    private static Imprimible setUpPdf() {
        return new Pdf("PDF BOOTCAMP.pdf", "MeLi and Alkemy", "Academic",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut ac turpis dignissim, bibendum erat id, commodo dolor. Vivamus id urna a quam rutrum rhoncus et quis nibh. Praesent rhoncus ligula eget mauris scelerisque feugiat. Nam lobortis lobortis fringilla",
                1,
                "~/pdf.bootcamp");
    }

    private static Imprimible setUpCv() {
        Person owner = new Person("Leonel", "Bendezu");
        List<Skill> skills = IntStream.range(0, 11)
                .mapToObj(i -> new Skill((i % 2 == 0) ? SkillType.SOFT : SkillType.HARD, "Una skill " + i)).toList();
        return new Curriculum(owner, skills, "~/leo.cv");
    }

    private static Imprimible setUpInforme() {
        return new Informe("Alkemy", "MeLi",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut ac turpis dignissim, bibendum erat id, commodo dolor. Vivamus id urna a quam rutrum rhoncus et quis nibh. Praesent rhoncus ligula eget mauris scelerisque feugiat. Nam lobortis lobortis fringilla",
                1,
                "~/notasBootcamp.md");
    }
}
