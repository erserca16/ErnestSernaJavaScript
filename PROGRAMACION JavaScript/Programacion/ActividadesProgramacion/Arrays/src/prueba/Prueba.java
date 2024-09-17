package prueba;

import java.util.Scanner;

/**
 * @author Ernest Serna
 */
public class Prueba {
   

    public static void Sumar(int a, int b){
        int c;
        c=a+b;
        System.out.println("La suma total es " +c);
    }
    public static int Restar(int a, int b){
        int c;
        c=a-b;
        return c;
    }
    public static void Sumar(){
        int c;
        int a = 10;
        int b = 50;
        c=a+b;
        System.out.println("SUMA SIN PARÁMETROS ES "+c);
    }
    public static void Sumar(String a, String b){
        String c;
        c=a+b;
        System.out.println("SUMA DE STRINGS ES " +c);
    }
     public static void Sumar(Scanner scanner){
        System.out.println("Ingrese el primer string:");
        String a = scanner.nextLine();
        System.out.println("Ingrese el segundo string:");
        String b = scanner.nextLine();
        Sumar(a,b);
        System.out.println("La suma de scanner es: ");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sumar(10, 10);
        Sumar();
        Sumar("hola ","Adios");
        Sumar(scanner);
        int resta= Restar(10, 9);
        System.out.println("El resultado de restar es " +resta);
    }

}
