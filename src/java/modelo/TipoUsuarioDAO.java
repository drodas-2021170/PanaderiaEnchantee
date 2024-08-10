package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class TipoUsuarioDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;


    //Metodo Listar
    public List listar() {
        String sql = "select * from tipoUsuario";
        List <TipoUsuario> listaTipoUsuario = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                TipoUsuario user = new TipoUsuario();
                user.setCodigoTipoUsuario(rs.getInt(1));
                user.setNombreTipoUsuario(rs.getString(2));
                user.setDescripcion(rs.getString(3));
                user.setPermisos(rs.getString(4));
                user.setEstado(rs.getBoolean(5));
                listaTipoUsuario.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaTipoUsuario;
    }


    //Metodo Agregar
    public int agregar (TipoUsuario user) {
        String sql = "insert into TipoUsuario (nombreTipoUsuario, descripcion, permisos, estado) values (?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNombreTipoUsuario());
            ps.setString(2, user.getDescripcion());
            ps.setString(3, user.getPermisos());
            ps.setBoolean(4, user.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }


    //Metodo buscar por codigo

    public TipoUsuario listarCodigoTipoUsuario (int id) {
        TipoUsuario user = new TipoUsuario();
        String sql = "Select * from TipoUsuario where codigoTipoUsuario =" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                user.setNombreTipoUsuario(rs.getString(2));
                user.setDescripcion(rs.getString(3));
                user.setPermisos(rs.getString(4));
                user.setEstado(rs.getBoolean(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    //Metodo Editar

    public int actualizar(TipoUsuario user) {
        String sql = "Update TipoUsuario set nombreTipoUsuario = ?, descripcion = ?, permisos = ?, estado = ? where codigoTipoUsuario = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNombreTipoUsuario());
            ps.setString(2, user.getDescripcion());
            ps.setString(3, user.getPermisos());
            ps.setBoolean(4, user.getEstado());
            ps.setInt(5, user.getCodigoTipoUsuario());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    
    //Metodo Eliminar
    
    public void eliminar (int id) {
        String sql = "delete from TipoUsuario where codigoTipoUsuario =" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
