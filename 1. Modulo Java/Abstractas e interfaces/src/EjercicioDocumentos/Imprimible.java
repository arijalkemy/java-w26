package EjercicioDocumentos;

public interface Imprimible {
    static String imprimirDocumento(Object documento){
       return documento.toString();
    }

    static String tipoDocumento(Object documento){
        if(documento instanceof Curriculum){return "Curriculum";}
        if(documento instanceof PDF){return "PDF";}
        if(documento instanceof Informe){return "Informe";}
        return "";
    }
}
