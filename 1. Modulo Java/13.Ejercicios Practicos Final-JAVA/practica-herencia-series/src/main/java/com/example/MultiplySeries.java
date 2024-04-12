package com.example;

public class MultiplySeries extends Prototype<Double>{

    private Double currentValue;
    private int multSeriesValue;



    public MultiplySeries(){
        this.currentValue = 1.0;
        this.multSeriesValue = 0;
    }
    public double getCurrentValue() {
        return currentValue;
    }
    public double getMultSeriesValue() {
        return multSeriesValue;
    }

    /*
     * Este método define la lógica que seguirá la serie
     * será el factor que determine la sucesión de números
     */
    public void setSumSeriesValue(int num){
        this.multSeriesValue = num;
    }

    /*
     * Se devuelve el valor de la forma tal que
     * n = n*x
     * En el que n: currentValue
     *           x: sumSeriesValue
     * 
     * ej: sumSeriesValue = 2
     *     n = n*2
     */

    @Override
    public void nextValue(){
        this.currentValue *= this.multSeriesValue;
    };

    @Override
    public void restartSeries(){
        this.currentValue = 0.0;
    };

    @Override
    public void setInititalValue(Double num){
        this.currentValue = num;
    }

}
