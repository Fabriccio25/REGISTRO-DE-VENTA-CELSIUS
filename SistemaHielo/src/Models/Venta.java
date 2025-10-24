package Models;

public class Venta {
    private int idVenta; 
    private String dniCliente, nombreCliente, fechaVenta, metodoPago, estado;
    private double totalPagar;

    public Venta() {
    }

    public Venta(int idVenta, String dniCliente, String nombreCliente, String fechaVenta, String metodoPago, String estado, double totalPagar) {
        this.idVenta = idVenta;
        this.dniCliente = dniCliente;
        this.nombreCliente = nombreCliente;
        this.fechaVenta = fechaVenta;
        this.metodoPago = metodoPago;
        this.estado = estado;
        this.totalPagar = totalPagar;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }
    
    
}
   