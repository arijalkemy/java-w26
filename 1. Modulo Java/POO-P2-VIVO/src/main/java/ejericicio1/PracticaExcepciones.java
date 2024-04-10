package ejericicio1;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public void calcularCociente(){
        try{
            System.out.println(b/a);
        } catch (Exception e){
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    public void calcularCocienteVariante2(){
        try{
            System.out.println(b/a);
        } catch (Exception e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
