package figuras;

/**
 *
 * @author ERNEST-PC
 */
public class Figuras {

    
    public static void main(String[] args) {
       Circulo circle = new Circulo ();
       circle.radio=5;
       
        System.out.println(circle.area());
        System.out.println(circle.diametro());
       
    }
    
}
