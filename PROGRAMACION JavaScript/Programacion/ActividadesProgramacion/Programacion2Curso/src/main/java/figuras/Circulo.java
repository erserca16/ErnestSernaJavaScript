/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuras;

/**
 *
 * @author ERNEST-PC
 */
public class Circulo {

    double radio;

    public double area() {
        return Math.PI * radio * radio;
    }

    public double diametro() {
        double diametro = 2 * Math.PI * radio;
        return diametro;
    }

}
