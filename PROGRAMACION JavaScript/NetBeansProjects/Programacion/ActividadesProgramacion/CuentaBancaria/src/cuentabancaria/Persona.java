package CuentaBancaria;

public class Persona {

    private String nif;
    private String nombre;

    public Persona(String nif, String nombre) {
        this.nif = nif;
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean igual(Persona otraPersona) {
        return (nif.equalsIgnoreCase(otraPersona.getNif()));
    }

    public boolean igual(String nif) {
        return (this.nif.equalsIgnoreCase(nif));
    }

    @Override
    public String toString() {
        return this.nombre + "[" + this.nif + "]";
    }
}
