
package Agenda;

import java.util.Arrays;
import java.util.Scanner;

public class Agendaa {

   public static void main(String[] args) {
      final int TAM_AGENDA=20;
      String agenda[] = new  String[0];
      int opc;
      
      do {
         opc = menu();
         switch(opc) {
            case 1:
               agenda = nuevoContacto(agenda);
               break;
            case 2:
               buscarContacto(agenda);
               break;
            case 3:
               mostrarTodo(agenda);
               break;
         }
      } while (opc != 4);
      
   }
   
   static int menu() {
      System.out.println("1. Nuevo contacto.");
      System.out.println("2. Buscar contacto.");
      System.out.println("3. Ver todo.");
      System.out.println("4. Salir");
     
      return new Scanner(System.in).nextInt();
   }
   
   static String[] nuevoContacto(String agenda[]) {
      System.out.println("Nombre:");
      String nombre = new Scanner(System.in).nextLine();
      System.out.println("Teléfono:");
      String telefono = new Scanner(System.in).nextLine();
      
      agenda = Arrays.copyOf(agenda, agenda.length+1);
      agenda[agenda.length-1] = nombre + ":" + telefono;
      
      return agenda;
   }
   
   static void buscarContacto(String agenda[]) {
      System.out.println("Nombre a buscar:");
      String nombre = new Scanner(System.in).nextLine();
      
      for(String contacto: agenda) {
         String aux[] = contacto.split(":");
         if (aux[0].startsWith(nombre)) {
            System.out.println("Nombre: " + aux[0] + "\t(" + aux[1] + ")");
         }
      }
   }
   
   static void mostrarTodo(String agenda[]) {
      Arrays.sort(agenda);
      for(String contacto: agenda) {
         String aux[] = contacto.split(":");
         System.out.println("Nombre: " + aux[0] + "\t(" + aux[1] + ")");
      }
   }
    
}
