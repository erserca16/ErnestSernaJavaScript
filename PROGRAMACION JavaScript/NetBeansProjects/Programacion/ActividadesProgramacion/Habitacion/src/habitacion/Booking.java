package habitacion;

import java.util.List;

public class Booking implements Busquedas {

    private Reserva[] reservas = new Reserva[MAXRESERVAS];
    private final int MAXRESERVAS = 500;

    @Override
    public List<Reserva> reservasXhabitacion(int numeroHabitacion) {
        Reserva[] reservasHabitacion = new Reserva[MAXRESERVAS];
        int contador = 0;
        for (int i = 0; i < numReservas; i++) {
            if (reservas[i].getHabitacion().getNumero() == numeroHabitacion) {
                reservasHabitacion[contador] = reservas[i];
                contador++
            }
        }

    }
