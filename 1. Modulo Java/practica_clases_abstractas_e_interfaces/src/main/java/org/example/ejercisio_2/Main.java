import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<IDocumento> documentos = new ArrayList<IDocumento>(){
            {
                add(new LibroPDF(100, "Stephen Hawiking", "Breve historia del tiempo", "Carl Sagan"));
                add(new Informe("Holaaaaa", 1, "Yo", "Alguien"));
                add(new Curriculum("Tomas", 22, "Masculino", 11666666, "Desarrollador Backend 2 años.", "Licenciatura en Sistemas"));
            }
        };


        for (IDocumento documento : documentos) {
            Impresora.imprimir(documento);
        }
    }
}