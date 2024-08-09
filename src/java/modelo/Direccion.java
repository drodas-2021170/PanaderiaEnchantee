package modelo;


public class Direccion {
    private int codigoDireccion;
    private String direccionCompleta;
    private String departamento;
    private String municipio;
    private String otro;

    public Direccion() {
    }

    public Direccion(int codigoDireccion, String direccionCompleta, String departamento, String municipio, String otro) {
        this.codigoDireccion = codigoDireccion;
        this.direccionCompleta = direccionCompleta;
        this.departamento = departamento;
        this.municipio = municipio;
        this.otro = otro;
    }

    public int getCodigoDireccion() {
        return codigoDireccion;
    }

    public void setCodigoDireccion(int codigoDireccion) {
        this.codigoDireccion = codigoDireccion;
    }

    public String getDireccionCompleta() {
        return direccionCompleta;
    }

    public void setDireccionCompleta(String direccionCompleta) {
        this.direccionCompleta = direccionCompleta;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getOtro() {
        return otro;
    }

    public void setOtro(String otro) {
        this.otro = otro;
    }
    
}