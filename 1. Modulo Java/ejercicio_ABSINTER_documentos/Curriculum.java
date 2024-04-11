public class Curriculum implements Imprimible {
    private String nombre;
    private int edad;
    private String habilidades;

    public Curriculum(String nombre, int edad, String habilidades) {
        this.nombre = nombre;
        this.edad = edad;
        this.habilidades = habilidades;
    }


    @Override
    public void imprimir() {
        System.out.println("Curriculum:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Habilidades: " + habilidades);
    }
}
