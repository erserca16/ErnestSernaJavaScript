package CuentaBancaria;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Este código es una aplicación de gestión de cuentas bancarias en Java.
 * Utiliza varias clases para manejar las operaciones bancarias y la interacción
 * con el usuario. La clase Principal es la clase principal de la aplicación.
 * Contiene el método main, que es el punto de entrada de la aplicación.
 *
 * En el método main se crea una instancia de la clase Persona con un DNI y un
 * nombre, y se crea una instancia de la clase CuentaBancaria con un número de
 * cuenta, el titular de la cuenta y un saldo inicial. Luego se inicia un bucle
 * do-while para mostrar un menú al usuario y realizar la acción seleccionada.
 * El bucle continúa hasta que el usuario seleccione la opción "Salir". La clase
 * CuentaBancaria tiene varios métodos que permiten al usuario realizar
 * operaciones en la cuenta, como ingresar o retirar dinero, ver la información
 * de la cuenta, autorizar a otras personas a realizar operaciones en la cuenta,
 * domiciliar recibos y listar los recibos domiciliados. La clase Persona se
 * utiliza para almacenar información sobre el titular de la cuenta, como su DNI
 * y su nombre.
 */
public class Principal {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Persona titular = new Persona("00167855X", "Ángel García");
        CuentaBancaria cuenta = new CuentaBancaria(12345678, titular, -100);

        do
        {
            String respuesta = menu();
            switch (respuesta)
            {
                case "1": //INGRESAR DINERO
                    menuIngresar(cuenta);
                    break;
                case "2": //RETIRAR DINERO
                    menuExtraer(cuenta);
                    break;
                case "3": //INFORMACIÓN CUENTA
                    menuInformacion(cuenta);
                    break;
                case "4": //AUTORIZAR DINERO
                    menuAutorizar(cuenta);
                    break;
                case "5": //DOMICILIAR RECIBO
                    menuDomiciliar(cuenta);
                    break;
                case "6": //LISTAR RECIBOS
                    menuListarDomiciliados(cuenta);
                    break;
                case "0":
                    System.out.println("Gracias por usar nuestra aplicación");
                    return;  //SALE DEL BUCLE
                default:
                    System.out.println("Debe seleccionar un numero correcto");
            }
        } while (true);
    }

    public static String menu() {
        String respuesta;
        System.out.println("ING MISLATA -- GESTION DE CUENTA BANCARIA");
        System.out.println("1-Ingresar dinero.");
        System.out.println("2-Sacar dinero.");
        System.out.println("3-Informacion cuenta.");
        System.out.println("4-Autorizar.");
        System.out.println("5-Domiciliar recibo.");
        System.out.println("6-Listar recibos según periodicidad.");
        System.out.println("0-Salir\n");
        respuesta = sc.nextLine();
        return respuesta;
    }

    public static void menuIngresar(CuentaBancaria cuenta) { //Paso por referencia del objeto cuenta (es el original)      
        System.out.println("¿Cuánto dinero desea ingresar?");
        double cantidad = Double.parseDouble(sc.nextLine());
        char resultadoIngreso = cuenta.ingresar(cantidad);
        // devuelve s cuando el dinero se ha ingresado.// devuelve h cuando cantidad está entre 4.500 y 10.000, se ha registrado el movimiento// devuelve a cuando cantidad es superior a 10.000, se ha registrado el movimiento.// devuelve x cuando se ingresa una cantidad en negativo.
        if (resultadoIngreso == 's')
        {
            System.out.println("Se ha ingresado: " + cantidad + "€");
            System.out.println("Saldo de la cuenta: " + cuenta.getSaldoFormateado() + "\n");
        } else if (resultadoIngreso == 'h')
        {
            System.out.println("Se ha ingresado: " + cantidad + "€");
            System.out.println("Saldo de la cuenta: " + cuenta.getSaldoFormateado());
            System.out.println("Se ha registrado el movimiento por ser cantidad entre 4.500€ y 10.000€\n");
        } else if (resultadoIngreso == 'a')
        {
            System.out.println("Se ha ingresado: " + cantidad + "€");
            System.out.println("Saldo de la cuenta: " + cuenta.getSaldoFormateado());
            System.out.println("AVISO AL BANCO DE ESPAÑA según Orden Ministerial EHA/1439/2006\n");
        } else if (resultadoIngreso == 'x')
        {
            System.out.println("La cantidad a ingresar no puede ser 0 o menor\n");
        }
    }

    public static void menuAutorizar(CuentaBancaria cuenta) {
        System.out.println("i.Escribe el NIF: ");
        String respuestaNIF = sc.nextLine();
        System.out.println("ii.Escribe el Nombre completo: ");
        String respuestaNombre = sc.nextLine();
        Persona autorizado = new Persona(respuestaNIF, respuestaNombre);
        cuenta.autorizar(autorizado);
        System.out.println("\nPersonas autorizadas en la cuenta:" + cuenta.verAutorizados() + "\n");
    }

    public static void menuExtraer(CuentaBancaria cuenta) {
        int resultadoExtraer;
        System.out.println("¿Cuánto dinero desea sacar?");
        Double dineroExtraer = Double.parseDouble(sc.nextLine());
        resultadoExtraer = cuenta.extraer(dineroExtraer);
        if (resultadoExtraer == 0)
        {
            System.out.println("No se puede extraer una cantidad en negativo\n");
        } else if (resultadoExtraer == 1)
        {
            System.out.println("Se ha sacado: " + dineroExtraer + "€\nSaldo:" + cuenta.getSaldoFormateado() + "\n");
        } else if (resultadoExtraer == 2)
        {
            System.out.println("No hay suficiente dinero en la cuenta para sacar: " + dineroExtraer + "€\n");
        }
    }

    public static void menuInformacion(CuentaBancaria cuenta) {
        System.out.println("Aqui tiene la información solicitada");
        System.out.println(cuenta.informacionCuenta());
    }

    public static void menuDomiciliar(CuentaBancaria cuenta) {
        String cif, nombreEmpresa, concepto, periodicidad;
        double importe;
        int codigoDomiciliar;
        System.out.println("1.Escribe el CIF: ");
        cif = sc.nextLine();
        System.out.println("2.Escribe el Nombre de la empresa: ");
        nombreEmpresa = sc.nextLine();
        System.out.println("3.¿Cuánto es el importe?: ");
        importe = Double.parseDouble(sc.nextLine());
        System.out.println("4.Dame un concepto: ");
        concepto = sc.nextLine();
        System.out.println("5.¿Cuál es la periodicidad?(mensual, timestral, anual): ");
        periodicidad = sc.nextLine();

        Recibo recibo = new Recibo(cif, nombreEmpresa, importe, concepto, periodicidad);
        codigoDomiciliar = cuenta.domiciliarRecibo(recibo);
        if (codigoDomiciliar == 1)//TODO CORRECTO EEROR:1//FALTA EL CIF ERROR:2//FALTA NOMBRE EMPRESA ERROR:3//FALTA CONCEPTO ERROR:4//ERROR PERIODICIDAD ERROR:5
        {
            System.out.println("-Recibo domiciliado\n");
        }
        if (codigoDomiciliar == 2)
        {
            System.out.println("-Recibo NO domiciliado -> Falta el CIF\n");
        }
        if (codigoDomiciliar == 3)
        {
            System.out.println("-Recibo NO domiciliado -> Falta nombre empresa\n");
        }
        if (codigoDomiciliar == 4)
        {
            System.out.println("-Recibo NO domiciliado -> Falta el concepto\n");
        }
        if (codigoDomiciliar == 5)
        {
            System.out.println("-Recibo NO domiciliado -> La periodicidad no es válida(mensual/trimestral/anual\n");
        }
    }

    public static void menuListarDomiciliados(CuentaBancaria cuenta) {
        Set<Recibo> recibosListados = new HashSet<>();
        System.out.println("¿Cuál es la periodicidad de los recibos a buscar?(mensual, trimestral o anual)");
        String periodicidad = sc.nextLine();
        System.out.println("Listado de recibos domiciliados");
        recibosListados = cuenta.listadoRecibosDomiciliados(periodicidad);
        for (Recibo recibo : recibosListados)
        {
            System.out.println(recibo);
        }
    }

}
