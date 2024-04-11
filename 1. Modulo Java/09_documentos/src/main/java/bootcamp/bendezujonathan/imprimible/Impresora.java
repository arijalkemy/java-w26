package bootcamp.bendezujonathan.imprimible;

public interface Impresora {
    
    static void imprimirDocumento(Imprimible document) {
        document.imprimir();
    }
}
