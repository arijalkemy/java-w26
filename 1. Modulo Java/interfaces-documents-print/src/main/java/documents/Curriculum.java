package documents;

import java.util.List;

public class Curriculum implements ArchivoImprimible {
    private String nombreCompleto;
    private List<String> listaDeHabilidades;


    public Curriculum(String nombreCompleto, List<String> listaDeHabilidades) {
        this.nombreCompleto = nombreCompleto;
        this.listaDeHabilidades = listaDeHabilidades;
    }

    public void imprimir() {
        System.out.println(
                "Curriculum{" +
                        "nombreCompleto='" + nombreCompleto + '\'' +
                        ", listaDeHabilidades=" + listaDeHabilidades +
                        '}'
        );
    }
}
