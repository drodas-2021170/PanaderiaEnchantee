
package modelo;


public class Carrito {
    private int codigoCarrito;
    private double total;
    private double impuesto;
    private String descripcionCarrito;
    private int codigoPedido;
    private int codigoEspecial;
    private int codigoProducto;
    private int item;
    private double precio;
    private int cantidad;
    private double subTotal;
    
    public Carrito(){
    
    }

    public Carrito(int codigoCarrito, double total, double impuesto, String descripcionCarrito, int codigoPedido, int codigoEspecial, int codigoProducto, int item, double precio, int cantidad, double subTotal) {
        this.codigoCarrito = codigoCarrito;
        this.total = total;
        this.impuesto = impuesto;
        this.descripcionCarrito = descripcionCarrito;
        this.codigoPedido = codigoPedido;
        this.codigoEspecial = codigoEspecial;
        this.codigoProducto = codigoProducto;
        this.item = item;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
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

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public int getCodigoEspecial() {
        return codigoEspecial;
    }

    public void setCodigoEspecial(int codigoEspecial) {
        this.codigoEspecial = codigoEspecial;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    
    

  
 
    
   
    
}
