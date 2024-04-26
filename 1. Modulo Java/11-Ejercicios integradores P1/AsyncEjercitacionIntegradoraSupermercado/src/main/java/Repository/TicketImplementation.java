package Repository;

import Model.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketImplementation implements CRUDRepository <Ticket>{

    List <Ticket> listOfTickets = new ArrayList<Ticket>();

    @Override
    public void save(Ticket object) {
        listOfTickets.add(object);

    }

    @Override
    public void showScreen() {
        for (Ticket ticket : listOfTickets){
            System.out.println(ticket.toString());
        }
    }

    @Override
    public Optional<Ticket> loockFor(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Ticket> getAll() {
        return listOfTickets;
    }

    @Override
    public String toString() {
        return "TicketImplementation{" +
                "listOfTickets=" + listOfTickets +
                '}';
    }
}
