package com.mycompany.entregable2ev;


/**
 *
 * @author Ernest Serna
 */
public class Calendario {

    protected int anyo, mes, dia;
    protected final int diasMes[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // ARRAY YA QUE AL NO HABER AÑO BISIESTO, SIEMPRE TENDRÁN EL MISMO NÚEMRO DE DIAS

    public Calendario(int dia, int mes, int anyo) { //CONSTRUCTOR CALENDARIO CON UNICAMENTE LA FECHA Y EL MÉTODO QUE COMPRUEBA QUE ES CORRECTO
        this.anyo = anyo;
        this.mes = mes;
        this.dia = dia;
        compruebaFecha();
    }

    public Calendario() { // CONSTRUCTOR VACIO

    }
//MÉTODO PARA ESTABLECER EL AÑO
    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

//MÉTODO PARA ESTABLECER EL MES
    public void setMes(int mes) {
        this.mes = mes;
    }

//MÉTODO PARA ESTABLECER EL DIA
    public void setDia(int dia) {
        this.dia = dia;
    }

//MÉTODO PARA OBTENER EL AÑO
    public int getAnyo() {
        return anyo;
    }
    
//MÉTODO PARA OBTENER EL MES
    public int getMes() {
        return mes;
    }

//MÉTODO PARA OBTENER EL DIA
    public int getDia() {
        return dia;
    }

//MÉTODO PARA OBTENER EL DIA DEL MES
    public int[] getDiasMes() {
        return diasMes;
    }

    private void compruebaFecha() { //MÉTODO QUE COMPRUEBA QUE LA FECHA ES CORRECTA. A ANYO LO ESTABLECE EN 1 SI SE PONE 0 YA QUE EL ANYO 0 NO EXISTE
                                    //EL MES COMPRUEBA QUE ES 
        if (anyo == 0) {
            anyo = 1;
        }
        if (mes < 1 || 12 < mes) {
            mes = 1;
        }
        if (dia < 1 || diasMes[mes - 1] < dia) {
            dia = 1;
        }
    }

    void incrementarDia() { //MÉTODO QUE INCREMENETA EL DIA Y SI ESTE SUPERA EL LÍMITE DEL DÍA QUE TIENE ESE MES EN EL ARRAY, INCREMENTA EL MES LLAMANDO AL MÉTODO DE INCREMENTAR MES
        dia++;
        if (dia > diasMes[mes - 1]) {
            dia = 1;
            incrementaMes();
        }
    }

    void incrementaMes() { //ESTE MÉTODO LO QUE LE DIGO ES QUE ME PONGA LA FECHA TOPE POR ENCIMA DEL MES SIGUIENTE, ES DECIR SI AL 31 DE ENERO LE DIGO
        // QUE SUME UN MES, QUE NO SUME 31 DÍAS AUNQUIE SEA EL 3 DE MARZO, QUE PONGA EL DIA TOPE DEL MES SIGUIENTE.
        mes++;
        if (mes > 12) {
            mes = 1;
            incrementaAño();
        }
        if (dia > diasMes[mes - 1]) {
            dia = diasMes[mes - 1];
        }
    }

    void incrementaAño() { //ESTE MÉTODO ES UTILIZADO PARA METERLO DENTRO DEL INCREMENTAR MES PARA QUE SUME 1 MÁS SI ES INVOCADO, Y A SU VEZ PARA       
        //  QUE ESTABLEZCA 1 SI SE INTRODUCE AÑO 0 YA QUE ESTE NO EXISTE
        anyo++;
        if (anyo == 0) {
            anyo = 1;
        }
    }

    void mostrar() {
        String ceroDia = dia < 10 ? "0" : "";
        String ceroMes = mes < 10 ? "0" : "";
        System.out.println(ceroDia + dia + "/" + ceroMes + mes + "/" + anyo);
    }

    boolean iguales(Calendario otro) {
        return (this.dia == otro.dia
                && this.mes == otro.mes
                && this.anyo == otro.anyo);
    }
}
