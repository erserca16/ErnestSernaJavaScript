package entregable3ev;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * //LOS LIST PERMITEN DUPLICADOS, SE ALMACENAN EN UN ORDEN ESPECÍFICO Y POR
 * TANTO SE PUEDE ACCEDER A ELLOS POR SU POSICIÓN -- ARRAYLIST 
 * //LOS SET NO PERMITEN DUPLICADOS, NO TIENEN ORDEN ESPECÍFICO, SI AÑADES ALGO QUE YA ESTÁ
 * DA FALLO -- HASHSET, TREESET 
 * //LOS MAPS CREA UNA CLAVE ASOCIADAD A UN VALOR, LAS CLAVES SON ÚNICAS, AUNQUE LOS VALORES 
 * PUEDEN DUPLICARSE, NO TIENE ORDEN -- HASHMAP, TREEMAP
 *
 *  //TREE: arbol para almacenar y ordenar sus elementos de manera automática para acceder hace falta una complejidad logarítima 
 * //HASH: estructura que NO ordena. son más faciles de acceder.
 *
 * @author Ernest Serna
 */
public class Pizzeria {

    private final Map<Integer, Pizza> menu; //utilizamos map para que nos asigne un número (valor) que no se repite y con orden, además de la pizza.
    private final Set<String> totalIngredientes; // aqui utilizamos de nuevo un set para que no permita ingredientes duplicados en el conteo 
    //tal y como se pide en notas del ejercicio
    private double precioTotalPedido;

    public Pizzeria() {
        this.menu = new HashMap<>();
        this.totalIngredientes = new HashSet<>();
        this.precioTotalPedido = 0;
    }

    public void agregarPizza(Pizza pizza) { // Método agregarPizza donde añade las pizzas y actualiza el total de ingredientes
        menu.put(pizza.getIdentificador(), pizza);
        for (String ingrediente : pizza.getIngredientes()) {
            totalIngredientes.add(ingrediente);
        }
    }

    public void guardarPedido() throws IOException { // Método que escribe la información en el archivo expecificado
        Path fichero = Paths.get("pedido.txt");
        //BufferedWriter bw = Files.newBufferedWriter(fichero);

        try (BufferedWriter out = Files.newBufferedWriter(fichero)) {
            out.write("PIZZERIA MISLATA \n");
            out.write("Resumen del pedido: \n");
            for (Pizza pizza : menu.values()) {
                out.write(pizza.toString() + "\n");
                precioTotalPedido += pizza.getPrecio();
            }
            out.write("Precio total del pedido: " + precioTotalPedido + "\n");
            out.write("Número total de ingredientes únicos: " + totalIngredientes.size());
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException { // Método que hace funcionar la Pizzeria
        Pizzeria pizzeria = new Pizzeria();

        // Creamos las 3 pizzas
        Pizza pizza1 = new Pizza(1, new String[]{"Salsa de tomate", "queso", "jamón", "bacon"}, 800, 10.99);
        Pizza pizza2 = new Pizza(2, new String[]{"Salsa de tomate", "queso", "pepperoni"}, 600, 11.50);
        Pizza pizza3 = new Pizza(3, new String[]{"Salsa de tomate", "mozzarella", "champiñones", "cebolla"}, 580, 13.25);

        pizzeria.agregarPizza(pizza1);
        pizzeria.agregarPizza(pizza2);
        pizzeria.agregarPizza(pizza3);

        pizzeria.guardarPedido();

        System.out.println("Pedido guardado exitosamente en 'pedido.txt'.");
    }
}
