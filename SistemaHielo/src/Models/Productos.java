package Models;
import java.time.LocalDate;

public class Productos {
    private int id, peso, stock;
    private String codigo, nombre, descripcion, tipo_hielo, estado;
    private double precio;
    private LocalDate fecha_registro;
    
    public Productos(){
    }

    public Productos(int id, int peso, int stock, String codigo, String nombre, String descripcion, String tipo_hielo, String estado, double precio, LocalDate fecha_registro) {
        this.id = id;
        this.peso = peso;
        this.stock = stock;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo_hielo = tipo_hielo;
        this.estado = estado;
        this.precio = precio;
        this.fecha_registro = fecha_registro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo_hielo() {
        return tipo_hielo;
    }

    public void setTipo_hielo(String tipo_hielo) {
        this.tipo_hielo = tipo_hielo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
}
