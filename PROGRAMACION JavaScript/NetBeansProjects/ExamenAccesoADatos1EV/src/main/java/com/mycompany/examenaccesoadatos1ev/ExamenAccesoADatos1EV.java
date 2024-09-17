package com.mycompany.examenaccesoadatos1ev;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExamenAccesoADatos1EV {

    public static String[] list() {
        String directorioPath = "C:\\Users\\Ernest\\Documents\\NetBeansProjects\\ExamenAccesoADatos1EV\\examen";
        File directorio = new File(directorioPath);

        File[] archivosEnDirectorio = directorio.listFiles();
        if (archivosEnDirectorio != null) {
            String[] nombresArchivos = new String[archivosEnDirectorio.length];
            for (int i = 0; i < archivosEnDirectorio.length; i++) {
                nombresArchivos[i] = archivosEnDirectorio[i].getName();
            }
            return nombresArchivos;
        } else {
            return new String[]{"El directorio está vacío."};
        }
    }

    public static void main(String[] args) {
        String directorioPath = "examen";
        String archivoPath = directorioPath + "/examen.txt";
        String nombre = "Ernest";
        String apellido = "Serna Cabañero";

        File directorio = new File(directorioPath);
        if (!directorio.exists()) {
            directorio.mkdir();
        }

        String[] archivosEnDirectorio = list();

        System.out.println("Archivos en el directorio 'examen':");
        for (String nombreArchivo : archivosEnDirectorio) {
            System.out.println(nombreArchivo);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoPath))) {
            for (int i = 1; i <= 10; i++) {
                // Escribir en el archivo
                String linea = nombre + " " + apellido + " " + i;
                writer.write(linea);

                writer.newLine();

            }

            System.out.println("Archivo creado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
