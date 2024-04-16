package org.example;

import org.example.model.GuardaRopa;
import org.example.model.Prenda;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Prenda prenda1 = new Prenda("miguel bose", "basico");
        Prenda prenda2 = new Prenda("shakira", "avanzado");

        List<Prenda> listaPrueba = new ArrayList<Prenda>();
        GuardaRopa guardaRopa = new GuardaRopa();

        listaPrueba.add(prenda1);
        listaPrueba.add(prenda2);

        Integer id = guardaRopa.guardarPrendas(listaPrueba);

        guardaRopa.mostrarPrendas();
        List<Prenda> listaRegreso = guardaRopa.devolverPrendas(id);

        for(Prenda prenda: listaRegreso){
            System.out.println(prenda);
        }

    }
}
