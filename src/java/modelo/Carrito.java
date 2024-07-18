
package modelo;


public class Carrito {
    private int codigoCarrito;
    private double total;
    private double impuesto;
    private String descripcionCarrito;
    private int codigoDetalleCarrito;
    private int codigoPedido;
 
    public Carrito (){
        
    }

    public Carrito(int codigoCarrito, double total, double impuesto, String descripcionCarrito, int codigoDetalleCarrito, int codigoPedido) {
        this.codigoCarrito = codigoCarrito;
        this.total = total;
        this.impuesto = impuesto;
        this.descripcionCarrito = descripcionCarrito;
        this.codigoDetalleCarrito = codigoDetalleCarrito;
        this.codigoPedido = codigoPedido;
    }

    public int getCodigoCarrito() {
        return codigoCarrito;
    }

    public void setCodigoCarrito(int codigoCarrito) {
        this.codigoCarrito = codigoCarrito;
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
