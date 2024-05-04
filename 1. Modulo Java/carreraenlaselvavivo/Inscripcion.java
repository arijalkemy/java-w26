class Inscripcion {

    int numeroDeInscripcion;
    Categoria categoria;
    Participante participante;
    int monto;

    public int getNumeroDeInscripcion() {
        return numeroDeInscripcion;
    }

    public void setNumeroDeInscripcion(int numeroDeInscripcion) {
        this.numeroDeInscripcion = numeroDeInscripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Inscripcion(int numeroDeInscripcion, Categoria categoria, Participante participante) {
        this.numeroDeInscripcion = numeroDeInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        calcularMonto();
    }


    public void calcularMonto()
    {
        switch (categoria.getNombre()) {
            case "Circuito chico":
                if(participante.getEdad() > 18)
                {
                    this.setMonto(1500);
                }else if(participante.getEdad() < 18)
                {
                    this.setMonto(1300);
                }
                break;
            case "Circuito medio":
                if(participante.getEdad() > 18)
                {
                    this.setMonto(2300);
                }
                else if(participante.getEdad() < 18)
                {
                    this.setMonto(2000);
                }
                break;

            case "Circuito avanzado":
                if(participante.getEdad() > 18)
                {
                    this.setMonto(2800);
                }
                else
                {
                    throw new RuntimeException("No se puede inscribir a un menor de 18 años en el circuito avanzado");
                }
                    break;
            default:
                break;
        }


       




        

    }
}