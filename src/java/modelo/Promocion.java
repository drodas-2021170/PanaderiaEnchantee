package modelo;

import java.util.Date;

public class Promocion {
    private int codigoPromocion;
    private String nombrePromocion;
    private Date fechaInicio;
    private Date fechaFin;
    private double precioPromocion;
    private int codigoProducto;

    public Promocion() {
    }

    public Promocion(int codigoPromocion, String nombrePromocion, Date fechaInicio, Date fechaFin, double precioPromocion, int codigoProducto) {
        this.codigoPromocion = codigoPromocion;
        this.nombrePromocion = nombrePromocion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioPromocion = precioPromocion;
        this.codigoProducto = codigoProducto;
    }

    public int getCodigoPromocion() {
        return codigoPromocion;
    }

    public void setCodigoPromocion(int codigoPromocion) {
        this.codigoPromocion = codigoPromocion;
    }

    public String getNombrePromocion() {
        return nombrePromocion;
    }

    public void setNombrePromocion(String nombrePromocion) {
        this.nombrePromocion = nombrePromocion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getPrecioPromocion() {
        return precioPromocion;
    }

    public void setPrecioPromocion(double precioPromocion) {
        this.precioPromocion = precioPromocion;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
    
    
}
