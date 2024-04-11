import java.util.Arrays;

public class Imprenta{
    public static void main(String[] args){
        //instancia Curriculums
        Curriculums cv = new Curriculums();
        cv.setNombreApellido("Andres Garcia");
        cv.setDni(40721425);
        cv.setEdad(26);
        cv.setGenero('M');
        cv.setTituloAcademico("Ingeniero");
        cv.setHabilidades(Arrays.asList("Chiflar", "Malabarismo", "Correr"));

        //instancia pdf
        PDF pdf = new PDF();
        pdf.setAutor("Gabriel Rolon");
        pdf.setTitulo("Historias de Divan");
        pdf.setGeneroLibro("Psicoanalisis");
        pdf.setCantidadPaginas(400);

        //instancia informes
        Informes informe = new Informes();
        informe.setAutor("Pablo");
        informe.setCantidadPaginas(10);
        informe.setRevisor("Javier");
        informe.setTexto("Se analiza la productividad del area de produccion 3.");

        Imprimir.imprimirDocumento(cv);
        Imprimir.imprimirDocumento(pdf);
        Imprimir.imprimirDocumento(informe);
    }
}
