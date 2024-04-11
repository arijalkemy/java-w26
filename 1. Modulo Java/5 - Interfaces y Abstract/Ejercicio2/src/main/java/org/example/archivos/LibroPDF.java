package org.example.archivos;

public class LibroPDF {
    int cant_paginas;
    String autor;
    String titulo;
    String genero;

    public LibroPDF(int cant_paginas, String autor, String titulo, String genero) {
        this.cant_paginas = cant_paginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public int getCant_paginas() {
        return cant_paginas;
    }

    public void setCant_paginas(int cant_paginas) {
        this.cant_paginas = cant_paginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "LibroPDF{" +
                "cant_paginas=" + cant_paginas +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
