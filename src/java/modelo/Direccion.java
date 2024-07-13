package modelo;


public class Direccion {
    private int Direccion;
    private double total;
    private double impuesto;
    private String descripcionCarrito;
    private int codigoDetalleCarrito;
    private int codigoPedido;

    public int getDireccion() {
        return Direccion;
    }

    public void setDireccion(int Direccion) {
        this.Direccion = Direccion;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public String getDescripcionCarrito() {
        return descripcionCarrito;
    }

    public void setDescripcionCarrito(String descripcionCarrito) {
        this.descripcionCarrito = descripcionCarrito;
    }

    public int getCodigoDetalleCarrito() {
        return codigoDetalleCarrito;
    }

    public void setCodigoDetalleCarrito(int codigoDetalleCarrito) {
        this.codigoDetalleCarrito = codigoDetalleCarrito;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }
    
}
