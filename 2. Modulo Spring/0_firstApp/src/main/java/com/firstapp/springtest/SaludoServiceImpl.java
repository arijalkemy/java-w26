package com.firstapp.springtest;

public class SaludoServiceImpl implements  ISaludoService{
    @Override
    public String saludar(String nombre){
        return "Hola " +  nombre ;
    }
}
