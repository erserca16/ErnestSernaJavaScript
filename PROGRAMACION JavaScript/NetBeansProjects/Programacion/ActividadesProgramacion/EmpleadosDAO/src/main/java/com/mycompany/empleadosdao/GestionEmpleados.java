package com.mycompany.empleadosdao;

import java.util.Scanner;
import java.util.Set;
import java.util.*;
import java.io.*;
import java.time.LocalDate;

/**
 * @author Ernest Serna
 */
public class GestionEmpleados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Menu gestión empleados");
            System.out.println("Selecciona una opción");
            System.out.println("1. Crear empleado");
            System.out.println("2. Leer empleado");
            System.out.println("3. Actualizar empleado");
            System.out.println("4. Eliminar empelado");
            System.out.println("5. Leer todos los empleados");
            System.out.println("6. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (opcion) {
                case 1:
                    crearEmpleado(scanner); //mirar la solución porque aquí he de crear el método fuera del main pero en esta clase
                //para poder leerlo aqui, mirar la solcuión de raquel que está muy bien explicado
                case 2:
                    leerEmpleado(scanner);
                    break;
                case 3:
                    actualizarEmpleado(scanner);
                    break;
                case 4:
                    eliminarEmpleado(scanner);
                    break;
                case 5:
                    EmpleadoDAO.readAll();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);

        scanner.close();
    }

    //Set<Empleado> empleados = EmpleadoDAO.readAll(); // Supongamos que este método obtiene todos los empleados
    //EmpleadoTofile.writeToFile(empleados, "empleados.txt");
    private static void crearEmpleado(Scanner scanner) {
        System.out.print("Número de Empleado: ");
        int numemp = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        System.out.print("Oficina: ");
        int oficina = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        System.out.print("Puesto: ");
        String puesto = scanner.nextLine();
        System.out.print("Fecha de Contrato (AAAA-MM-DD): ");
        LocalDate contrato = LocalDate.parse(scanner.nextLine());
        Empleado empleado = new Empleado(numemp, nombre, edad, oficina, puesto, contrato);
        int result = EmpleadoDAO.create(empleado);
        if (result > 0) {
            System.out.println("Empleado creado exitosamente.");
        } else {
            System.out.println("Error al crear el empleado.");
        }
    }

    private static void leerEmpleado(Scanner scanner) {
     
    }
    private static void actualizarEmpleado (Scanner scanner){
        
    }
     private static void eliminarEmpleado(Scanner scanner) {
        System.out.print("Número de Empleado: ");
        int numemp = scanner.nextInt();
        int result = EmpleadoDAO.delete(numemp);
        if (result > 0) {
            System.out.println("Empleado eliminado exitosamente.");
        } else {
            System.out.println("Error al eliminar el empleado.");
        }
    }
}
