package EjerciciosLibro;


import java.util.Scanner;

public class ejercicio3punto14 {

    public static void main(String[] args) {
        System.out.println("Escriba el número tope:");
        int hasta = new Scanner(System.in).nextInt();

        System.out.println("1 -> primo");
        int contadorPrimos=1;
        for (int numero = 2; numero <= hasta; numero++) {
            boolean esPrimo = true;
            int posibleDivisor = 2;
            while (posibleDivisor < numero && esPrimo) {
                if (numero % posibleDivisor == 0) {
                    esPrimo = false;  // si encontramos un divisor, paramos de buscar
                }
                posibleDivisor++;
            }
            System.out.print(numero + " -> ");
            if (esPrimo) {
                System.out.println("primo");
                contadorPrimos++;
            } else {
                System.out.println("no primo");
            }
        }
        System.out.println("El total de primos es " + contadorPrimos);
    }
}
