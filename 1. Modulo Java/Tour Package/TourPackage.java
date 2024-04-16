public class TourPackage {
    private int ticket;
    private int hotel;
    private int food;
    private int transport;
    private double price;

    public TourPackage(int ticket, int hotel, int food, int transport, double price) {
        this.ticket = ticket;
        this.hotel = hotel;
        this.food = food;
        this.transport = transport;
        this.price = price;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public int getHotel() {
        return hotel;
    }

    public void setHotel(int hotel) {
        this.hotel = hotel;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getTransport() {
        return transport;
    }

    public void setTransport(int transport) {
        this.transport = transport;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "[TOUR PACKAGE] " + " ticket: " + this.ticket + " hotel: " + this.hotel + " food: " + this.food + " transport: " + this.transport + " price: " + this.price;
    }
}
