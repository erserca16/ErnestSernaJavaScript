package com.mycompany.empleadosdao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Set;


public class EmpleadoTofile {
  public static void writeToFile(Set<Empleado> empleados, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            for (Empleado empleado : empleados) {
                String line = String.format("%d, %s, %d, %d, %s, %s",
                        empleado.getNumemp(),
                        empleado.getNombre(),
                        empleado.getEdad(),
                        empleado.getOficina(),
                        empleado.getPuesto(),
                        dateFormat.format(empleado.getContrato())
                );
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
