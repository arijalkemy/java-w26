public class Categoria {

    private int id;
    private String nombre;
    private String categoria;
    private double minorPricing;
    private double mayorPricing;
    private int minEdad;

    public Categoria(int id, String nombre, String categoria, double minorPricing, double mayorPricing, int minEdad) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.minorPricing = minorPricing;
        this.mayorPricing = mayorPricing;
        this.minEdad = minEdad;
    }

    public boolean allowParticipant(int edad) {
        if(minEdad == -1) return true;
        return minEdad <= edad;
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof Categoria)) return false;
        Categoria oCategoria = (Categoria) other;
        return oCategoria.getId() == this.id;
    }

    // Getters

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getCategoria() {
        return this.categoria;
    }


    public double getMinorPricing() {
        return this.minorPricing;
    }

    public double getMayorPricing() {
        return this.mayorPricing;
    }


}
