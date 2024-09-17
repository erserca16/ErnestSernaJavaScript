package CuentaBancaria;

public class Recibo {

    private String cif;
    private String nombreEmpresa;
    private double importe;
    private String concepto;
    private String periodicidad; // mensual, trimestral, anual

    public Recibo(String cif, String nombreEmpresa, double importe, String concepto, String periodicidad) {
        this.cif = cif;
        this.nombreEmpresa = nombreEmpresa;
        this.importe = importe;
        this.concepto = concepto;
        this.periodicidad = periodicidad;
    }

    public String getCif() {
        return cif;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public double getImporte() {
        return importe;
    }

    public String getConcepto() {
        return concepto;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    @Override
    public String toString() {
        return "·{CIF:" + this.cif + " Nombre:" + this.nombreEmpresa + " Importe:" + this.importe + " Concepto:" + this.concepto + " Periodicidad " + this.periodicidad + "}\n";
    }           
}
