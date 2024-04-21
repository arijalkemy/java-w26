package com.sinc_ejercicioblog.excepcion;

public class IdBlogInexistente extends RuntimeException {

    public IdBlogInexistente() {
    }

    public IdBlogInexistente(String message) {
        super(message);
    }
}
