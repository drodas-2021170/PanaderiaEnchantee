package modelo;


public class TipoUsuario {
    private int codigoTipoUsuario;
    private String nombreTipoUsuario;
    private String descripcion;
    private String permisos;
    private boolean estado;
    
    
    public TipoUsuario() {
    }

    public TipoUsuario(int codigoTipoUsuario, String nombreTipoUsuario, String descripcion, String permisos, boolean estado) {
        this.codigoTipoUsuario = codigoTipoUsuario;
        this.nombreTipoUsuario = nombreTipoUsuario;
        this.descripcion = descripcion;
        this.permisos = permisos;
        this.estado = estado;
    }

    public int getCodigoTipoUsuario() {
        return codigoTipoUsuario;
    }

    public void setCodigoTipoUsuario(int codigoTipoUsuario) {
        this.codigoTipoUsuario = codigoTipoUsuario;
    }

    public String getNombreTipoUsuario() {
        return nombreTipoUsuario;
    }

    public void setNombreTipoUsuario(String nombreTipoUsuario) {
        this.nombreTipoUsuario = nombreTipoUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "TipoUsuario{" + "codigoTipoUsuario=" + codigoTipoUsuario + ", nombreTipoUsuario=" + nombreTipoUsuario + ", descripcion=" + descripcion + ", permisos=" + permisos + ", estado=" + estado + '}';
    }
    
    
    
}
