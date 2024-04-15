package org.example;

import java.util.ArrayList;

public class App
{
    //metodo main
    public static void main( String[] args )
    {
        //declaraciones de variables y arraylist
        ArrayList<Categoria> categorias=new ArrayList<>();
        ArrayList<Participante> participantes=new ArrayList<>();
        ArrayList<Inscripcion> inscripciones=new ArrayList<>();
        int indexParticipante=0;

        //inicializacion de categorias
        categorias.add(new Categoria(1,"Chico", "2km por selva y arrollo."));
        categorias.add(new Categoria(2,"Medio", "5km por selva, arrollo y barro."));
        categorias.add(new Categoria(3,"Avanzado", "10km por selva, arrollo, barro y escalada de piedra."));

        //inicializacion de participantes
        participantes.add(new Participante(1,"DNI1", "Manu", "Malacara", 24, "5565591810", "5566778899", "O+"));
        participantes.add(new Participante(2,"DNI2", "Pepe", "Lopez", 16, "5555555555", "666666666666", "O-"));
        participantes.add(new Participante(3,"DNI3", "Omar", "Moreno", 18, "7777777777", "8888888888", "A+"));
        participantes.add(new Participante(4,"DNI4", "Yair", "Diaz", 19, "1111111111", "3333333333", "A+"));
        participantes.add(new Participante(5,"DNI5", "Milton", "Diaz", 21, "2222222222", "4444444444", "O+"));
        participantes.add(new Participante(6,"DNI6", "Carlos", "Diaz", 19, "5565504952", "5589385418", "A+"));
        participantes.add(new Participante(7,"DNI7", "David", "Diaz", 27, "5565591832", "5692034924", "O+"));

        //for para asignar inscripciones al azar
        for(Participante participante: participantes){
            int numero = (int)(Math.random()*3+1); //generacion de numero random para entre 1 y 3
            int bono=0;
            if(numero==1){ //si es numero es 1 asigna a la primera categoria

                if(participante.getEdad()<18){
                    bono=1300;
                }else{
                    bono=1500;
                }
                inscripciones.add(new Inscripcion(categorias.get(0),participantes.get(indexParticipante),bono));
            }else if(numero==2){ //si es numero es 2 asigna a la segunda categoria y verifica la edad para asignar el bono
                if(participante.getEdad()<18){
                    bono=2000;
                }else{
                    bono=2300;
                }
                inscripciones.add(new Inscripcion(categorias.get(1),participantes.get(indexParticipante),bono));
            }else{ //si es numero es 3 asigna a la tercera categoria y verifica la edad para asignar el bono
                if(participante.getEdad()<18){
                    inscripciones.add(new Inscripcion(categorias.get(2),participantes.get(indexParticipante),bono));// asigna el bono en 0 ya que es menor de edad
                    inscripciones.get(indexParticipante).setPuedeInscribirse(false); //en caso de ser menor de edad asigna false la inscripcion
                }else {
                    bono=2800;
                    inscripciones.add(new Inscripcion(categorias.get(2),participantes.get(indexParticipante),bono));

                }

            }
            indexParticipante++; //incremento del indice de participante
        }
        //imprimiendo las inscripciones
        System.out.println("-------------INSCRIPCIONES-------------");
        for(Inscripcion inscripcion: inscripciones){ //for que recorre el ArrayList inscripciones
            inscripcion.mostrarInscripcion(); //metodo mostrarInscripcion para imprimir la informacion
        }

        inscripciones.remove((int)(Math.random()*inscripciones.size())); //eliminando una inscripcion al azar
        //imprimiendo las inscripciones despues de borrar
        System.out.println("\n\n-------------INSCRIPCIONES DESPUES DE BORRAR-------------");
        for(Inscripcion inscripcion: inscripciones){//for que recorre el ArrayList inscripciones
            inscripcion.mostrarInscripcion();//metodo mostrarInscripcion para imprimir la informacion
        }
        //imprimiendo los montos recaudados
        System.out.println("\n\n-------------MONTOS RECAUDADOS-------------");
        int montos[]={0,0,0}; // vector de montos para las 3 cantidades diferentes
        for(Inscripcion inscripcion: inscripciones){ //for que recorre el arraylist inscripciones
            //switch para validar a que categoria corresponde cada monto
            switch (inscripcion.getInscripcionCategoria()){
                case 1:
                    montos[0]=montos[0]+inscripcion.getAbono(); //suma de monto categoria 1
                    break;
                case 2:
                    montos[1]=montos[1]+inscripcion.getAbono(); //suma de monto categoria 2
                    break;
                case 3:
                    montos[2]=montos[2]+inscripcion.getAbono(); //suma de monto categoria 3
                    break;
            }
        }
        //imprime en pantalla los montos por cargo y el monto total recaudado
        System.out.println("El monto recaudado de la categoria chico es:"+montos[0]+"\nEl monto recaudado de la categoria medio es:"+montos[1]+"\nEl monto recaudado de la categoria avanzado es:"+montos[2]);
        System.out.println("El monto total recaudado es:"+(montos[0]+montos[1]+montos[2]));
    }
}
