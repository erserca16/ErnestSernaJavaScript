package com.mycompany.entregable2ev;

public class CalendarioExacto extends Calendario {

    private int hora;
    private int minuto;

    
    public CalendarioExacto(int dia, int mes, int anyo, int hora, int minuto) { // CONSTRUCTOR QUE PERMITE INCLUIR HORA Y MINUTO A DIA, MES Y ANYO
        super(dia, mes, anyo);
        this.dia = dia;
        this.mes = mes;
        this.anyo = anyo;
        this.hora = hora;
        this.minuto = minuto;
        compruebaHoraMinutoyFecha();
        compruebaFecha();
        compruebaHora();
    }

    public CalendarioExacto(int hora, int minuto) { // CONSTRUCTOR QUE ME PERMITE CREAR CALENDARIO SOLO CON HORAS
        this.hora = hora;
        this.minuto = minuto; // Llamar al método para verificar si la hora y el minuto son válidos
        compruebaHora();
    }

    public CalendarioExacto() { // CONSTRUCTOR VACIO

    }

    private void compruebaFecha() { //MÉTODO QUE COMPRUEBA LA FECHA Y SI NO ESTABLECE EN 0
        if (anyo <= 0 || mes < 1 || mes > 12 || dia < 1 || diasMes[mes - 1] < dia) {
            dia = 0;
            mes = 0;
        }
    }

    private void compruebaHora() { //MÉTODO QUE COMPRUEBA LA HORA Y SI NO ESTABLECE EN 0
        if (hora < 0 || hora > 23 || minuto < 0 || minuto > 59) {
            hora = 0;
        }
        minuto = 0;
    }

    
    private void compruebaHoraMinutoyFecha() { //MÉTODO QUE COMPRUEBA LA HORA Y LA FECHA Y SI NO ESTABLECE TODO EN 0
        if (hora < 0 || hora > 23 || minuto < 0 || minuto > 59 || anyo <= 0 || mes < 1 || mes > 12 || dia < 1 || diasMes[mes - 1] < dia) {
            dia = 0;
            mes = 0;
            anyo = 0;
            hora = 0;
            minuto = 0;
        }
    }

    public void incrementarMinuto() { // MÉOTODO QUE HACE QUE AL LLEGAR A 60, PONGA EL MINUTO EN EL SIGUIENTE PERO INCREMENTE UNA HORA LLAMANDO AL MÉTODO DE LA HORA
        minuto++;
        if (minuto == 60) {
            minuto = 0;
            incrementarHora();
        }
    }

    public void incrementarHora() { //MÉTODO QUE HACE QUE AL LLEGAR A 24 HORAS, PONGA EL CONTADOR A 0 PERO SUME UN DÍA, LLAMANDO AL MÉTODO
    hora++;
    if (hora == 24) {
        hora = 0;
        incrementarDia(); 
    } 
}
       

    // METODO PARA OBTENER LA HORA
    public int getHora() {
        return hora;
    }

    // METODO PARA ESTABLECER LA HORA
    public void setHora(int hora) {
        this.hora = hora;
    }

    // METODO PARA OBTENER EL MINUTO
    public int getMinuto() {
        return minuto;
    }

    // METODO PARA ESTABLECER EL MINUTO
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    // SOBRESCRITURA DEL METODO toString PARA INCLUIR HORA Y MINUTO
    @Override
    public String toString() {
        String ceroDia = dia < 10 ? "0" : "";
        String ceroMes = mes < 10 ? "0" : "";
        String ceroHora = hora < 10 ? "0" : "";
        String ceroMinuto = minuto < 10 ? "0" : "";
        return ceroDia + dia + "/" + ceroMes + mes + "/" + anyo + " " + ceroHora + hora + ":" + ceroMinuto + minuto;
    }

    // SOBRESCRITURA DEL METODO equals PARA INCLUIR HORA Y MINUTO
    @Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (!(obj instanceof Calendario)) {
        return false;
    }
    Calendario otro = (Calendario) obj;
    return this.dia == otro.dia && this.mes == otro.mes && this.anyo == otro.anyo;
}

} //cuando tenemos objetos privados, tenemos que entrar a ellos con el get().
// para ordenar está el arrays.sort para hacer una array
