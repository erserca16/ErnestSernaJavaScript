package herencias;

/**
 *
 * @author Ernest Serna
 */
public class Jefe extends Persona{
   int id_jefe;
   String departamenteo_jefe;

    public Jefe() {
    }

    public Jefe(int id_jefe, String departamenteo_jefe, int id, String dni, String nombre, String apellido, String domicilio, String telefono) {
        super(id, dni, nombre, apellido, domicilio, telefono);
        this.id_jefe = id_jefe;
        this.departamenteo_jefe = departamenteo_jefe;
    }

    public int getId_jefe() {
        return id_jefe;
    }

    public void setId_jefe(int id_jefe) {
        this.id_jefe = id_jefe;
    }

    public String getDepartamenteo_jefe() {
        return departamenteo_jefe;
    }

    public void setDepartamenteo_jefe(String departamenteo_jefe) {
        this.departamenteo_jefe = departamenteo_jefe;
    }
   
   
   
   
}
