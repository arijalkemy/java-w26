public class Ejercicio3 {
        
    String marca;
    String color;
    double kilometros;

    public Ejercicio3(String marca, String color, double kilometros) {
            this.marca = marca;
            this.color = color;
            this.kilometros = kilometros;
    }

    public static void main(String[] args) {
        
        Ejercicio3 auto = new Ejercicio3("Toyota", "gris", 1000);
        
        String marcaYColor = ("La marca del auto es: " + auto.marca + ". El color del auto es: " + auto.color);
        
        System.out.println(marcaYColor + "");
    }
}