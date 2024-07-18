package modelo;

public class DetalleCarrito {
    
    private int codigoDetalleCarrito;
    private int cantidad;
    private double subtotal;
    private int codigoProducto;
    private int codigoEspecial;

    public DetalleCarrito() {
    }

    public DetalleCarrito(int codigoDetalleCarrito, int cantidad, double subtotal, int codigoProducto, int codigoEspecial) {
        this.codigoDetalleCarrito = codigoDetalleCarrito;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.codigoProducto = codigoProducto;
        this.codigoEspecial = codigoEspecial;
    }

    public int getCodigoDetalleCarrito() {
        return codigoDetalleCarrito;
    }

    public void setCodigoDetalleCarrito(int codigoDetalleCarrito) {
        this.codigoDetalleCarrito = codigoDetalleCarrito;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCodigoEspecial() {
        return codigoEspecial;
    }

    public void setCodigoEspecial(int codigoEspecial) {
        this.codigoEspecial = codigoEspecial;
    }
    
    
}
