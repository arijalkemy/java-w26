package org.example;

public class MultiplicarPorTres extends Series<Double>{
    public MultiplicarPorTres(int id, Double primerValor) {
        super(id, primerValor);
    }

    public Double siguienteValor() {
        return this.getValorActual()*3;
    }

    public void ejercutarnVeces(int n) {
        Double valor = this.getValorActual();
        int nuevait= this.getIteracion();
        if(nuevait==0){
            this.setIniciada(true);
        }
        for(int i=0; i<n;i++){
            valor = valor * 3;
            System.out.println("la iteracion numero "+(nuevait + 1 )+" devuelve el valor "+valor );
            nuevait++;
        }
        this.setIteracion(nuevait);
        this.setValorActual(valor);
    }
}
