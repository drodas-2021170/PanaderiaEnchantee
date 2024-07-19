package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PromocionDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List listar(){
        String sql = "SELECT * FROM Promocion";
        List<Promocion> listaPromocion = new ArrayList<>();
        try{
            Promocion promo = new Promocion();
            promo.setCodigoPromocion(rs.getInt(1));
            promo.setNombrePromocion(rs.getString(2));
            promo.setFechaInicio(rs.getDate(3));
            promo.setFechaFin(rs.getDate(4));
            promo.setPrecioPromocion(rs.getDouble(5));
            promo.setCodigoProducto(rs.getInt(6));
            listaPromocion.add(promo);
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaPromocion;
    }
    
    public int agregar(Promocion promo){
        String sql = "INSERT INTO Promocion (nombrePromocion, fechaInicio, fechaFin, precioPromocion, codigoProducto) VALUES (?,?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, promo.getNombrePromocion());
            ps.setDate(2, (Date) promo.getFechaInicio());
            ps.setDate(3, (Date) promo.getFechaFin());
            ps.setDouble(4, promo.getPrecioPromocion());
            ps.setInt(5, promo.getCodigoProducto());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    public Promocion listarCodigoPromocion(int id){
        Promocion promo = new Promocion();
        String sql = "SELECT * FROM Promocion WHERE codigoPromocion = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                promo.setNombrePromocion(rs.getString(2));
                promo.setFechaInicio(rs.getDate(3));
                promo.setFechaFin(rs.getDate(4));
                promo.setPrecioPromocion(rs.getDouble(5));
                promo.setCodigoProducto(rs.getInt(6));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return promo;
    }
    
    public int editar(Promocion promo){
        String sql = "UPDATE Promocion SET nombrePromocion = ?, fechaInicio = ?, fechaFin = ?, precioPromocion = ? WHERE codigoPromocion = ?;";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, promo.getNombrePromocion());
            ps.setDate(2, (Date) promo.getFechaInicio());
            ps.setDate(3, (Date) promo.getFechaFin());
            ps.setDouble(4, promo.getPrecioPromocion());
            ps.setInt(5, promo.getCodigoPromocion());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    public void eliminar(int id){
        String sql = "DELETE FROM Promocion WHERE codigoPromocion = "+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
