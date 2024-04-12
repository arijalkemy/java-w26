package org.bootcamp;


import org.bootcamp.domain.CV;
import org.bootcamp.domain.Informe;
import org.bootcamp.domain.LibroPDF;
import org.bootcamp.service.Imprimible;
import org.bootcamp.service.impl.CVImpresion;
import org.bootcamp.service.impl.InformeImpresion;
import org.bootcamp.service.impl.LibroPDFImpresion;

import java.util.Arrays;

/**
 * @author jsanchezpimi
 */
public class App
{
    public static void main(String[] args) {
        // Instancia de los documentos a imprimir
        LibroPDF libroPDF = new LibroPDF(200, "Tio Bob", "Codigo Limpio", "Tecnología");
        Informe informe = new Informe("Este es un informe en Java con Generics.", 100,
                "Camilo García", "Editorial MELI");
        CV curriculum = new CV(123, "Brayan", "Saenz", Arrays.asList("Respectuoso", "Habilidoso", "Responsable"));

        // Instancia de los servicios de imprimible
        Imprimible<CV> cvImpresion = new CVImpresion();
        Imprimible<LibroPDF> libroPDFImpresion = new LibroPDFImpresion();
        Imprimible<Informe> informeImpresion= new InformeImpresion();

        // Se envia a imprimir los documentos
        imprimir(cvImpresion, curriculum);
        imprimir(libroPDFImpresion, libroPDF);
        imprimir(informeImpresion, informe);

        // Se valida si se puede imprimir un documento vacio
        CV informeVacio = null;
        imprimir(cvImpresion, informeVacio);
    }

    /**
     * Metodo generico para realizar el proceso de impresion de los documentos
     * @param imprimible interfaz de impresion
     * @param documento a imprimir
     * @param <T> del tipo generico de documento
     */
    private static <T> void imprimir(Imprimible<T> imprimible, T documento) {
        if (documento == null) {
            System.out.println("\n\n¡El documento está vacío!");
        } else {
            imprimible.imprimir(documento);
        }
    }
}
