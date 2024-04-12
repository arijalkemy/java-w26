import Documentos.IDocumento;

public interface Imprimible {
    public static void imprimir(IDocumento documento) {
        documento.imprimir();
    }
}
