package ejercicios7Clases;

public class Main {
    public static void main(String[] args) {
        Circulo miCirculo = new Circulo(5.0);

        double radioDelCirculo = miCirculo.getRadio();
        System.out.println("Radio del círculo: " + radioDelCirculo);

        double areaDelCirculo = miCirculo.calcularArea();
        System.out.println("Área del círculo: " + areaDelCirculo);
    }
}
