import java.util.*;

public class Main {
    public static void main(String[] args) {

        /*
        * DEFINIENDO ARREGLO DE CATEGORIAS Y PARTICIPANTES
        *
        * */
        Categoria[] categorias = {
                new Categoria("Circuito chico",2, new String[]{"Selva", "Arroyos"}, 0, 1300, 1500),
                new Categoria("Circuito medio",5, new String[]{"Selva", "Arroyos", "Barro"}, 0, 2000, 2300),
                new Categoria("Circuito grande",10, new String[]{"Selva", "Arroyos", "Barro", "Escalada en piedra"}, 18, 0, 2800)};

        List<Participante> participantes = new ArrayList<>();

        participantes.add(new Participante(15, "Juan", "Perez", 31041142));
        participantes.add(new Participante(21, "Ivan", "Gonzalez", 41314414));
        participantes.add(new Participante(17, "Kevin", "Caceres", 34321522));
        participantes.add(new Participante(25, "Juan", "Benitez", 42153612));
        participantes.add(new Participante(14, "Ezequiel", "Diaz", 20314434));
        participantes.add(new Participante(21, "Matias", "Perez", 41042923));

        Inscripcion inscripcion = new Inscripcion();

        /*
        * Inscribriendo participante
        * */

        System.out.println("Inscribiendo participante: " + participantes.get(0) + " en la categoria: " + categorias[0].toString());
        inscripcion.inscribir(categorias[0], participantes.get(0));

        /*
        * Inscribiendo demas participantes en categorias
        * */

        int numCategoria = 0;
        for(Participante participante: participantes){
            inscripcion.inscribir(categorias[numCategoria], participante);
            numCategoria = numCategoria == 2 ? 0 : numCategoria + 1;
        }

        /*
        * Definicion de map montosRecaudados
        * Calculamos lo abonado por categoria
        * */

        Map<String, Double>  montosRecaudados = new HashMap<>();
        montosRecaudados.put("Circuito chico", 0.0);
        montosRecaudados.put("Circuito medio", 0.0);
        montosRecaudados.put("Circuito grande", 0.0);

        for(Participante participante: participantes) {
            if(inscripcion.estaInscripto(participante)) {
                montosRecaudados.put(inscripcion.categoriaInscripto(participante),
                        montosRecaudados.get(inscripcion.categoriaInscripto(participante)) + inscripcion.precioInscripcion(participante));
            }
        }

        /*
        * Print de participantes en circuito chico
        * */

        System.out.println("Circuito chico: ");
        for(Participante participante: participantes){
            if(participante.getCategoria().equals("Circuito chico")){
                System.out.println(participante.toString());
            }
        }

        /*
        * Se elimina participante de circuito chico y print
        * */

        System.out.println("Desiscribiendo participante de circuito chico");
        inscripcion.desinscribir(participantes.get(0));

        System.out.println("Circuito chico: ");
        for(Participante participante: participantes){
            if(participante.getCategoria().equals("Circuito chico")){
                System.out.println(participante.toString());
            }
        }

        /*
         * Monto ecaudado por categoria y total
         * */

        double montoTotal = 0;
        for(Map.Entry<String, Double> montos: montosRecaudados.entrySet()){
            System.out.println(montos.getKey() + " $ " + montos.getValue());
            montoTotal += montos.getValue();
        }

        System.out.println("Total " + montoTotal);
    }
}
