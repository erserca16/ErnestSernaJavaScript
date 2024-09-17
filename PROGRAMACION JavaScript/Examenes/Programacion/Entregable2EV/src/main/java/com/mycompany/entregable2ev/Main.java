package com.mycompany.entregable2ev;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("COMPRUEBO FECHAS Y HORAS INCORRECTAS");
        System.out.println("Compruebo mal el día");
        CalendarioExacto calendario1 = new CalendarioExacto(32, 12, 2021, 23, 59);
        System.out.println("- Calendario 1: " + calendario1);
        System.out.println("");
        System.out.println("Comprueno mal el mes:");
        CalendarioExacto calendario2 = new CalendarioExacto(31, 13, 2021, 23, 25);
        System.out.println("- Calendario 2: " + calendario2);
        System.out.println("");
        System.out.println("Compruebo mal la hora");
        CalendarioExacto calendario3 = new CalendarioExacto(31, 12, 2021, 25, 59);
        System.out.println("- Calendario 3: " + calendario3);
        System.out.println("");
        System.out.println("Compruebo mal el minuto");
        CalendarioExacto calendario4 = new CalendarioExacto(31, 12, 2021, 23, 60);
        System.out.println("- Calendario 4: " + calendario4);
        System.out.println("");
        System.out.println("COMPRUEBO LOS INCREMENTOS DE DÍA Y MES");
        System.out.println("Comprueno suma de mes 31/01/2021");
        CalendarioExacto calendario5 = new CalendarioExacto(31, 01, 2021, 23, 59);
        calendario5.incrementaMes();
        System.out.println("- Fecha del calendario 5 después de incrementarle un mes: " + calendario5);
        System.out.println("");
        System.out.println("Comprueno suma de dia 31/12/2021");
        CalendarioExacto calendario6 = new CalendarioExacto(31, 12, 2021, 23, 59);
        calendario6.incrementarDia();
        System.out.println("- Fecha del calendario 5 después de incrementarle un mes: " + calendario6);
        System.out.println("");
        System.out.println("COMPRUEBO INCREMENTOS DE HORAS Y MINUTOS");
        System.out.println("Compruebo la suma de 1 minuto y que pase a la siguiente hora a 31/12/2021 23:59");
        CalendarioExacto calendario7 = new CalendarioExacto(31, 12, 2021, 23, 59);
        calendario7.incrementarMinuto();
        System.out.println("- Hora del calendario 7 despues de sumarle un minuto " + calendario7);
        System.out.println("");
        System.out.println("Compruebo la suma de 1 hora y que pase a la siguiente hora a 31/12/2021 23:59");
        CalendarioExacto calendario8 = new CalendarioExacto(31, 12, 2021, 23, 59);
        calendario8.incrementarHora();
        System.out.println("- Hora del calendario 8 despues de sumarle un minuto " + calendario8);
        System.out.println("");
        System.out.println("COMPROBACIÓN DEL EQUALS");
        System.out.println("Creo una fecha que es igual a la que da el calendario 5 al sumarle el mes");
        CalendarioExacto calendario9 = new CalendarioExacto(28, 2, 2021, 23, 59);
        System.out.println("- ¿Calendario 9 es igual a calendario 5? " + calendario9.equals(calendario5));
        System.out.println("Creo una fecha que es igual a la que da el calendario 5 al sumarle el mes");
        CalendarioExacto calendario10 = new CalendarioExacto(31, 1, 2021, 23, 59);
        System.out.println("- ¿Calendario 9 es igual a calendario 5? " + calendario10.equals(calendario5));

        System.out.println("");
        System.out.println("INTRODUZCA SU PROPIO CALENDARIO Y HORA");
        System.out.println("Ingrese la fecha:");
        System.out.println("DIA");
        int dia = scanner.nextInt();
        System.out.println("MES");
        int mes = scanner.nextInt();
        System.out.println("AÑO");
        int anyo = scanner.nextInt();

        System.out.println("Ingrese la hora:");
        System.out.println("HORA");
        int hora = scanner.nextInt();
        System.out.println("MINUTO");
        int minuto = scanner.nextInt();
        CalendarioExacto calendarioUsuario = new CalendarioExacto(dia, mes, anyo, hora, minuto);
        System.out.println("El calendario creado por defecto es 31/01/2021 23:59");
        System.out.println("Calendario creado por usted: " + calendarioUsuario);
        CalendarioExacto calendarioExistente = new CalendarioExacto(31, 01, 2021, 23, 59);
        System.out.println("Calendario existente: " + calendarioExistente);

        if (calendarioUsuario.equals(calendarioExistente)) {
            System.out.println("El calendario ingresado por el usuario es igual al calendario existente.");
        } else {
            System.out.println("El calendario ingresado por el usuario es diferente al calendario existente.");
        }
    }
}
