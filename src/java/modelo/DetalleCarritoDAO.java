
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DetalleCarritoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    //Listar
    public List listar(){
        String sql = "select * from DetalleCarrito";
        List<DetalleCarrito>listaDetalleCarrito = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                DetalleCarrito det = new DetalleCarrito();
                det.setCodigoDetalleCarrito(rs.getInt(1));
                det.setCantidad(rs.getInt(2));
                det.setSubtotal(rs.getDouble(3));
                det.setCodigoProducto(rs.getInt(4));
                det.setCodigoEspecial(rs.getInt(5));
                listaDetalleCarrito.add(det);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaDetalleCarrito;
    }
    
    
    //Agregar
    public int agregar(DetalleCarrito det){
        String sql = "insert into DetalleCarrito(cantidad, subtotal, codigoProducto, codigoEspecial)values(?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1,det.getCantidad());
            ps.setDouble(2,det.getSubtotal());
            ps.setInt(3,det.getCodigoProducto());
            ps.setInt(4,det.getCodigoEspecial());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    //Buscar
    public DetalleCarrito listarCodigoDetalleCarrito(int id){
        DetalleCarrito det = new DetalleCarrito();
        String sql = "select * from DetalleCarrito where codigoDetalleCarrito =" +id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                det.setCantidad(rs.getInt(2));
                det.setSubtotal(rs.getDouble(3));
                det.setCodigoProducto(rs.getInt(4));
                det.setCodigoEspecial(rs.getInt(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return det;
    }
    
    //Actualizar
    public int actualizar(DetalleCarrito det){
        String sql = "Update DetalleCarrito set cantidad = ?, set subtotal = ?, set codigoProducto = ?, set codigoEspecial = ? where codigoDetalleCarrito = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1,det.getCantidad());
            ps.setDouble(2,det.getSubtotal());
            ps.setInt(3,det.getCodigoProducto());
            ps.setInt(4,det.getCodigoEspecial());
            ps.setInt(6,det.getCodigoDetalleCarrito());
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    //Eliminar
    public void eliminar(int id){
        String sql = "delete form DetalleCarrito where codigoDetalleCarrito =" +id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    

}