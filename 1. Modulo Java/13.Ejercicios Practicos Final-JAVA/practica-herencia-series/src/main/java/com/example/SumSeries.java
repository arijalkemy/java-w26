package com.example;


public class SumSeries extends Prototype<Integer>{


    private Integer currentValue;
    private int sumSeriesValue;
    
    public SumSeries(){
        this.currentValue = 0;
        this.sumSeriesValue = 0;
    }

    public Integer getSumSeriesValue() {
        return sumSeriesValue;
    }
    public Integer getCurrentValue() {
        return currentValue;
    }

    /*
     * Este método set define la lógica que seguirá la serie
     * será el factor que determine la sucesión de números
     */
    public void setSumSeriesValue(Integer num){
        this.sumSeriesValue = num;
    }


    /*
     * Se devuelve el valor de la forma tal que
     * n = n+x
     * En el que n: currentValue
     *           x: sumSeriesValue
     * 
     * ej: sumSeriesValue = 2
     *     n = n+2
     */

    @Override
    public void nextValue(){
        this.currentValue += this.sumSeriesValue;
    };

    @Override
    public void restartSeries(){
        this.currentValue = 0;
    };

    @Override
    public void setInititalValue(Integer num){
        this.currentValue = num;
    }
};



    


