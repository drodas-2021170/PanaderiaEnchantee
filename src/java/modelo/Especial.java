
package modelo;
import java.sql.Date;

public class Especial {
    private int codigoEspecial;
    private Date fechaEspecial;
    private String cantidadPorciones;
    private String masa;
    private String relleno;
    private String cobertura;
    private String descripcionEspecial;

    public Especial() {
    }

    public Especial(int codigoEspecial, Date fechaEspecial, String cantidadPorciones, String masa, String relleno, String cobertura, String descripcionEspecial) {
        this.codigoEspecial = codigoEspecial;
        this.fechaEspecial = fechaEspecial;
        this.cantidadPorciones = cantidadPorciones;
        this.masa = masa;
        this.relleno = relleno;
        this.cobertura = cobertura;
        this.descripcionEspecial = descripcionEspecial;
    }

    public int getCodigoEspecial() {
        return codigoEspecial;
    }

    public void setCodigoEspecial(int codigoEspecial) {
        this.codigoEspecial = codigoEspecial;
    }

    public Date getFechaEspecial() {
        return fechaEspecial;
    }

    public void setFechaEspecial(Date fechaEspecial) {
        this.fechaEspecial = fechaEspecial;
    }

    public String getCantidadPorciones() {
        return cantidadPorciones;
    }

    public void setCantidadPorciones(String cantidadPorciones) {
        this.cantidadPorciones = cantidadPorciones;
    }

    public String getMasa() {
        return masa;
    }

    public void setMasa(String masa) {
        this.masa = masa;
    }

    public String getRelleno() {
        return relleno;
    }

    public void setRelleno(String relleno) {
        this.relleno = relleno;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

    public String getDescripcionEspecial() {
        return descripcionEspecial;
    }

    public void setDescripcionEspecial(String descripcionEspecial) {
        this.descripcionEspecial = descripcionEspecial;
    }

    

    
    
    
    
}
