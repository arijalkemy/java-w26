package org.example;

public class RestarVeinte extends Series<Double> {
    public RestarVeinte(int id, Double primerValor) {
        super(id, primerValor);
    }

    public Double siguienteValor() {
        return this.getValorActual()-20.8;
    }

    public void ejercutarnVeces(int n) {
        Double valor = this.getValorActual();
        int nuevait= this.getIteracion();
        if(nuevait==0){
            this.setIniciada(true);
        }
        for(int i=0; i<n;i++){
            valor = valor - 20.8;
            System.out.println("la iteracion numero "+(nuevait + 1 )+" devuelve el valor "+valor );
            nuevait++;
        }
        this.setIteracion(nuevait);
        this.setValorActual(valor);

    }
}
