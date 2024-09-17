package Bucles;

import java.util.Scanner;

public class Ejercicio2BuclesAules {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double capital;

        double ganancias = 0;

        System.out.println("¿ Cuanto dinero quieres ingresar?");

        double capitalInicial = sc.nextDouble();

        System.out.println("¿ Cuanto tiempo?");

        int tiempo = sc.nextInt();

        System.out.println("¿ Cuanto interes expresado en %  ?");

        final double INTERES = sc.nextDouble();

        capital = capitalInicial;

        for (int anyo = 1; anyo <= tiempo; anyo++) {

            ganancias = (capital * INTERES / 100);

            capital += ganancias;    //capital = capital + ganancias         

            System.out.printf("Año %d capital %.2f intereses %.2f€\n", anyo, capital, ganancias);

        }

        System.out.printf("Tras %d años tu capital sera %.2f€ \n", tiempo, capital);

        System.out.printf("Intereses conseguidos %.2f€ \n ", (capital - capitalInicial));
    }
}
