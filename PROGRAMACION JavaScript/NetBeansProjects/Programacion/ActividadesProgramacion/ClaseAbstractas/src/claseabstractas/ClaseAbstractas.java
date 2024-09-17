package claseabstractas;

/**
 * @author Ernest Serna
 */
public class ClaseAbstractas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Cuadrado cuadrado = new Cuadrado (10,20,80);
//        double areaCuadrado = cuadrado.calcularArea();
//        System.out.println("El area del cuadrado es "+areaCuadrado);
//        
//        Circulo circulo = new Circulo (10,10,10);
//        double areaCirculo = circulo.calcularArea();
//        System.out.println("El area del circulo es "+areaCirculo);
          
        Cuadrado cuadrado = new Cuadrado(20);
        double areaCuadrado = cuadrado.calcularArea();
        System.out.println("El area del cuadrado es " + areaCuadrado);
        cuadrado.dibujar();
        
        Circulo circulo = new Circulo(10);
        double areaCirculo = circulo.calcularArea();
        System.out.println("El area del circulo es " + areaCirculo);
        circulo.dibujar();
        circulo.rotar();
    }

}
