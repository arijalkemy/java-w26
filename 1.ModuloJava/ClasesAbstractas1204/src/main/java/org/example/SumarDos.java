package org.example;

public class SumarDos extends Series<Integer>{

    public SumarDos(int id, Integer primerValor) {
        super(id, primerValor);
    }
    public Integer siguienteValor() {
        return this.getValorActual()+2;
    }
    public void ejercutarnVeces(int n) {
        Integer valor = this.getValorActual();
        int nuevait= this.getIteracion();
        if(nuevait==0){
            this.setIniciada(true);
        }
        for(int i=0; i<n;i++){
            valor = valor + 2;
            System.out.println("la iteracion numero "+(nuevait + 1 )+" devuelve el valor "+valor );
            nuevait++;
        }
        this.setIteracion(nuevait);
        this.setValorActual(valor);
    }

}
