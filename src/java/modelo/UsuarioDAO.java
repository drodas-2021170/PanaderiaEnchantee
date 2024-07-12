package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public Usuario Validar(String usuario, String contrasena){
        Usuario user = new Usuario();
        String sql = "select * from Usuario where usuario = ? and contrasena=?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            rs = ps.executeQuery();
            while(rs.next()){
                user.setCodigoUsuario(rs.getInt("codigoUsuario"));
                user.setNombresUsuario(rs.getString("nombresUsuario"));
                user.setApellidosUsuario(rs.getString("apellidosUsuario"));
                user.setCorreoUsuario(rs.getString("correoUsuario"));
                user.setUsuario(rs.getString("usuario"));
                user.setContrasena(rs.getString("contrasena"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    } 
    
}
