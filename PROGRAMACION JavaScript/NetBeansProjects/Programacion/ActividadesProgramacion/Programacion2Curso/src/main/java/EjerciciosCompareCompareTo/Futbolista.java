package EjerciciosCompareCompareTo;


/**
 * @author Ernest Serna
 */
public class Futbolista {

   private int dni;
   private String nombre;
   private int edad;
   private int num_goles;

    public Futbolista(int dni, String nombre, int edad, int num_goles) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.num_goles = num_goles;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getNum_goles() {
        return num_goles;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNum_goles(int num_goles) {
        this.num_goles = num_goles;
    }

    @Override
    public String toString() {
        return "Futbolista{" + "dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + ", num_goles=" + num_goles + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Futbolista other = (Futbolista) obj;
        return this.dni == other.dni;
    }

    
   

}
