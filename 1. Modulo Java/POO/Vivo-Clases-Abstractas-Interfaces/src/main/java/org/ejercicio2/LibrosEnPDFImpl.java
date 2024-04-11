package org.ejercicio2;

public class LibrosEnPDFImpl implements IDocumento {
    private final Libro libro;

    public Libro getLibro() {
        return libro;
    }

    public LibrosEnPDFImpl(Libro libro) {
        this.libro = libro;
    }

    @Override
    public void imprimir() {
        System.out.println(libro);
    }
}
