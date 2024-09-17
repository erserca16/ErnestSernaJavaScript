package prueba;

/**
 * @author Ernest Serna
 */
public class ejemplosDeCreacionDeArrays {

    public static void main(String[] args) {
        // Declaración y creación de un array de enteros con longitud 10
        int[] edades = new int[10];

        // Mostrar la longitud del array usando el atributo length
        System.out.println("La longitud del array 'edades' es: " + edades.length);

        // También puedes declarar el array con los corchetes detrás del nombre
        int edadesOtro[] = new int[15];

        // Mostrar la longitud del otro array usando el atributo length
        System.out.println("La longitud del array 'edadesOtro' es: " + edadesOtro.length);
    }

    public static void crearArrays() {
        int a[], b[], c[];
        // LA VARIABLE A NO TIENE NINGUNA TABLA REFERENCIADA
        b = new int[4];
        c = new int[5];
        // new int[3]; ESTE ES INACCESIBLE PORQUE NO PUEDE ACCEDER PORQUE NO TIENE NINGUNA VARIABLE REFERENCIANDO ESTE ARRAY
        
    }
}
