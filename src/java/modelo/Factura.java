
package modelo;


public class Factura {
    
    private int codigoFactura;
    private String NITFactura;
    private String metodoPago;
    private boolean estadoFactura;
    private int codigoPedido;

    public Factura() {
    }

    public Factura(int codigoFactura, String NITFactura, String metodoPago, boolean estadoFactura, int codigoPedido) {
        this.codigoFactura = codigoFactura;
        this.NITFactura = NITFactura;
        this.metodoPago = metodoPago;
        this.estadoFactura = estadoFactura;
        this.codigoPedido = codigoPedido;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public String getNITFactura() {
        return NITFactura;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public boolean getEstadoFactura() {
        return estadoFactura;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public void setNITFactura(String NITFactura) {
        this.NITFactura = NITFactura;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setEstadoFactura(boolean estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }
    
    
    
    
    
}
