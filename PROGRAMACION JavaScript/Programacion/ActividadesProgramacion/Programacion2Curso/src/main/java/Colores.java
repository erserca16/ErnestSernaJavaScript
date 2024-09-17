
import java.util.Arrays;

/**
 *
 * @author Ernest Serna
 */
public class Colores {
   private String paleta[] = {"Rojo", "Verde", "Azul", "Blanco", "Negro"};
  
   public void addColor(String nuevoColor) {
      boolean encontrado = false;
      int i=0;
      while (!encontrado && i<paleta.length) {
         if (paleta[i].equalsIgnoreCase(nuevoColor)) {
            encontrado = true;
         }
         i++;
      }
      if (!encontrado) {
         paleta = Arrays.copyOf(paleta, paleta.length+1);
         paleta[paleta.length-1] = nuevoColor;
      }
   }
   
   String[] seleccionColores(int cuantos) {
      String result[];
      if (cuantos>=paleta.length) {
         result = Arrays.copyOf(paleta, paleta.length);
      } else {
         int indices[] = new int[paleta.length];
         for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
         }
         for(int i=0; i < paleta.length; i++) {
            int a = (int)(Math.random()*indices.length);
            int b = (int)(Math.random()*indices.length);
            int aux = indices[a];
            indices[a] = indices[b];
            indices[b] = aux;
         }
         
         result = new String[cuantos];
         for(int i=0; i<cuantos; i++) {
            result[i] = paleta[indices[i]];
         }
      }
      
      return result;
   }
}
