package practicasExamen;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Trocear {

    public static void main(String[] args) {
        
        /* POESIA PARA PROBAR
        Se ha asomado una cigüeña a lo alto del campanario. Girando en torno a la torre y al caserón solitario,ya las golondrinas chillan. Pasaron del blanco invierno,de nevascas y ventiscas los crudos soplos de infierno.Es una tibia mañana.El sol calienta un poquito la pobre tierra soriana.&Pasados los verdes pinos,casi azules, primaverase ve brotar en los finoschopos de la carreteray del río. El Duero corre, terso y mudo, mansamente.El campo parece, más que joven, adolescente.&Entre las hierbas, alguna humilde flor ha nacido,azul o blanca. ¡Belleza del campo apenas florido,y mística primavera!&¡Chopos del camino blanco, álamos de la ribera,espuma de la montañaante la azul lejanía;sol del día, claro día!Hermosa tierra de España!&
        */
        int contadorEstrofas = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la poesia");
        String poesia = sc.nextLine();

        //CON STRINGTOKENIZER
        StringTokenizer estrofas = new StringTokenizer(poesia, "&");
        System.out.println("Total de ESTROFAS:" + estrofas.countTokens() + "\n\n");
        while (estrofas.hasMoreTokens() == true) {
            String estrofa = estrofas.nextToken();
            System.out.println("ESTROFA  " + ++contadorEstrofas);

            StringTokenizer frases = new StringTokenizer(estrofa, ".");
            System.out.println("Total FRASES:" + frases.countTokens());
            while (frases.hasMoreTokens() == true) {
                String frase = frases.nextToken();
                System.out.print(frase.length() + " carácteres  ");
                System.out.println(frase + " ");
            }

            System.out.println(" ****************************");
        }


    }

}
