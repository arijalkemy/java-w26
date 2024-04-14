import java.util.ArrayList;
public class Selva{

    public static void main(String[]args){

        ArrayList<Categoria> categorias=new ArrayList<>();
        ArrayList<Participante> participantes=new ArrayList<>();
        ArrayList<Inscripcion> inscripciones=new ArrayList<>();
        int indexParticipante=0;

        categorias.add(new Categoria(1,"Chico", "2km por selva y arrollo."));
        categorias.add(new Categoria(2,"Medio", "5km por selva, arrollo y barro."));
        categorias.add(new Categoria(3,"Avanzado", "10km por selva, arrollo, barro y escalada de piedra."));

        participantes.add(new Participante(1,"DNI1", "Manu", "Malacara", 24, "5565591810", "5566778899", "O+"));
        participantes.add(new Participante(2,"DNI2", "Pepe", "Lopez", 16, "5555555555", "666666666666", "O-"));
        participantes.add(new Participante(3,"DNI3", "Omar", "Moreno", 18, "7777777777", "8888888888", "A+"));
        participantes.add(new Participante(4,"DNI4", "Yair", "Diaz", 19, "1111111111", "3333333333", "A+"));
        participantes.add(new Participante(5,"DNI5", "Milton", "Diaz", 21, "2222222222", "4444444444", "O+"));
        participantes.add(new Participante(6,"DNI6", "Carlos", "Diaz", 19, "5565504952", "5589385418", "A+"));
        participantes.add(new Participante(7,"DNI7", "David", "Diaz", 27, "5565591832", "5692034924", "O+"));
        
        for(Participante participante: participantes){
            int numero = (int)(Math.random()*3+1); 
            int bono=0;
            if(numero==1){
                
                if(participante.getEdad()<18){
                    bono=1300;
                }else{
                    bono=1500;
                }
                inscripciones.add(new Inscripcion(categorias.get(0),participantes.get(indexParticipante),bono));
            }else if(numero==2){
                if(participante.getEdad()<18){
                    bono=2000;
                }else{
                    bono=2300;
                }
                inscripciones.add(new Inscripcion(categorias.get(1),participantes.get(indexParticipante),bono));
            }else{
                if(participante.getEdad()<18){
                    bono=2000;
                    inscripciones.add(new Inscripcion(categorias.get(1),participantes.get(indexParticipante),bono));
                }else {
                    bono=2800;
                    inscripciones.add(new Inscripcion(categorias.get(2),participantes.get(indexParticipante),bono));
                    
                }
                
            }
            indexParticipante++;
        }
        System.out.println("-------------INSCRIPCIONES-------------");
        for(Inscripcion inscripcion: inscripciones){
            inscripcion.mostrarInscripcion();
        }
        //int numero = (int)(Math.random()*inscripciones.size());
        inscripciones.remove((int)(Math.random()*inscripciones.size()));
        System.out.println("\n\n-------------INSCRIPCIONES DESPUES DE BORRAR-------------");
        for(Inscripcion inscripcion: inscripciones){
            inscripcion.mostrarInscripcion();
        }
        System.out.println("\n\n-------------MONTOS RECAUDADOS-------------");
        int montos[]={0,0,0};
        for(Inscripcion inscripcion: inscripciones){
           switch (inscripcion.getInscripcionCategoria()){
            case 1:
                montos[0]=montos[0]+inscripcion.getAbono();
                break;
            case 2:
                montos[1]=montos[1]+inscripcion.getAbono();
                break;
            case 3:
                montos[2]=montos[2]+inscripcion.getAbono(); 
                break;   
           }
        }
        System.out.println("El monto recaudado de la categoria chico es:"+montos[0]+"\nEl monto recaudado de la categoria medio es:"+montos[1]+"\nEl monto recaudado de la categoria avanzado es:"+montos[2]);
        System.out.println("El monto total recaudado es:"+(montos[0]+montos[1]+montos[2]));
    }
}
