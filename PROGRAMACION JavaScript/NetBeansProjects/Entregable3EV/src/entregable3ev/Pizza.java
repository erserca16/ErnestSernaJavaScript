package entregable3ev;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Ernest Serna
 */
public class Pizza {

    /**
     * @param args the command line arguments
     */
    private int identificador;
    private Set<String> ingredientes; //LOS SET NO PERMITEN DUPLICADOS, NO TIENEN ORDEN ESPECÍFICO, SI AÑADES ALGO QUE YA ESTÁ DA FALLO -- HASHSET, TREESET
    private double precio;
    private int calorias;     

    public Pizza(int identificador, String[] alimentos, int calorias, double precio) {
        this.identificador = identificador;
        this.precio = precio;
        this.calorias = calorias;
        this.ingredientes = new TreeSet<>(); // utilizo un tree set ya que el tree es un arbol que ordena y el set no permite duplicados
        for (String ingrediente : alimentos) {
            this.ingredientes.add(ingrediente);
        }
    }


    public int getIdentificador() {
        return identificador;
    }

    public Set<String> getIngredientes() {
        return ingredientes;
    }
    

    public double getPrecio() {
        return precio;
    }
  
    public int getCalorias() {
        return calorias;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setIngredientes(Set<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

   

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    @Override
    public String toString() {
        return "Pizza nº " + identificador + ": Ingredientes=" + ingredientes + ", precio=" + precio + ", calorias=" + calorias;
    }

}
