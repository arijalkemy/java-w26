package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


       Imprimir cv = new Curriculum();
       Imprimir pdf= new LibroPDF();
       Imprimir informe= new Informe();

        List<Imprimir> documentos= new ArrayList();
        documentos.add(cv);
        documentos.add(pdf);
        documentos.add(informe);

        for (Imprimir doc:documentos) {
            doc.imprimir();
        }


        documentos.forEach(Imprimir::imprimir);

    }
}