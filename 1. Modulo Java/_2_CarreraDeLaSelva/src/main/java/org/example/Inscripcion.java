package org.example;

public class Inscripcion {
    int NroInscripcion;
    Categoria Categoria;
    Participante Participante;
    double Monto;

    public Inscripcion(int nroInscripcion, Categoria categoria, Participante participante){
        NroInscripcion = nroInscripcion;
        Categoria = categoria;
        Participante = participante;
        calcularMonto();
    }

    private void calcularMonto(){
        switch (Categoria.Nombre){
            case "circuito chico":
                if(Participante.Edad < 18)
                    Monto = 1300;
                else
                    Monto = 1500;
                break;
            case "circuito medio":
                if(Participante.Edad < 18)
                    Monto = 2000;
                else
                    Monto = 2300;
                break;
            case "circuito avanzado":
                if(Participante.Edad > 18)
                    Monto = 2800;
                else
                    System.out.println("No se permiten menores en el circuito avanzado");
                break;
        }
    }
}
