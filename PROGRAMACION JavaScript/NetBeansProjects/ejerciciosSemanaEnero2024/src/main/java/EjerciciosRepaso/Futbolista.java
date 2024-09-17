package EjerciciosRepaso;

/**
 *
 * @author Ernest Serna
 */
public class Futbolista {

    String nombre;
    String deporte;
    String posicion;

    String textoAtrozear[];

    public Futbolista() {
        trozear();
    }

    public Futbolista(String nombre, String deporte, String posicion) {
        this.nombre = nombre;
        this.deporte = deporte;
        this.posicion = posicion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDeporte() {
        return deporte;
    }

    public String getPosicion() {
        return posicion;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Deporte: " + deporte + ", Posición: " + posicion;
    }

    private void trozear() {
        for (String jugador : textoAtrozear) {
            String[] datosSeparados = jugador.split("#");
        }
    }
}
