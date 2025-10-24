package Models;

public class Detalle {
    private int idDetalle, idVenta, cantidad;
    private String codigoProducto, nombreProducto, tipo;
    private double peso, precioUnitario, subtotal;

    public Detalle() {
    }

    public Detalle(int idDetalle, int idVenta, int cantidad, String codigoProducto, String nombreProducto, String tipo, double peso, double precioUnitario, double subtotal) {
        this.idDetalle = idDetalle;
        this.idVenta = idVenta;
        this.cantidad = cantidad;
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.tipo = tipo;
        this.peso = peso;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    
}
