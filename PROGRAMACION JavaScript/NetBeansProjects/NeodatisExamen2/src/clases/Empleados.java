package clases;

public class Empleados {

    private String id;
    private String nombre;
    private int salario;
    private String fechaalta;

    public String getFechaalta() {
        return fechaalta;
    }

    public Empleados(String id, String nombre, int salario, String fechaalta) {
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
        this.fechaalta = fechaalta;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalario() {
        return salario;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public void setFechaalta(String fechaalta) {
        this.fechaalta = fechaalta;
    }

}
