
package com.mycompany.primerospasos;

public class Manipula_cadenas {

    public static void main(String[] args) {
        String nombre = "Ernest";
        
        System.out.println("Mi nombre es : " + nombre);
        
        System.out.println("Mi nombre tiene : " + nombre.length() + " letras");
        
        System.out.println("La primera letra de " + nombre + " es : " + nombre.charAt(0));        
        
        System.out.println("La quinta letra de " + nombre + " es : " + nombre.charAt(4)); 
        
        int ultima_letra = nombre.length();
        
        System.out.println("Y la última letra de " + nombre + "es : " + nombre.charAt(ultima_letra-1));
    }
}
