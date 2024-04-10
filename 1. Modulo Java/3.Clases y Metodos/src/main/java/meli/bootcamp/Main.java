package meli.bootcamp;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {
    Automovil auto = new Automovil("Ford", "Rojo", 1000);
    System.out.println(auto.mostrarMarcaYColor());
  }
}