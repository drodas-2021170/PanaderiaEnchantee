
package modelo;


public class Pedido {
    private int codigoPedido;
    private String nombreReceptor;
    private String apellidoReceptor;
    private String telefonoReceptor;
    private String telefonoSecundario;
    private String correoReceptor;
    private int codigoDireccion;
    private int codigoUsuario;

    public Pedido() {
    }

    public Pedido(int codigoPedido, String nombreReceptor, String apellidoReceptor, String telefonoReceptor, String telefonoSecundario, String correoReceptor, int codigoDireccion, int codigoUsuario) {
        this.codigoPedido = codigoPedido;
        this.nombreReceptor = nombreReceptor;
        this.apellidoReceptor = apellidoReceptor;
        this.telefonoReceptor = telefonoReceptor;
        this.telefonoSecundario = telefonoSecundario;
        this.correoReceptor = correoReceptor;
        this.codigoDireccion = codigoDireccion;
        this.codigoUsuario = codigoUsuario;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public String getNombreReceptor() {
        return nombreReceptor;
    }

    public void setNombreReceptor(String nombreReceptor) {
        this.nombreReceptor = nombreReceptor;
    }

    public String getApellidoReceptor() {
        return apellidoReceptor;
    }

    public void setApellidoReceptor(String apellidoReceptor) {
        this.apellidoReceptor = apellidoReceptor;
    }

    public String getTelefonoReceptor() {
        return telefonoReceptor;
    }

    public void setTelefonoReceptor(String telefonoReceptor) {
        this.telefonoReceptor = telefonoReceptor;
    }

    public String getTelefonoSecundario() {
        return telefonoSecundario;
    }

    public void setTelefonoSecundario(String telefonoSecundario) {
        this.telefonoSecundario = telefonoSecundario;
    }

    public String getCorreoReceptor() {
        return correoReceptor;
    }

    public void setCorreoReceptor(String correoReceptor) {
        this.correoReceptor = correoReceptor;
    }

    public int getCodigoDireccion() {
        return codigoDireccion;
    }

    public void setCodigoDireccion(int codigoDireccion) {
        this.codigoDireccion = codigoDireccion;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }
}