package org.example;

//clase del objeto Categoria
public class Categoria{//Declaracion de variales del objeto
    private int id;
    private String nombre;
    private String descripcion;
    public Categoria(int id,String nombre,String descripcion){ //constructor del objeto
        this.id=id;
        this.nombre=nombre;
        this.descripcion=descripcion;
    }
    //metodo para imprimir la informacion de una categoria
    public void mostrarCategoria(){
        System.out.println("Id:"+id+" Nombre:"+nombre+" Descripcion:"+descripcion);
    }
    //metodo de getId
    public int getId(){
        return id;
    }
    //metodo de getNombre
    public String getNombre(){
        return nombre;
    }
    //metodo getDescripcion
    public String getDescripcion(){
        return descripcion;
    }
}