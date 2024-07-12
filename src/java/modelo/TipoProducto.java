/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author julia
 */
public class TipoProducto {
    private int codigoTipoProducto;
    private String nombreTipoProducto;
    private String descripcion;
    private String temporada;

    public TipoProducto() {
    }

    public TipoProducto(int codigoTipoProducto, String nombreTipoProducto, String descripcion, String temporada) {
        this.codigoTipoProducto = codigoTipoProducto;
        this.nombreTipoProducto = nombreTipoProducto;
        this.descripcion = descripcion;
        this.temporada = temporada;
    }

    public int getCodigoTipoProducto() {
        return codigoTipoProducto;
    }

    public void setCodigoTipoProducto(int codigoTipoProducto) {
        this.codigoTipoProducto = codigoTipoProducto;
    }

    public String getNombreTipoProducto() {
        return nombreTipoProducto;
    }

    public void setNombreTipoProducto(String nombreTipoProducto) {
        this.nombreTipoProducto = nombreTipoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }
}
