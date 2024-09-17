/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.pruebas_examen3ev;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author ERNEST-PC
 */
public class PRuebas_examen3ev {
//

    public static void main(String[] args) throws IOException {
        writeToFile();
        readToFile();
        writeConCondicion();
//        
//        List<String> lista = Arrays.asList("a","b");
//        Stream<String> stream = lista.stream();
//        
//        
//    }
//    public static void metodoof(){
//        Stream<String> stream = Stream.of("a","b");
//        String [] vector = new String[10];
//        Stream<String> prueba = Stream.of(vector);
//    }
//    public static void antiguedad(){
//        Stream<Socios> listadoAntiguedad = lista.Stream()
//                .sorted((a,b) -> Integer.compare(a.antiguedad(), b.antiguedad()));
    }

    public static void writeToFile() {
        Path fichero = Paths.get("fichero.txt");
        try (BufferedWriter out = Files.newBufferedWriter(fichero)) {
            out.write("linea1 \t HOla\n\n");
            out.newLine();
            out.write("linea2 \t Hola doble\n\n");
            out.newLine();
            out.write("linea3 \t PRUEBO TERCERA linea\n\n");
            out.newLine();
            System.out.println("ARCHIVO CREADO CON ÉXITO \n " + "REVISA EN EL DIRECTORIO DE ESTE PROYECTO");
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero");
        }

    }

    public static void readToFile() throws IOException {
        Path archivo = Paths.get("archivo.txt");
        Stream<String> datos = Files.lines(archivo,Charset.defaultCharset());
        for (String linea : datos.toList()) {
            System.out.println(linea);
        }
    }

    public static void writeConCondicion() throws IOException {
        Scanner in = new Scanner(System.in);
        Path fichero1 = Paths.get("fichero1.txt");
        try (BufferedWriter out = Files.newBufferedWriter(fichero1)) {
            System.out.println("Introduce texto y escribe 'fin' para acabar");
            //TODO ESTO QUE ESTÁ COMENTADO ES LO MISMO PERO CON EL BUCLE DO-WHILE QUE LO QUE HACE
            //ES COMPROBAR EL BUCLE UNA VEZ HA DADO UNA PASADA AL BUCLE
//            String cad;
//            do {
//                cad = in.nextLine();
//                if (!cad.equals("fin")) {
//                    out.write(cad);
//                    out.newLine();
//                }
//            } while (!cad.equals("fin"));
//
//        } catch (Exception e) {
//            System.out.println("Error");
            //CON EL BUCLE WHILE, QUE LO QUE HACE ES MIRAR LA CONDICIÓN ANTES DE ENTRAR AL BUCLE
            String cad = in.nextLine();
            while (!cad.equals("fin")) {
                out.write(cad);
                out.newLine();
                cad = in.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
