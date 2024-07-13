
package modelo;


public class Locales {
    private int codigoLocal;
    private String nombreLocal;
    private String horariosLocal;
    private String horarioEspecialLocal;
    private String telefonoLocal;
    private int codigoDireccion;

    public Locales() {
    }

    public Locales(int codigoLocal, String nombreLocal, String horariosLocal, String horarioEspecialLocal, String telefonoLocal, int codigoDireccion) {
        this.codigoLocal = codigoLocal;
        this.nombreLocal = nombreLocal;
        this.horariosLocal = horariosLocal;
        this.horarioEspecialLocal = horarioEspecialLocal;
        this.telefonoLocal = telefonoLocal;
        this.codigoDireccion = codigoDireccion;
    }

    public int getCodigoLocal() {
        return codigoLocal;
    }

    public void setCodigoLocal(int codigoLocal) {
        this.codigoLocal = codigoLocal;
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    public String getHorariosLocal() {
        return horariosLocal;
    }

    public void setHorariosLocal(String horariosLocal) {
        this.horariosLocal = horariosLocal;
    }

    public String getHorarioEspecialLocal() {
        return horarioEspecialLocal;
    }

    public void setHorarioEspecialLocal(String horarioEspecialLocal) {
        this.horarioEspecialLocal = horarioEspecialLocal;
    }

    public String getTelefonoLocal() {
        return telefonoLocal;
    }

    public void setTelefonoLocal(String telefonoLocal) {
        this.telefonoLocal = telefonoLocal;
    }

    public int getCodigoDireccion() {
        return codigoDireccion;
    }

    public void setCodigoDireccion(int codigoDireccion) {
        this.codigoDireccion = codigoDireccion;
    }
    
    
}
