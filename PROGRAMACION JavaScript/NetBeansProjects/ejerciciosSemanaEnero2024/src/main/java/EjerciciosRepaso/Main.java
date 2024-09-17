package EjerciciosRepaso;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ernest Serna
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String texto = "ChristianoRonaldo:futbol:delantero#Casillas:futbol:portero#PauGasol:baloncesto:pivot";

        // Parsear el texto y crear objetos Jugador
        List<Futbolista> futbolistas = new ArrayList<>();
        String[] partes = texto.split("#");
        for (String parte : partes) {
            String[] datos = parte.split(":");
            if (datos.length == 3) {
                String nombre = datos[0];
                String deporte = datos[1];
                String posicion = datos[2];
                Futbolista futbolista = new Futbolista(nombre, deporte, posicion);
                futbolistas.add(futbolista);
            }
        }
        // Recorrer la lista de jugadores e imprimir la información
        for (Futbolista jugador : futbolistas) {
            System.out.println(jugador);
        }
    }
}
