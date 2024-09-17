package habitacion;

/**
 * @author Ernest Serna
 */
public class Habitacion {

    private int numero;
    private String tipo;
    private double precioXdia = 50;

    public Habitacion(int numero, String tipo, int precio) {
        this.numero = numero;
        this.tipo = tipo;
        this.precioXdia = precio;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precioXdia;
    }

    public void setPrecio(double precio) {
        this.precioXdia = precio;
    }

    @Override
    public String toString() {
        return "habitacion: " + numero + "(" + getPrecio() + "€\\dia)";
    }
}
