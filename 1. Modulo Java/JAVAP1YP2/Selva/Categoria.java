public class Categoria{
    private int id;
    private String nombre;
    private String descripcion;
    public Categoria(int id,String nombre,String descripcion){
        this.id=id;
        this.nombre=nombre;
        this.descripcion=descripcion;
    }

    public void mostrarCategoria(){
        System.out.println("Id:"+id+" Nombre:"+nombre+" Descripcion:"+descripcion);
    }

    public int getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }
}