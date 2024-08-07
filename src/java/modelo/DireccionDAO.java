package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DireccionDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    
    // Metodo de Agregar
    public int agregar(Direccion dir) {
        String sql  = "insert into Direccion (total, impuesto, descripcionCarrito, codigoDetalleCarrito, codigoPedido) values (?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, dir.getTotal());
            ps.setDouble(1, dir.getImpuesto());
            ps.setString(3, dir.getDescripcionCarrito());
            ps.setInt(4, dir.getCodigoDetalleCarrito());
            ps.setInt(5, dir.getCodigoPedido());
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    // Metodo de buscar
    public Direccion listarDireccion(int id) {
        Direccion dir = new Direccion();
        String sql = "select * from Direccion where Direccion =" +id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                dir.setDireccion(rs.getInt(1));
                dir.setTotal(rs.getDouble(2));
                dir.setImpuesto(rs.getDouble(3));
                dir.setDescripcionCarrito(rs.getString(4));
                dir.setCodigoDetalleCarrito(rs.getInt(5));
                dir.setCodigoPedido(rs.getInt(6));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return dir;
    }
    
    
    // Metodo de Editar
    public int actualizar(Direccion dir) {
        String sql = "Update Direccion set Total = ?,Impuesto = ?,descripcionCarrito = ?,codigoDetalleCarrito = ?,codigoPedido = ? where Direccion = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, dir.getTotal());
            ps.setDouble(2, dir.getImpuesto());
            ps.setString(3, dir.getDescripcionCarrito());
            ps.setInt(4, dir.getCodigoDetalleCarrito());
            ps.setInt(5, dir.getCodigoPedido());
            ps.setInt(6, dir.getDireccion());
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    
    // Metodo de Eliminar
    public void eliminar(int id) {
        String sql = "DELETE FROM Direccion WHERE Direccion =" + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}