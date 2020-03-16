package ec.edu.espe.src;

/**
 *
 * @author Familia Lasso Ayala
 */
public class Tarjeta {
    
    private int credito;
    private int tickets;
    private int numTarjeta;

    public Tarjeta() {
    }

    public Tarjeta(int credito, int tickets, int numTarjeta) {
        this.credito = credito;
        this.tickets = tickets;
        this.numTarjeta = numTarjeta;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public int getNumTarjeta() {
        return numTarjeta;
    }


    
    
    
}
