package claseabstractas;

/**
 *
 * @author Ernest Serna
 */
public interface Figura {   
    
    
        
    public double calcularArea(); // puedo dejar el public abstract o dejarlo así, porque al ser interfaz si o si es abstract
}




//ANTES CUANDO ERA CLASE ABSTRACTA Y NO INTERFAZ ERA DE LA SIGUIENTE MANERA
//DE IGUAL FORMA LAS CLASES CUADRADO Y CIRCULO EXTENDIAN ESTA CLASE Y AHORA CON LA INTERFAZ LA IMPLEMENTAN, TB ELIMINÉ PARÁMETROS, VIDEO DE TODOCODE

//package claseabstractas;
//
///**
// *
// * @author Ernest Serna
// */
//public abstract class Figura {
//    
//    protected double x; // pos en x
//    protected double y; // pos en y
//
//    protected Figura(double x, double y) { //ojo que no es PUBLIC, es protected
//        this.x = x;
//        this.y = y;
//    }
//
//    protected Figura() {
//    }
//    
//        
//    public abstract double calcularArea();
//}
