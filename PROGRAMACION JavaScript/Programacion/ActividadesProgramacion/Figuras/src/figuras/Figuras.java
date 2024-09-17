package figuras;

import java.util.Scanner;

/**
 * @author ERNEST-PC
 */

public class Figuras {

    public static void main(String[] args) {
        Circulo circle10 = new Circulo();
        Circulo circle20 = new Circulo(20);
        circle10.radio = 10;

        System.out.println("El area es;");
        System.out.println(circle10.area());        
        System.out.println("El perimetro es");
        System.out.println(circle10.perimetro());
        System.out.println("El diametro es");
        System.out.println(circle10.diametro());
        System.out.println("Cuanto quieres que sea el angulo?");
         double angulo = new Scanner(System.in).nextDouble();         
        System.out.println("El angulo es");
        System.out.println(circle10.areaSector(angulo));
        
        System.out.println("");
        System.out.println("");
        
        
        System.out.println("El area es;");
        System.out.println(circle20.area());
        System.out.println("El perimetro es");
        System.out.println(circle20.perimetro());
        System.out.println("El diametro es");
        System.out.println(circle20.diametro());
        System.out.println("El angulo es");
        System.out.println(circle20.areaSector(angulo));
        
        System.out.println();

    }

}
