public abstract class Prototipo <T extends Number>{
    /**
     * analizar la posibilidad de usar instanceOf para setear el tipo de dato al realizar la instancia para asi ya dejar
     * seteado el tipo.
     */
    private T valorInicial;
    private T valorActual;
    private T paso;

    //constructor
    public Prototipo(T paso) {
        this.paso = paso;
    }


    public void reinicio(){
        valorActual = valorInicial;
    }

    public void setValorInicial(T valorInicial){
        this.valorInicial = valorInicial;
        valorActual = valorInicial;
    }

    public void setPaso(T paso) {
        this.paso = paso;
    }

    public void valor(){
        /**
         * Dependiendo del tipo de dato numerico ingresado, se selecciona la forma correcta de manejar los datos.
         */
        if (valorInicial instanceof Integer){
            int valorAux = valorActual.intValue();
            int pasoAux = paso.intValue();
            valorAux = (valorAux + pasoAux);
            System.out.println("Valor: " + valorAux);
            //se transforma el valor del incremento a un generico tipo T para poder realizar la asignacion correcta
            valorActual = (T) Integer.valueOf(valorAux);

        } else if (valorInicial instanceof Long){
            long valorAux = valorActual.longValue();
            long pasoAux = paso.longValue();
            valorAux = (valorAux + pasoAux);
            System.out.println("Valor: " + valorAux);
            valorActual = (T) Long.valueOf(valorAux);

        }else if (valorInicial instanceof Float){
            float valorAux = valorActual.floatValue();
            float pasoAux = paso.floatValue();
            valorAux = (valorAux + pasoAux);
            System.out.println("Valor: " + valorAux);
            valorActual = (T) Float.valueOf(valorAux);

        } else if (valorInicial instanceof Double){
            double valorAux = valorActual.doubleValue();
            double pasoAux = paso.doubleValue();
            valorAux = (valorAux + pasoAux);
            System.out.println("Valor: " + valorAux);
            valorActual = (T) Double.valueOf(valorAux);

        }else{
            throw new IllegalArgumentException("Tipo de dato erroneo.");
        }
    }


}
