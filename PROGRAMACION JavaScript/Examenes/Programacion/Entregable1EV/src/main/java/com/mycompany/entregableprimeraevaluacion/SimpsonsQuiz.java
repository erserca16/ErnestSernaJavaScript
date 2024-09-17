package com.mycompany.entregableprimeraevaluacion;

import java.util.*;
import com.mycompany.entregableprimeraevaluacion.Preguntas;

public class SimpsonsQuiz {

    private static final int MIN_PREGUNTAS = 3;  // le añadimos el mínimo de preguntas para que el juego inicie
    private static final int MAX_PREGUNTAS = 6; // le añadirmos el máximo de preguntas para que el juego incie

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // el objeto scanner para recoger por teclado lo que responda el usuario
        Random random = new Random(); // el método random para que las preguntas se escojan aleatoriamente
        boolean jugar = true; // un booleano que se incia en true para que empiece el juego y al acabar se pregunta de nuevo para cambiar a false y salir o seguir en true

        while (jugar) {
            System.out.println("¡BIENVENID@ AL QUIZ DE LA SERIE LOS SIMPSONS!");
            System.out.println("Has de contestar con V o v para una respuesta Verdadera y F o f para una respuesta Incorrecta");
            System.out.println("¿Cuántas preguntas quieres contestar? (mínimo 3, máximo 6)");
            int numeroDePreguntas = scanner.nextInt(); // en este scaner recogemos y guardamos el número de preguntas que queire jugar
            if (numeroDePreguntas < MIN_PREGUNTAS || numeroDePreguntas > MAX_PREGUNTAS) { // aqui comprobamos que sea igual a 3 o 6 o esté dentro de ese rango si no, le dice que es incorrecto
                System.out.println("Número de preguntas incorrecto. Inténtalo de nuevo.");
                continue; // hace que si el número no correcto empiece de nuevo el while, se podría quitar pero para empezar de nuevo, habría que "reinciar" el programa
            }

            List<Integer> questionIndices = new ArrayList<>(); //Lista que almacenará aleatoriamente los índices de las preguntas de la clase Preguntas
            for (int i = 0; i < numeroDePreguntas; i++) { //blucle for que actua hasta que llega al número introducido por usuario
                int index;
                do {
                    index = random.nextInt(Preguntas.PREGUNTAS.length);
                } while (questionIndices.contains(index));
                questionIndices.add(index);
            }

            int respuestasCorrectas = 0; //contador que irá sumando conforme acierte para luego sacar el porcentaje
            for (int index : questionIndices) {
                System.out.println(Preguntas.PREGUNTAS[index]); //imprime la pregunta
                String[] respuestaCorrecta = Preguntas.RESPUESTAS[index];
                String[] restoOpciones = Preguntas.RESPUESTAS_INCORRECTAS[index];

                List<String> allOptions = new ArrayList<>(Arrays.asList(respuestaCorrecta));
                allOptions.addAll(Arrays.asList(restoOpciones));

                Collections.shuffle(allOptions); // Para mezclar las opciones para que no estén en el mismo orden

                for (int i = 0; i < allOptions.size(); i++) {
                    System.out.println("(" + (i + 1) + ") " + allOptions.get(i));
                }

                String respuestaUsuario = scanner.next().toUpperCase(); // Para que valga tanto en minúscula como mayuscula ya que con el UpperCase lo devuevle en mayusculas

                if (respuestaUsuario.equals("V") || respuestaUsuario.equals("F")) {
                    if (Arrays.asList(respuestaCorrecta).contains(respuestaUsuario)) {
                        respuestasCorrectas++;
                        System.out.println("¡Yuhu! ¡Correcto!");
                    } else {
                        System.out.println("Ouch! Incorrecto. Las respuestas correctas eran: " + Arrays.toString(respuestaCorrecta));
                    }
                } else if (respuestaUsuario.equals("P") || respuestaUsuario.equals("B")) { // con este if damos varias opciones en la pregunta 4
                    boolean esCorecto = false;
                    for (String respuesta : respuestaCorrecta) {
                        if (respuesta.contains("(" + respuestaUsuario + ")")) {
                            esCorecto = true;
                            break;
                        }
                    }
                    if (esCorecto) {
                        respuestasCorrectas++;
                        System.out.println("¡Correcto!");
                    } else {
                        System.out.println("Incorrecto. La respuesta correcta es: " + Arrays.toString(respuestaCorrecta));
                    }
                } else {
                    System.out.println("Respuesta no válida. Debías responder con 'V', 'F' o en su defecto con 'P' o 'B'.");
                }
            }

            double porcentajeAcierto = ((double) respuestasCorrectas / numeroDePreguntas) * 100; // aqui calcula el porcentaje entre la suma de correctas y el numero de preguntas introducidas
            System.out.printf("Has acertado el %.2f%% de las preguntas.\n", porcentajeAcierto);

            if (porcentajeAcierto < 33) {
                System.out.println("Bart Simpson te diria multiplícate por 0\n Inténtealo de nuevo");
            } else if (porcentajeAcierto < 66) {
                System.out.println("Homer Simpson te diria Ouch!\n Te animo a intentarlo de nuevo");
            } else if (porcentajeAcierto < 100) {
                System.out.println("Con este resultado podrías ir al bar de Moe\n Inténtalo una vez más para lograr el 100%");
            } else {
                System.out.println("¡Felicidades!\nPodrías ser vecino de Springfield");
            }

            System.out.println("¿Quieres jugar otra vez? (S/N)");
            System.out.println("S (Sí) N (No)");
            jugar = scanner.next().equalsIgnoreCase("S");
        }
        System.out.println("¡Gracias por participar! ¡Hasta la próxima!");
    }
}
