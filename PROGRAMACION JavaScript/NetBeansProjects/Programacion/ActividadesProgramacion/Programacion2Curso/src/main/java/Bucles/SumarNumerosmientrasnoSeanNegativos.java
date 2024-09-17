package Bucles;

import java.util.Scanner;

public class SumarNumerosmientrasnoSeanNegativos {

    public static void main(String[] args) {

        int suma = 0, numero;

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un número:");

        numero = Integer.parseInt(sc.next());

        while (numero >= 0) {

            suma = suma + numero;

            System.out.println("introduce numero");

            numero = Integer.parseInt(sc.next());

        }

        System.out.println("La suma es :" + suma);
    }
}
