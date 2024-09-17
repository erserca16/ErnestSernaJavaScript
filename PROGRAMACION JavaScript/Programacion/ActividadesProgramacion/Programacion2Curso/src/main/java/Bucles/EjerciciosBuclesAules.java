package Bucles;

import java.util.Scanner;

public class EjerciciosBuclesAules {

    public static void main(String[] args) {

        int numero;

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número:");
        numero = Integer.parseInt(sc.next());

        for (int fila = 1; fila <= numero; fila++) { //GENERA FILAS    

            for (int j = 1; j <= fila; j++) {  // GENERA ELEMENTOS DE CADA FILA   
                System.out.print(j + " "); // Imprime el número seguido de un espacio
            }
            System.out.println(); // Salto de línea para pasar a la siguiente fila
        }
    }

}
