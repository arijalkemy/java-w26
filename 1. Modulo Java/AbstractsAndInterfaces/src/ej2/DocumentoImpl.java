package ej2;

public abstract class DocumentoImpl implements iDocumento {
    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }

    public static void imprimirDocumento(DocumentoImpl documento){
        documento.imprimir();
    }
}
