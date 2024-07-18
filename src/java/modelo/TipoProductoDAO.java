
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TipoProductoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    // Metodo Listar
    
    public List listar(){
        String sql = "Select * from TipoProducto";
        List<TipoProducto> listaTipoProducto = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                TipoProducto tipo = new TipoProducto();
                tipo.setCodigoTipoProducto(rs.getInt(1));
                tipo.setNombreTipoProducto(rs.getString(2));
                tipo.setDescripcion(rs.getString(3));
                tipo.setTemporada(rs.getString(4));
                listaTipoProducto.add(tipo);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaTipoProducto;
    }
    
    // Metodo Agregar
    public int agregar(TipoProducto tipo){
        String sql = "insert into TipoProducto(codigoTipoProducto, nombreTipoProducto, descripcion, temporada) values(?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1,tipo.getNombreTipoProducto());
            ps.setString(2, tipo.getDescripcion());
            ps.setString(3, tipo.getTemporada());
            ps.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    // Metodo Buscar
    
    public TipoProducto listarCodigoTipoProducto(int id){
        TipoProducto tipo = new TipoProducto();
        String sql = "select * from TipoProducto where codigoTipoProducto =" +id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                tipo.setNombreTipoProducto(rs.getString(sql));
                tipo.setDescripcion(rs.getString(sql));
                tipo.setTemporada(rs.getString(sql));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return tipo;
    }
    
    // Metodo Actualizar 
    public int actualizar(TipoProducto tipo){
        String sql = "Update TipoProducto set nombreTipoProducto = ?, descripcion = ?, temporada = ? where codigoTipoProducto = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, tipo.getNombreTipoProducto());
            ps.setString(2, tipo.getDescripcion());
            ps.setString(3, tipo.getTemporada());
            ps.setInt(4, tipo.getCodigoTipoProducto());
            ps.executeUpdate();
        }catch(Exception e ){
            e.printStackTrace();
        }
        
        return resp;
    }
    
    // Metodo Eliminar
    public void Eliminar(int id){
        String sql = "delete from TipoProducto where codigoTipoProducto =? "+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
