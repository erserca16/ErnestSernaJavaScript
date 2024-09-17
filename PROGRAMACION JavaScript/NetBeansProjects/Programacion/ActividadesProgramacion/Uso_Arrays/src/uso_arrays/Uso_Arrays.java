package uso_arrays;

/**
 * @author Ernest Serna
 */
public class Uso_Arrays {

    public static void main(String[] args) {

        /*int[] mi_matriz = new int[5]; //Declaración por separado
        mi_matriz[0] = 5; //Iniciación por separado
        mi_matriz[1] = 38;
        mi_matriz[2] = 87;
        mi_matriz[3] = 65;
        mi_matriz[4] = 59;*/

        //System.out.println(mi_matriz[0]); // como imprimir una a una
        
        int [] mi_matriz={5,78,98,58,54}; // aquí estamos iniciado e inicializando a la vez
        
        
        
        for(int i=0;i<5;i++){ // en este bucle si supiese o quisiera marcarle el punto final de hasta donde puede llegar.
            System.out.println("Valor del indice" + i + "=" +mi_matriz[i]);
        }
        for (int i = 0; i < mi_matriz.length; i++) { //este bucle si no sabemos la longitud del búcle
            System.out.println("Valor del índice " + i + " = " + mi_matriz[i]);
        }
    }

}
