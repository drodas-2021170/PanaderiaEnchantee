package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    
    
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
    
    //Listar
    public List listar(){
        String sql = "Select * from Usuario";
        List<Usuario> listaUsuario = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps  = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Usuario usu = new Usuario();
                usu.setCodigoUsuario(rs.getInt(1));
                usu.setNombresUsuario(rs.getString(2));
                usu.setApellidosUsuario(rs.getString(3));
                usu.setTelefonoUsuario(rs.getString(4));
                usu.setCorreoUsuario(rs.getString(5));
                usu.setUsuario(rs.getString(6));
                usu.setContrasena(rs.getString(7));
                usu.setCodigoTipoUsuario(rs.getInt(8));
                listaUsuario.add(usu);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaUsuario;
    }
    
    //Agregar
    public int agregar(Usuario usu){
        String sql = "insert into Usuario(nombresUsuario, apellidosUsuario, telefonoUsuario, correoUsuario, usuario, contrasena, codigoTipoUsuario) values(?,?,?,?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1,usu.getNombresUsuario());
            ps.setString(2, usu.getApellidosUsuario());
            ps.setString(3,usu.getTelefonoUsuario());
            ps.setString(4, usu.getCorreoUsuario());
            ps.setString(5, usu.getUsuario());
            ps.setString(6,usu.getContrasena());
            ps.setInt(7,usu.getCodigoTipoUsuario());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    //Buscar
    
    public Usuario listarCodigoUsuario(int id){
        Usuario usu = new Usuario();
        String sql= "select * from Usuario where codigoUsuario=" +id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                usu.setNombresUsuario(rs.getString(2));
                usu.setApellidosUsuario(rs.getString(3));
                usu.setTelefonoUsuario(rs.getString(4));
                usu.setCorreoUsuario(rs.getString(5));
                usu.setUsuario(rs.getString(6));
                usu.setContrasena(rs.getString(7));
                usu.setCodigoTipoUsuario(rs.getInt(8));
            }
        }catch(Exception e){
            e.printStackTrace();
        }  
        return usu;
    }
    
    //Update
    public int actualizar(Usuario usu){
        String sql="Update Usuario set nombresUsuario = ?, apellidosUsuario =?, telefonoUsuario=?,correoUsuario=?,usuario=?,contrasena=? where codigoUsuario=?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getNombresUsuario());
            ps.setString(2, usu.getApellidosUsuario());
            ps.setString(3, usu.getTelefonoUsuario());
            ps.setString(4, usu.getCorreoUsuario());
            ps.setString(5, usu.getUsuario());
            ps.setString(6, usu.getContrasena());
            ps.setInt(7,usu.getCodigoUsuario());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    //Eliminar
    public void eliminar(int id){
        String sql = "delete from Usuario where codigoUsuario=?"+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}


