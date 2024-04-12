package com.example;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {

        boolean opMenu = true;
        boolean opSeries = true;

        Scanner scn = new Scanner(System.in);
        int opSwitchMenu = 0;
        int opSwitchSeries = 0;
        int jumpSeriesValue = 0;
        while (opMenu) {

            System.out.println("-------------Bienvenido al sistema de simulación de series-----------------" + "\n" +
                                 "1. Serie de sumas" + "\n" +
                                 "2. Serie de multiplicación" + "\n" +
                                 "3. Salir" + "\n"
                                 );
            System.out.print(">_ ");

            opSwitchMenu = scn.nextInt();
            scn.nextLine();

            switch (opSwitchMenu) {
                    case 1:
                    System.out.print("Definir el valor de salto en la serie: ");
                    jumpSeriesValue = scn.nextInt();
                    scn.nextLine();

                    SumSeries serieSum = new SumSeries();
                    serieSum.setSumSeriesValue(jumpSeriesValue);

                    while (opSeries) {
                        System.out.println("------------------- Serie de Sumas --------------------------" + "\n" +
                                        "1. Definir valor inicial" + "\n" +
                                        "2. Obtener valor siguiente" + "\n" +
                                        "3. Reiniciar Serie" + "\n" +
                                        "4. Cambiar de tipo de Serie");
                        opSwitchSeries = scn.nextInt();
                        scn.nextLine();
                        switch (opSwitchSeries) {
                            case 1:
                            System.out.print("Valor inicial: ");
                            serieSum.setInititalValue(scn.nextInt());
                            System.out.println("Valor actual en la serie: " + serieSum.getCurrentValue());                            
                            break;

                            case 2:
                            serieSum.nextValue();
                            System.out.println("Valor actual en la serie: " + serieSum.getCurrentValue());                            
                            break;
                            
                            case 3:
                            serieSum.restartSeries();
                            System.out.println("Serie reiniciada - Valor actual en la serie: " + serieSum.getCurrentValue());
                            break;

                            case 4:
                            opSeries = false;
                            break;

                            default:
                            System.out.println("Valor erróneo, retornando al menú principal");
                            break;
                        }

                        
                    }
                opSeries = true;
                break;
            case 2:
                System.out.print("Definir el valor de salto en la serie: ");
                jumpSeriesValue = scn.nextInt();
                scn.nextLine();

                MultiplySeries multSeries = new MultiplySeries();
                multSeries.setSumSeriesValue(jumpSeriesValue);
                while (opSeries) {

                    System.out.println("------------------- Serie de Multiplicación --------------------------" + "\n" +
                                       "1. Definir valor inicial" + "\n" +
                                       "2. Obtener valor siguiente" + "\n" +
                                       "3. Reiniciar Serie" + "\n" +
                                       "4. Cambiar de tipo de Serie");
                    opSwitchSeries = scn.nextInt();
                    scn.nextLine();
                    switch (opSwitchSeries) {
                        case 1:
                        System.out.print("Valor inicial: ");
                        multSeries.setInititalValue(scn.nextDouble());
                        System.out.println("Valor actual en la serie: " + multSeries.getCurrentValue());                            
                        break;

                        case 2:
                        multSeries.nextValue();
                        System.out.println("Valor actual en la serie: " + multSeries.getCurrentValue());                            
                        break;
                        
                        case 3:
                        multSeries.restartSeries();
                        System.out.println("Serie reiniciada - Valor actual en la serie: " + multSeries.getCurrentValue());
                        break;

                        case 4:
                        opSeries = false;
                        break;

                        default:
                        System.out.println("Valor erróneo, retornando al menú principal");
                        opSeries = false;

                        break;
                    }   
                }
                opSeries = true;
                break;
                
                case 3:
                opMenu = false;
                break;
                default:
                    System.out.println("Opción incorrecta");
                    opMenu = false;

                    break;
            }    
        }
        scn.close();
    }
}
