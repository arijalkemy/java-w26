package meli.bootcamp;

public class PracticaExcepciones {
  private final int a = 0;
  private final int b = 300;

  public void division() {
    try {
      int resultado =  b / a;
    } catch (Exception e) {
      System.out.println("Se ha producido un error: " + e.getMessage());
      throw new IllegalArgumentException("No se puede dividir por cero");
    } finally {
      System.out.println("Programa finalizado");
    }
  }
}
