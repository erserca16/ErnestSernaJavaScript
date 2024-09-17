package habitacion;

/**
 *
 * @author Ernest Serna
 */
public class Reserva {

    private String localizador;
    private final String nif;
    private Habitacion habitacion_reservada;
    private int dias_estancia;
    private static int contadorReservas = 1;

    public Reserva(String nif, Habitacion habitacion_reservada, int dias_estancia) {
        this.nif = nif;
        this.habitacion_reservada = habitacion_reservada;
        this.dias_estancia = dias_estancia;
        generarLocalizador();
    }

    
    private void generarLocalizador(){
        String tresPrimerosCaracteresNif = nif.substring(0, 3);
        localizador = tresPrimerosCaracteresNif + "-" + String.format("%03d", contadorReservas);
        contadorReservas++;
    }

    public String getLocalizador() {
        return localizador;
    }

    public void setLocalizador(String localizador) {
        this.localizador = localizador;
    }

    public String getNif() {
        return nif;
    }

    public Habitacion getHabitacion_reservada() {
        return habitacion_reservada;
    }

    public void setHabitacion_reservada(Habitacion habitacion_reservada) {
        this.habitacion_reservada = habitacion_reservada;
    }

 
    public int getDias_estancia() {
        return dias_estancia;
    }

    public void setDias_estancia(int dias_estancia) {
        this.dias_estancia = dias_estancia;
    }

    public static int getContadorReservas() {
        return contadorReservas;
    }

    public static void setContadorReservas(int contadorReservas) {
        Reserva.contadorReservas = contadorReservas;
    }

    @Override
    public String toString() {
        return "Datos de la reserva:\n" + habitacion_reservada.toString() + "\n" + "Días de estancia: " + dias_estancia;
    }

}
