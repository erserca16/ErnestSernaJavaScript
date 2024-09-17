/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programacion2curso;
import java.util.Scanner;
/**
 *
 * @author ERNEST-PC
 */
public class EscribirLetralosNumeros {
    public static void main(String[] args) {
        
    System.out.println("Escriba un número (1 al 99):");
        int num = new Scanner(System.in).nextInt();

        switch (num) {
            case 11 -> System.out.println("Once");
            case 12 -> System.out.println("Doce");
            case 13 -> System.out.println("Trece");
            case 14 -> System.out.println("Catorce");
            case 15 -> System.out.println("Quince");
            case 16 -> System.out.println("Dieciséis");
            case 17 -> System.out.println("Diecisiete");
            case 18 -> System.out.println("Dieciocho");
            case 19 -> System.out.println("Diecinueve");
            case 21 -> System.out.println("Veintiuno");
            case 22 -> System.out.println("Veintidós");
            case 23 -> System.out.println("Veintitrés");
            case 24 -> System.out.println("Veinticuatro");
            case 25 -> System.out.println("Veinticinco");
            case 26 -> System.out.println("Veintiséis");
            case 27 -> System.out.println("Veintisiete");
            case 28 -> System.out.println("Veintiocho");
            case 29 -> System.out.println("Veintinueve");
            default -> {  
                int unidades = num % 10;
                int decenas = num / 10;
                switch (decenas) {
                    case 1 -> System.out.print("Diez");
                    case 2 -> System.out.print("Veinte");
                    case 3 -> System.out.print("Treinta");
                    case 4 -> System.out.print("Cuarenta");
                    case 5 -> System.out.print("Cincuenta");
                    case 6 -> System.out.print("Sesenta");
                    case 7 -> System.out.print("Setenta");
                    case 8 -> System.out.print("Ochenta");
                    case 9 -> System.out.print("Noventa");
                }
                if (decenas >= 3 && unidades != 0) {
                    System.out.print(" y ");
                }
                switch (unidades) {
                    case 0 -> System.out.println("");
                    case 1 -> System.out.println("uno");
                    case 2 -> System.out.println("dos");
                    case 3 -> System.out.println("tres");
                    case 4 -> System.out.println("cuatro");
                    case 5 -> System.out.println("cinco");
                    case 6 -> System.out.println("seis");
                    case 7 -> System.out.println("siete");
                    case 8 -> System.out.println("ocho");
                    case 9 -> System.out.println("nueve");
                }
            }
        }

    }
}
