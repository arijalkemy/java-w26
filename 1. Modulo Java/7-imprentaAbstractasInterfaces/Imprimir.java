public interface Imprimir <T> {

    //se crea un metodo estatico para que haga la funcion de utilitario
    //segun comprendi del enunciado del ejercicio
    static <T> void imprimirDocumento(T documento){
        System.out.println(documento.toString());
    }
}
