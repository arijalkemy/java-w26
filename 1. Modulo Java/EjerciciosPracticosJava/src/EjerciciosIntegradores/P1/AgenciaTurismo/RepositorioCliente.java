package EjerciciosIntegradores.P1.AgenciaTurismo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioCliente {
    Map<Integer, List<Localizador>> localizadoresClientes;
    Map<Integer, Integer> clienteDescuentoPorDosComprasAnteriores;

    public RepositorioCliente() {
        this.localizadoresClientes = new HashMap<>();
        this.clienteDescuentoPorDosComprasAnteriores = new HashMap<>();
    }

    public void agregarLocalizador(int dniCliente, Localizador localizador){
        if(!this.localizadoresClientes.containsKey(dniCliente)){
            this.localizadoresClientes.put(dniCliente, new ArrayList<>(){
                {
                    add(localizador);
                }
            });
            this.clienteDescuentoPorDosComprasAnteriores.put(dniCliente, 1);
        }else{
            if(this.clienteDescuentoPorDosComprasAnteriores.get(dniCliente) == 2){
                localizador.setDescuento10();
                localizador.calcularCosto();
            }else{
                this.clienteDescuentoPorDosComprasAnteriores.replace(dniCliente, this.clienteDescuentoPorDosComprasAnteriores.get(dniCliente) + 1);
            }
            this.localizadoresClientes.get(dniCliente).add(localizador);
        }
    }

    public void imprimirLocalizadoresCliente(int dniCliente){
        System.out.println("Dni cliente: " + dniCliente);
        System.out.println("Localizadores:{");

        for(Localizador localizador : this.localizadoresClientes.get(dniCliente)){
            System.out.println(localizador + "\n");
        }
        System.out.println("}");
    }
}
