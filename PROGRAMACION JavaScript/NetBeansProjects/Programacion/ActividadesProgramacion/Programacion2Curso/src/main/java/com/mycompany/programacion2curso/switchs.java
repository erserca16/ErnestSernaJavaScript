package com.mycompany.programacion2curso;

/**
 *
 * @author ERNEST-PC
 */
public class switchs {
    public static void main(String[] args) {
    String diaSemana= "Sábado";
        int dia=0;

        switch (diaSemana) {
            case "Lunes" ->
                dia = 1;
            case "Martes" ->
                dia = 2;
            case "Miercoles" ->
                dia = 3;
             case "Jueves" ->
                dia = 4;
             case "Viernes" ->
                dia = 5;
             case "Sábado" ->
                dia = 6;
             case "Domingo" ->
                dia = 7;
            default ->
                System.out.println("DIA INCORRECTO");
        }
        System.out.println( diaSemana + " es " + dia );
}
}