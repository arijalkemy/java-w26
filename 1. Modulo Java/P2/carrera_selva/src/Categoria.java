public enum Categoria {
    CIRCUITO_CHICO("Circuito Chico",2, new String[]{"selva", "arroyos"}),
    CIRCUITO_MEDIANO("Circuito Mediano", 5, new String[]{"selva","arroyos","barro"}),
    CIRCUITO_AVANZADO("Circuito avanzado", 10,  new String[]{"selva", "arroyos", "barro", "escalada en piedra"});
    private String nombre;
    private double distancia;
    private String[] terrenos;

    public String getNombre() {
        return nombre;
    }

    public static boolean inscribirParticipante(Participante participante, Categoria categoria){
        if(categoria == Categoria.CIRCUITO_AVANZADO && participante.getEdad() < 18) {
            System.out.println("El participante debe ser mayor de 18 para participar de esta categoría");
            return false;
        }
        participante.setCategoria(categoria);
        return true;
    }

    static double getPrecio(Participante participante){
        switch (participante.getCategoria()) {
            case CIRCUITO_CHICO:
                if (participante.getEdad() < 18) {
                    return 1300;
                } else {
                    return 1500;
                }
            case CIRCUITO_MEDIANO:
                if (participante.getEdad() < 18) {
                    return 2000;
                } else {
                    return 2300;
                }
            case CIRCUITO_AVANZADO:
                if (participante.getEdad() < 18) {
                    System.out.println("El participante debe ser mayor de edad para participar en este circuito");
                   return 0;
                } else {
                    return 2800;
                }
            default: throw new IllegalArgumentException("No se puede determinar el categoria");
        }
    }
    private Categoria(String nombre, double distancia, String[] terrenos) {
        this.nombre = nombre;
        this.distancia = distancia;
        this.terrenos = terrenos;
    }
}



