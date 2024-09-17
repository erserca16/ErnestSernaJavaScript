package figuras;

/**
 *
 * @author ERNEST-PC
 */
public class Circulo {

    double radio;

    public Circulo() {
    }

    public Circulo(double rad) {
        radio = rad;
    }

    public double area() {
        return Math.PI * radio * radio;
    }

    public double perimetro() {
        double perimetro = 2 * Math.PI * radio;
        return perimetro;
    }

    public double diametro() {
        double diametro = 2 * radio;
        return diametro;
    }

    public double areaSector(double angulo) {

        return (angulo / 360) * area();
        //double area = Math.PI * (Math.pow(radio, radio));
        //return area;
    }

}
