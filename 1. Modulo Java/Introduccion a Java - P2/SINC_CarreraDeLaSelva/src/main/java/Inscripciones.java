import java.util.ArrayList;
import java.util.List;

public class Inscripciones {
    private int idInscripcion;
    private Categorias categoria;
    private Participantes participante;
    private double monto;

    protected static List<Inscripciones> listaInscripciones = new ArrayList<>();

    public Inscripciones(int idInscripcion, Categorias categoria, Participantes participante) {
        this.idInscripcion = idInscripcion;
        this.categoria = categoria;
        this.participante = participante;

        listaInscripciones.add(this);
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public Participantes getParticipante() {
        return participante;
    }

    public void setParticipante(Participantes participante) {
        this.participante = participante;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public static double calcularMontoPorDNI(String dniParticipante) {
        for (Inscripciones inscripcion : listaInscripciones) {
            if (inscripcion.participante.getDni().equals(dniParticipante)) {
                switch (inscripcion.categoria.getId()) {
                    case 1:
                        if (inscripcion.participante.getEdad() < 18) {
                            inscripcion.monto = 1300;
                        } else {
                            inscripcion.monto = 1500;
                        }
                        break;
                    case 2:
                        if (inscripcion.participante.getEdad() < 18) {
                            inscripcion.monto = 2000;
                        } else {
                            inscripcion.monto = 2300;
                        }
                        break;
                    case 3:
                        if (inscripcion.participante.getEdad() < 18) {
                            inscripcion.monto = 0;
                        } else {
                            inscripcion.monto = 2800;
                        }
                        break;
                }
                return inscripcion.monto;
            }
        }
        return 0;
    }

    public double calcularMonto() {
        switch (categoria.getId()) {
            case 1:
                if (participante.getEdad() < 18) {
                    monto = 1300;
                } else {
                    monto = 1500;
                }
                break;
            case 2:
                if (participante.getEdad() < 18) {
                    monto = 2000;
                } else {
                    monto = 2300;
                }
                break;
            case 3:
                if (participante.getEdad() < 18) {
                    monto = 0;
                } else {
                    monto = 2800;
                }
                break;
        }
        return monto;
    }


    public static List<Inscripciones> obtenerInscripcionesPorCategoria(int idCategoria) {
        List<Inscripciones> listaInscripcionesPorCategoria = new ArrayList<>();

        for (Inscripciones inscripcion : listaInscripciones) {
            if (inscripcion.categoria.getId() == idCategoria) {
                listaInscripcionesPorCategoria.add(inscripcion);
            }
        }
        return listaInscripcionesPorCategoria;
    }

    public String mostrarDatosInscripcion() {
        return "Inscripcion numero: " + idInscripcion +
                "\nNombre: " + participante.getNombre() +
                "\nApellido: " + participante.getApellido() +
                "\nDNI: " + participante.getDni() +
                "\nEdad: " + participante.getEdad() +
                "\nCelular: " + participante.getCelular() +
                "\nNumero de emergencia: " + participante.getNumeroEmergencia() +
                "\nGrupo sanguineo: " + participante.getGrupoSanguineo() + "\n";
    }

    public static void desincribirParticipante(String dniParticipante) {
        for (Inscripciones inscripcion : listaInscripciones) {
            if (inscripcion.participante.getDni().equals(dniParticipante)) {
                listaInscripciones.remove(inscripcion);
                break;
            }
        }
    }

    public static int obtenerCategoria(String dniParticipante) {
        for (Inscripciones inscripcion : listaInscripciones) {
            if (inscripcion.participante.getDni().equals(dniParticipante)) {
                int idCategoria = inscripcion.categoria.getId();
                return idCategoria;
            }
        }
        return 0;
    }

    public static double obtenerMontosTotales(int idCategoria) {
        double montoAcumulado = 0.0;
        if (idCategoria != 0) {
            for (Inscripciones inscripcion : listaInscripciones) {
                if (inscripcion.categoria.getId() == idCategoria) {
                    montoAcumulado += inscripcion.calcularMonto();
                }
            }
        } else {
            for (Inscripciones inscripcion : listaInscripciones) {
                montoAcumulado += inscripcion.calcularMonto();
            }
        }
        return montoAcumulado;
    }
}
