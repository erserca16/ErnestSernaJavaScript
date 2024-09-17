package habitacion;

/**
 * @author Ernest Serna
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Habitacion habitacion1 = new Habitacion (10,"duplex",50);
       Reserva reserva = new Reserva("12345678J",Habitacion,6);
    }

}
