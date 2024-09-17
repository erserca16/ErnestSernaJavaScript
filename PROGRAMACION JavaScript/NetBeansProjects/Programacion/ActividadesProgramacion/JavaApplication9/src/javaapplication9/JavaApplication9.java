/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication9;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ERNEST-PC
 */
public class JavaApplication9 {
public static void main(String[] args) {
        // Nombre y apellidos
        String nombre = "Ernest";
        String apellido = "Serna Cabañero";

        // Ruta del directorio y nombre del archivo
        String directorioPath = "examen";
        String archivoPath = directorioPath + "/examen.txt";

        // Crear el directorio
        File directorio = new File(directorioPath);
        if (!directorio.exists()) {
            directorio.mkdir();
        }

        // Escribir en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoPath))) {
            for (int i = 1; i <= 10; i++) {
                // Escribir en el archivo
                writer.write("Linea " + i + " " + nombre + " " + apellido);
                
                // Saltar a la línea siguiente
                writer.newLine();
            }

            System.out.println("Archivo creado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Mostrar los archivos en el directorio
        System.out.println("Archivos en el directorio 'examen':");
        File[] archivosEnDirectorio = directorio.listFiles();
        if (archivosEnDirectorio != null) {
            for (File archivo : archivosEnDirectorio) {
                System.out.println(archivo.getName());
            }
        } else {
            System.out.println("El directorio está vacío.");
        }
        // Escribir en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoPath))) {
            for (int i = 1; i <= 10; i++) {
                // Escribir en el archivo
                String linea = nombre + " " + apellido + " - Linea " + i;
                writer.write(linea);
                
                // Saltar a la línea siguiente
                writer.newLine();

                // Mostrar la línea por consola
                System.out.println(linea);
            }

            System.out.println("Archivo creado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}