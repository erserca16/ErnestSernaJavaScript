package EjerciciosLibroUnidad9;

import java.util.Comparator;

/**
 *
 * @author Ernest Serna
 */
public class OrdenNombre implements Comparator<Futbolista> {

    @Override
    public int compare(Futbolista o1, Futbolista o2) {
        if (o1.getNombre().compareTo(o2.getNombre()) < 0 )
            return -1;
        else if (o1.getNombre().compareTo(o2.getNombre()) < 0 )
            return 1;
        
        return 0;
    }

}
