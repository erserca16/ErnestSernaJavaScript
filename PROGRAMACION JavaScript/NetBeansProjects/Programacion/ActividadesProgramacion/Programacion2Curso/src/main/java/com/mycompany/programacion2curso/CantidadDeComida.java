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
public class CantidadDeComida {
    public static void main(String[] args) {
        
    
      System.out.println("Cantidad de comida:");
      double cantidadComida = new Scanner(System.in).nextDouble();
      System.out.println("Número de animales:");
      int numAnimales = new Scanner(System.in).nextInt();
      System.out.println("Kilos por animal:");
      double kilosPorAnimal = new Scanner(System.in).nextDouble();
      
      
      if (cantidadComida >= (numAnimales*kilosPorAnimal) ) {
         System.out.println("Hay suficiente comida");
      } else {
         System.out.println("No hay suficiente comida.");
         
         if (numAnimales == 0) {
            System.out.println("Hay 0 animales en la granja");
         } else {
            double racion = cantidadComida / numAnimales;
            System.out.println("La ración por animal es: " + racion);
         }
      }
}
}