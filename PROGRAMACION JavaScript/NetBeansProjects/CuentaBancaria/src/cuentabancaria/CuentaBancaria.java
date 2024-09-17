package CuentaBancaria;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class CuentaBancaria {

    private long numCuenta;
    private Persona titular;
    private Set<Persona> autorizados = new HashSet<>();
    private double saldo = (double) (Math.random() * 35 + 5); // Incluye un atributo saldo para gestionar el dinero que almacena la cuenta. Al crear una cuenta, se le regalará una cantidad aleatoria de euros entre 5€ y 40€. No permitir que sea modificado desde fuera de la clase.
    private String movimientosRevisar = "";
    private double limiteDescubiertos;
    private Set<Recibo> recibosDomiciliados = new HashSet<>();

    public CuentaBancaria(long ncuenta, Persona titular, double limiteDescubiertos) {
        this.numCuenta = ncuenta;
        this.titular = titular;
        this.limiteDescubiertos = limiteDescubiertos;
    }

    public long getNcuenta() {
        return this.numCuenta;
    }

    public Persona getPersonaTitular() {
        return titular;
    }

    public String getSaldoFormateado() { // Añade método String getSaldoFormateado() que devuelve el saldo según el formato 123.888,00 €
        NumberFormat formatodinero = NumberFormat.getCurrencyInstance(new Locale("es", "ES"));
        return formatodinero.format(saldo);
    }

    public boolean autorizar(Persona autorizado) {
        return autorizados.add(autorizado);
    }

    public String getMovimientosRevisar() {
        return movimientosRevisar;
    }

    public int extraer(double cantidad) {
        LocalDateTime fecha = LocalDateTime.now(ZoneId.of("Europe/Madrid"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String fechaFormateada = fecha.format(formatter);
        int opcion = 0;
        if (cantidad < 0)
        {
            opcion = 0;
        } else if (this.saldo - cantidad > limiteDescubiertos)
        {
            this.saldo = this.saldo - cantidad;
            opcion = 1;
            if (this.saldo < 0)
            {
                movimientosRevisar = movimientosRevisar + "|* Saldo negativo " + fechaFormateada + "*| ";
            }
        } else
        {
            opcion = 2;
        }
        return opcion;
    }

    public char ingresar(double cantidad) {
        char letra;
        LocalDateTime fecha = LocalDateTime.now(ZoneId.of("Europe/Madrid"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String fechaFormateada = fecha.format(formatter);
        if (cantidad > 0) // ingresará dinero de la cuenta. Se debe comprobar que la cantidad pasada como parámetro no es negativa e incrementar el atributo saldo.
        {
            this.saldo = this.saldo + cantidad;
            letra = 's';  // devuelve s cuando el dinero se ha ingresado.
            if (cantidad > 4449 & cantidad < 10000) // se registrará en movimientosRevisar.
            {
                letra = 'h'; // devuelve h cuando cantidad está entre 4.500 y 10.000, se ha registrado el movimiento
                movimientosRevisar = movimientosRevisar + "|* Movimiento superior a 4.449€ " + fechaFormateada + "*| ";

            } else if (cantidad > 10000) // si es superior a 10.000€ se registrará también en movimientosRevisar y se mostrará en consola "AVISO AL BANCO DE ESPAÑA según Orden Ministerial EHA/1439/2006".
            {
                letra = 'a'; // devuelve a cuando cantidad es superior a 10.000, se ha registrado el movimiento.

                movimientosRevisar = movimientosRevisar + "|* Movimiento superior a 10.000€ " + fechaFormateada + "*| ";
            }
        } else
        {
            letra = 'x'; // devuelve x cuando se ingresa una cantidad en negativo.
        }
        return letra;
    }

    public String verAutorizados() {
        String mostrar = "";

        for (Persona autorizadoMostrar : autorizados)
        {
            mostrar += "\nDNI: " + autorizadoMostrar.getNif() + " " + "| Nombre: " + autorizadoMostrar.getNombre();
        }
        return mostrar;

    }

    public String informacionCuenta() {
        String informacion = "";
        informacion = "Nº de cuenta " + this.getNcuenta() + " - " + this.getPersonaTitular();
        if (!this.autorizados.isEmpty())
        {
            informacion = informacion + "\nPersonas autorizadas: " + this.verAutorizados();
        }
        if (!this.movimientosRevisar.isEmpty())
        {
            informacion = informacion + "\nNº de movimientos a revisar: " + this.movimientosRevisar;
        }
        informacion = informacion + "\nSaldo: " + this.getSaldoFormateado() + "\n";
        return informacion;
    }

    public int domiciliarRecibo(Recibo recibo) {
        String periodicidad = "";
        int codigoDomiciliar = 0;
        boolean reciboAñadido;

        if (recibo.getCif().isEmpty())
        { //FALTA EL CIF ERROR:2
            codigoDomiciliar = 2;
        }
        if (recibo.getNombreEmpresa().isEmpty())
        { //FALTA NOMBRE EMPRESA ERROR:3
            codigoDomiciliar = 3;
        }
        if (recibo.getConcepto().isEmpty())
        { //FALTA CONCEPTO ERROR:4
            codigoDomiciliar = 4;
        }
        if (!(recibo.getPeriodicidad().equalsIgnoreCase("mensual") || recibo.getPeriodicidad().equalsIgnoreCase("trimestral") || recibo.getPeriodicidad().equalsIgnoreCase("anual")))
        { //ERROR PERIODICIDAD ERROR:5
            codigoDomiciliar = 5;
        }

        if (codigoDomiciliar == 0)
        {
            reciboAñadido = recibosDomiciliados.add(recibo);
            if (reciboAñadido = true)
            {
                codigoDomiciliar = 1; //1 TODO CORRECTO
            }
        }
        return codigoDomiciliar;
    }

    public Set<Recibo> listadoRecibosDomiciliados(String periodicidad) {
        Set<Recibo> recibosListados = new HashSet<>();
        for (Recibo recibos : recibosDomiciliados)
        {
            if (recibos.getPeriodicidad().equalsIgnoreCase(periodicidad))
            {
                recibosListados.add(recibos);
            }
        }
        return recibosListados;
    }

}
