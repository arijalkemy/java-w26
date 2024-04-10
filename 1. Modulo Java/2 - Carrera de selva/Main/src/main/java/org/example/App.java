package org.example;
import java.util.ArrayList;
import java.util.List;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Categoria cat1 = new Categoria(0,"Circuito chico", "2 km por selva y arroyos");
        Categoria cat2 = new Categoria(1,"Circuito medio", "5 km por selva, arroyos y barro");
        Categoria cat3 = new Categoria(2,"Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra");

        List<Participante> participantes = new ArrayList<Participante>();
        Participante par1 = new Participante(0,123, "Juan Perez", 17, "123", "123", "A+", cat1);
        Participante par2 = new Participante(1,456, "Maria Becerra", 21, "456", "456", "B+", cat2);
        Participante par3 = new Participante(3,789, "Mariano Martinez", 25, "789", "789", "O-", cat3);

        participantes.add(par1);
        participantes.add(par2);
        participantes.add(par3);

        System.out.println(par1.InscribirInscripcion());
        System.out.println(par2.InscribirInscripcion());
        System.out.println(par3.InscribirInscripcion());

        for (Participante part : participantes){
            if(part.categoria.id == 1){
                System.out.println("Nombre y apellido: " + part.nombre_apellido + ", Categoria: " + part.categoria.id);
            }
        }
    }
}
