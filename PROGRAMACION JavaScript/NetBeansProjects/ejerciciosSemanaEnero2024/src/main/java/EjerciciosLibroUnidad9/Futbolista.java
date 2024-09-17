package EjerciciosLibroUnidad9;

/**
 *
 * @author Ernest Serna
 */
public class Futbolista implements Comparable<Futbolista> {
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
    public int compareTo (Futbolista otro){
        int comparacion = 0;
        if (this.dni < otro.getDni())
            comparacion = -1;
        else if (this.dni > otro.getDni())
            comparacion = 1;
        return comparacion;
    }
    

    @Override
    public String toString() {
        return "Futbolista con " +  "dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + ", num_goles=" + num_goles + "\n";
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


//PARA HACER EL ORDEN DE LA LISTA AL REVÉS HE DE MULTIPLICAR POR -1 
//EJEMPLO retunr -1 * ((codigo que sea)) ;

//PRIVATE LOS ATRIBUTOS Y PONERLE LOS GETTERS Y SETTERS
//String texto "sduhfsdfhsdfois#osudhsodifhsdoifihsdoi#isudhgifjoirghero#ushdfoudsfhsdouh";
//texto.split(#) le estmaos diciendo que nos serpara la variable texto donde se almacenan los nombres y que corta donde esta el #