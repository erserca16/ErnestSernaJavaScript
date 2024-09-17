package EjerciciosLibroUnidad9;

import java.util.Comparator;

/**
 *
 * @author Ernest Serna
 */
public class OrdenEdad implements Comparator<Futbolista> {

    @Override
    public int compare(Futbolista o1, Futbolista o2) {
        if (o1.getEdad() < o2.getEdad())
            return -1;
        else if (o1.getEdad() > o2.getEdad())
            return 1;
        else if (o1.getEdad() == o2.getEdad())
            return (o1.getNombre().compareTo(o2.getNombre()));
        return 0;
    }
}
