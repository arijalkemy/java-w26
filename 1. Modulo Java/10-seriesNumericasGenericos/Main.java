public class Main {
    public static void main(String[] args){
        //en caso de querer realizar una serie con otro paso, solo hay que generar otra clase hija de prototipo ajustando el paso
        Prototipo numeros = new Serie1();

        int valorInicial = 7;
        numeros.setValorInicial(valorInicial);
        numeros.valor();
        numeros.valor();
        numeros.valor();
        numeros.valor();
        numeros.reinicio();
        numeros.valor();
        numeros.valor();
        numeros.setValorInicial(3.0);
        numeros.valor();
        numeros.valor();
        numeros.valor();


    }
}

