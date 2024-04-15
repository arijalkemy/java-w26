public interface CRUD <T>{
    public void agregar(T objeto);
    public void eliminar(double id);
    public void modificar(double id);
    public void consultar(double id);

}
