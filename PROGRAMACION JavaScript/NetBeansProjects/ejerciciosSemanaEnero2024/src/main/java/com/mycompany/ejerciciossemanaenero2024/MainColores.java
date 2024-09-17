package com.mycompany.ejerciciossemanaenero2024;

import java.util.Arrays;

/**
 * @author Ernest Serna
 */
public class MainColores {

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
      
      System.out.println(Arrays.toString(colores.seleccionColores(9)));
   }

}
