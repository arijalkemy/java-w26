import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Inscripcion> inscripciones= new ArrayList<>();

        Categoria categoriaChica= new Categoria(1,"Circuito chico","2 km por selva y arroyos.");
        Categoria categoriaMedia= new Categoria(2,"Circuito medio","5 km por selva, arroyos y barro.");
        Categoria categoriaAvanzada= new Categoria(3,"Circuito avanzado","10 km por selva, arroyos, barro y escalada en piedra.");

        Participante participante1 = new Participante(1,"123","Santiago","Buitrago",25,"123","123","O+");
        Participante participante2 = new Participante(2,"123","Santiago","Buitrago",12,"123","123","O+");
        Participante participante3 = new Participante(3,"123","Santiago","Buitrago",18,"123","123","O+");
        Participante participante4 = new Participante(4,"123","Santiago","Buitrago",21,"123","123","O+");

        Inscripcion inscripcion1 = new Inscripcion(1,categoriaChica,participante1);
        Inscripcion inscripcion2 = new Inscripcion(2,categoriaMedia,participante2);
        Inscripcion inscripcion3 = new Inscripcion(3,categoriaAvanzada,participante3);
        Inscripcion inscripcion4 = new Inscripcion(4,categoriaChica,participante4);

        System.out.println("Monto a abonar por participante "+inscripcion1.getNumeroInscripción()+" :"+inscripcion1.getMontoAbonar());
        System.out.println("Monto a abonar por participante "+inscripcion2.getNumeroInscripción()+" :"+inscripcion2.getMontoAbonar());
        System.out.println("Monto a abonar por participante "+inscripcion3.getNumeroInscripción()+" :"+inscripcion3.getMontoAbonar());
        System.out.println("Monto a abonar por participante "+inscripcion4.getNumeroInscripción()+ " :" +inscripcion4.getMontoAbonar());

        inscripciones.add(inscripcion1);
        inscripciones.add(inscripcion2);
        inscripciones.add(inscripcion3);
        inscripciones.add(inscripcion4);


        System.out.println("Inscripciones de la categoria Circuito chico:");
        for (Inscripcion ins:inscripciones){
            if (ins.getCategoria().getNombre()=="Circuito chico"){
                System.out.println(ins.getNumeroInscripción() +
                                    ins.getParticipante().getNombre()+
                                    ins.getParticipante().getApellido() +
                                    ins.getParticipante().getDni());
            }
        }

        inscripciones.remove(inscripcion1);
        System.out.println("Desinscripcion de la categoria Circuito chico:");
        for (Inscripcion ins:inscripciones){
            if (ins.getCategoria().getNombre()=="Circuito chico"){
                System.out.println(ins.getNumeroInscripción() +
                        ins.getParticipante().getNombre()+
                        ins.getParticipante().getApellido() +
                        ins.getParticipante().getDni());
            }
        }

        int montoTotal=0;
        int montoCategoria1=0;
        int montoCategoria2=0;
        int montoCategoria3=0;
        for (Inscripcion ins:inscripciones){
            if (ins.getCategoria().getNombre().equals("Circuito chico")){
                montoCategoria1+=ins.getMontoAbonar();
            }
            else if(ins.getCategoria().getNombre().equals("Circuito medio")){
                montoCategoria2+=ins.getMontoAbonar();
            }
            else if(ins.getCategoria().getNombre().equals("Circuito avanzado")){
                montoCategoria3+=ins.getMontoAbonar();
            }
            montoTotal+=ins.getMontoAbonar();
        }
        System.out.println("Monto total abonado de todas las categorias: "+montoTotal);
        System.out.println("Monto total abonado de la categoria chica: "+montoCategoria1);
        System.out.println("Monto total abonado de la categoria media: "+montoCategoria2);
        System.out.println("Monto total abonado de la categoria avanzada: "+montoCategoria3);
    }
}