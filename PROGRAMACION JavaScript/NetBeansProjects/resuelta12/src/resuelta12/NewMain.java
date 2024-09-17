package resuelta12;

import java.util.ArrayList;
import static java.util.Arrays.sort;
import static java.util.Collections.sort;
import java.util.Scanner;

/**
 * @author Ernest Serna
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        // TODO code application logic here
        ArrayList<String> amigos = new ArrayList<>();
        amigos.add("Jorge");
        amigos.add("Alvarito");
        amigos.add("Sergi");
        amigos.add("Raul");
        amigos.add("Roberto");

        amigos.sort(null);
        System.out.println(amigos);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un amigo más:");
        String amigoNuevo = scanner.nextLine();

        amigos.add(amigoNuevo);
        amigos.sort(null);
//        System.out.println(amigos);
        int contador = 1;
        for (String nombre : amigos) {

            System.out.println(contador + "." + nombre);
            contador++;
        }
        System.out.println("");
        System.out.println("");
        char letra = 'a';
        for (String nombre : amigos) {

            System.out.println(letra + "." + nombre);
            letra++;
        }
    }
}


