package primeraevaluacion;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Ernest Serna
 */
public class PrimeraEvaluacion {

    
    
    public static class Ejercicio1 {
        public static int[] divisores(int numero) {
            int[] listaDivisores = new int[15];
            int div = numero, pos = 0;
            while (div >= 1) {
                if (numero % div == 0) {
                    listaDivisores[pos++] = div;
                }
                div--;
            }
            return listaDivisores;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int num;
        
        System.out.println("Dime el número");
        num = sc.nextInt();
        
        int [] todosDivisores = Ejercicio1.divisores(num);
        System.out.println("Lista de divisores" + Arrays.toString(todosDivisores));
    }

}
