import java.util.ArrayList;
import java.util.List;

public class Carrera {
    public static void main(String[] args) {

        //Categorias
        Categoria cat1 = new Categoria(1,"Circuito chico", "2 km por selva y arroyos");
        Categoria cat2 = new Categoria(2,"Circuito medio", "5 km por selva, arroyos y barro");
        Categoria cat3 = new Categoria(3,"Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra");

        List<Participante> participantes = new ArrayList<Participante>();
        //Participantes
        Participante par1 = new Participante(0,123, "Juan Perez", 17, "123", "123", "A+", cat1);
        Participante par2 = new Participante(1,456, "Maria Becerra", 21, "456", "456", "B+", cat2);
        Participante par3 = new Participante(3,789, "Mariano Martinez", 25, "789", "789", "O-", cat3);

        //Inscripcion de participantes
        participantes.add(par1);
        participantes.add(par2);
        participantes.add(par3);

        /*
        System.out.println(par1.inscribirInscripcion());
        System.out.println(par2.inscribirInscripcion());
        System.out.println(par3.inscribirInscripcion());
         */

        //Organizacion de categorias
        List<Participante> listCat1 = new ArrayList<Participante>();
        List<Participante> listCat2 = new ArrayList<Participante>();
        List<Participante> listCat3 = new ArrayList<Participante>();

        //Participantes por categoria
        for (Participante part : participantes){
            if(part.categoria.id == 1){
                listCat1.add(part);
            } else if (part.categoria.id == 2) {
                listCat2.add(part);
            }else {
                listCat3.add(part);
            }
        }
        //Participantes categoria 1
        System.out.println("----Participantes Categoria 1----");
        for (Participante part: listCat1){
            System.out.println("Nombre y apellido: " + part.nombre_apellido + ", Categoria: " + part.categoria.id);
        }

        //Participantes categoria 2
        System.out.println("----Participantes Categoria 2----");
        for (Participante part: listCat2){
            System.out.println("Nombre y apellido: " + part.nombre_apellido + ", Categoria: " + part.categoria.id);
        }

        //Participantes categoria 3
        System.out.println("----Participantes Categoria 3----");
        for (Participante part: listCat3){
            System.out.println("Nombre y apellido: " + part.nombre_apellido + ", Categoria: " + part.categoria.id);
        }


        System.out.println("");
        System.out.println("");
        System.out.println("");
        //Borramos participante de la categoria 1
        System.out.println("Borrando participante de la primera categoria");

        par1.categoria = null;
        participantes.remove(0);
        listCat1.remove(0);

        //Participantes categoria 1
        System.out.println("----Participantes Categoria 1----");
        for (Participante part: listCat1){
            System.out.println("Nombre y apellido: " + part.nombre_apellido + ", Categoria: " + part.categoria.id);
        }

        System.out.println("");
        System.out.println("");
        System.out.println("");
        //Mostramos el monto total por categoria y por todas las categorias

        //Precio total categoria 1
        System.out.println("----Recaudado Categoria 1----");
        int aux = 0;//Utilizado para el total por categoria
        int auxTotal = 0;//Utilizado para el total de las carreras
        for (Participante part: listCat1){
            aux += part.inscribirInscripcion();
        }
        auxTotal += aux;
        System.out.println("Recaudado: " + aux);

        //Precio total categoria 2
        System.out.println("----Recaudado Categoria 2----");
        aux = 0;
        for (Participante part: listCat2){
            aux += part.inscribirInscripcion();
        }
        auxTotal += aux;
        System.out.println("Recaudado: " + aux);

        //Precio total categoria 1
        System.out.println("----Recaudado Categoria 3----");
        aux = 0;
        for (Participante part: listCat3){
            aux += part.inscribirInscripcion();
        }
        auxTotal += aux;
        System.out.println("Recaudado: " + aux);

        System.out.println("");
        System.out.println("");
        System.out.println("");

        //Total de la carrera
        System.out.println("----Recaudado Total----");
        System.out.println("El total recaudado total es: " + auxTotal);



    }
}




