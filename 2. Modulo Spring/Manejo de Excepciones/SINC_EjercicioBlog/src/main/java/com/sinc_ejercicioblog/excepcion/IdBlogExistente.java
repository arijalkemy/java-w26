package com.sinc_ejercicioblog.excepcion;

public class IdBlogExistente extends RuntimeException{
    public IdBlogExistente() {
    }
    public IdBlogExistente(String message) {
        super(message);
    }
}
