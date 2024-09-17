package herencias;

/**
 * @author Ernest Serna
 */
public class Herencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Empleado emple = new Empleado();
//        emple.getNombre();
//        emple.getNum_legajo();
//        
//        Consultor consul = new Consultor();
//        consul.getNombre();
//        consul.getNombre_consultora();


        Persona vector [] = new Persona [5];
        vector[0] = new Persona();
        vector[1] = new Empleado();
        vector[2] = new Consultor();
        vector[3] = new Jefe();
        
    }

}
