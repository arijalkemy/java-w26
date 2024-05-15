public class PracticaExcepciones {
    int a = 0;
    int b = 300;

    public String cociente(){
        int c= 0;
        try {
            c = b/a;
        }
        catch (Exception e){
            System.out.println("Se a producido un error: "+e.getLocalizedMessage());
            c= 0;
        }
        finally {
           return "Programa finalizado";
        }
    }

    public String cocienteIllegal(){
       if(a==0){
           throw new IllegalArgumentException("No se puede dividir entre 0");
       }
       return (""+b/a);
    }
}
