public class EjemploList {
    private List<String> nombre;


    public Ejemplo()
    {
        this.nombre = new ArrayList<String>();
        this.nombre.add("Juan");
        this.nombre.add("Pedro");

        this.nombre.size();

        for(String nombre : this.nombre)
        {
            System.out.println(nombre);
        }
    }
    public static void main(String[] args) {
        
    }
}