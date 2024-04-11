import org.example.banco.clients.Basic;
import org.example.banco.clients.DebtCollertor;
import org.example.banco.clients.Executive;

public class Main {

    public static void main(String[] args) {
        Basic clientBasic = new Basic();
        Executive ejecutivo = new Executive();
        DebtCollertor cobrador = new DebtCollertor();

        clientBasic.checkBalance();
    }
}
