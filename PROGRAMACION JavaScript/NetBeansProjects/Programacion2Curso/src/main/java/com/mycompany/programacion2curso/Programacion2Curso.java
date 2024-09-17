

package com.mycompany.programacion2curso;
import java.util.Scanner;

/**
 *
 * @author ERNEST-PC
 */
public class Programacion2Curso {

    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserte nota exámen: ");

        int nota = sc.nextInt();

        System.out.println("¿El trabajo ha sido entregado?");

        boolean entregaTrabajo = sc.nextBoolean();

        

        if (nota >= 5 && nota <= 10 && entregaTrabajo==true) {

            System.out.println("APROBADO");

        } else {

            System.out.println("SUSPENDIDO");

        }
    }
}
