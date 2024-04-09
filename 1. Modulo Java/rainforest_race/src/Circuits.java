public class Circuits {
    private int circuitId;
    private String name;
    private int raceDistance;
    private String circuit;
    private boolean adultsOnly;
    private double kidPrice;
    private double adultPrice;

    public Circuits(int circuitId, String name, int raceDistance, String circuit, boolean adultsOnly, double adultPrice) {
        this.circuitId = circuitId;
        this.name = name;
        this.raceDistance = raceDistance;
        this.circuit = circuit;
        this.adultsOnly = adultsOnly;
        this.kidPrice = 0;
        this.adultPrice = adultPrice;
    }

    public Circuits(int circuitId, String name, int raceDistance, String circuit, boolean adultsOnly, double kidPrice, double adultPrice) {
        this.circuitId = circuitId;
        this.name = name;
        this.raceDistance = raceDistance;
        this.circuit = circuit;
        this.adultsOnly = adultsOnly;
        this.kidPrice = kidPrice;
        this.adultPrice = adultPrice;
    }

    public int getCircuitId() {
        return circuitId;
    }

    public void setCircuitId(int circuitId) {
        this.circuitId = circuitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRaceDistance() {
        return raceDistance;
    }

    public void setRaceDistance(int raceDistance) {
        this.raceDistance = raceDistance;
    }

    public String getCircuit() {
        return circuit;
    }

    public void setCircuit(String circuit) {
        this.circuit = circuit;
    }

    public boolean isAdultsOnly() {
        return adultsOnly;
    }

    public void setAdultsOnly(boolean adultsOnly) {
        this.adultsOnly = adultsOnly;
    }

    public double getKidPrice() {
        return kidPrice;
    }

    public void setKidPrice(double kidPrice) {
        this.kidPrice = kidPrice;
    }

    public double getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(double adultPrice) {
        this.adultPrice = adultPrice;
    }
}
