package EjerciciosLibroUnidad9;

import java.util.ArrayList;
import java.util.Collections;
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
        List<Futbolista> lista = new ArrayList<>();
       Futbolista jugador1 = new Futbolista (123456789," Cristiano Ronaldo",36,50);
       Futbolista jugador2 = new Futbolista (789456454," Leo Messi",34,45);
       Futbolista jugador3 = new Futbolista (789456143," Karim Benzema",33,40);
       Futbolista jugador4 = new Futbolista (456123848," Iker Casillas",39,1);       
       Futbolista jugador5 = new Futbolista (154567040," Zidedine Zidane",50,20);
       lista.add(jugador1);
       lista.add(jugador2);
       lista.add(jugador3);
       lista.add(jugador4);
       lista.add(jugador5);
       Collections.sort(lista);
         System.out.println("Lista ordenada por DNI \n" + lista);
         Collections.sort(lista, new OrdenNombre());
         System.out.println("Lista ordenada alfabéticamente \n" + lista);
         Collections.sort(lista, new OrdenEdad());
         System.out.println("Lista ordenada por edad \n" + lista);
    }
}
