package com.mycompany.programacion2curso;

import java.util.Arrays;

/**
 * @author Ernest Serna
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Colores colores = new Colores();
      colores.addColor("Marrón");
      colores.addColor("Azul");
      colores.addColor("Amarillo");
      colores.addColor("Celeste");
      colores.addColor("Rosa");
      
      System.out.println(Arrays.toString(colores.seleccionColores(3)));
   }

}
