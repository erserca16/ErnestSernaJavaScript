/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programacion2curso;
import java.util.Locale;
import java.util.Scanner;
/**
 *
 * @author ERNEST-PC
 */
public class areaTriangulo {
    public static void main(String[] args) {
        
    System.out.println("Escriba la base:");
      double base = new Scanner(System.in).useLocale(Locale.US).nextDouble();
      System.out.println("Y la altura:");
      double altura = new Scanner(System.in).useLocale(Locale.US).nextDouble();
      
      if (base < 0 || altura < 0) {
         System.out.println("La base y la altura deben ser positivas.");
      } else {
         double area = (base*altura)/2;
         System.out.println("El área del triángulo es: " + area);
      }
    }
}
