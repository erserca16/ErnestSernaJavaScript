package com.mycompany.entregableprimeraevaluacion;


public class Preguntas {
    static final String[] PREGUNTAS = {
        "El núcleo familiar de los Simpsons está formado por 5 personajes",
        "Lisa Simpsons toca el clarinete",
        "El mejor amigo de Bart es Milhouse",
        "¿Quiénes de estos son los animales que más aparecen en la serie? Hay más de una opción correcta, contesta con la letra ( )",
        "El pueblo donde transcurre la serie es Shelbyville",
        "El director de la central nuclear es Ned Flanders"
    };

    static final String[][] RESPUESTAS = { // Respuestas correctas
        {"V"}, 
        {"F"}, 
        {"V"}, 
        {"(P) Pequeño ayudante de Santa Claus", "(B) Bola de nieve"}, 
        {"F"}, 
        {"F"} 
    };

    
    static final String[][] RESPUESTAS_INCORRECTAS = { // Opciones incorrectas, se creó para que salgan varias opciones en la pregunta 4
        {"F"},
        {"V"},
        {"F"},
        {"(A) Actor secundario Bob", "(R) Rasca y Pica", "(T) Tenacitas"},
        {"V"},
        {"V"}
    };
}
