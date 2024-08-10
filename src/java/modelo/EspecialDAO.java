
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EspecialDAO {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    
    //Metodo Listar
    public List listar(){
        String sql = "select * from especial";
        List<Especial> listaEspecial = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Especial es = new Especial();
                es.setCodigoEspecial(rs.getInt(1));
                es.setFechaEspecial(rs.getDate(2));
                es.setCantidadPorciones(rs.getString(3));
                es.setMasa(rs.getString(4));
                es.setRelleno(rs.getString(5));
                es.setCobertura(rs.getString(6));
                es.setDescripcionEspecial(rs.getString(7));
                listaEspecial.add(es);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaEspecial;
    }
    
    //Metodo Agregar
    public int agregar (Especial esp){
        String sql = "insert into Especial(fechaEspecial, cantidadPorciones, masa, relleno, cobertura, descripcionEspecial) values (?, ?, ?, ?, ?, ?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDate(1, esp.getFechaEspecial());
            ps.setString(2, esp.getCantidadPorciones());
            ps.setString(3, esp.getMasa());
            ps.setString(4, esp.getRelleno());
            ps.setString(5, esp.getCobertura());
            ps.setString(6, esp.getDescripcionEspecial());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    // Metodo Buscar por código
    public Especial listarCodigoEspecial(int id){
        Especial esp = new Especial();
        String sql = "Select * from Especial where codigoEspecial ="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                esp.setFechaEspecial(rs.getDate(2));
                esp.setCantidadPorciones(rs.getString(3));
                esp.setMasa(rs.getString(4));
                esp.setRelleno(rs.getString(5));
                esp.setCobertura(rs.getString(6));
                esp.setDescripcionEspecial(rs.getString(7));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return esp;    
    }
    
    // Metodo Editar
    public int actualizar (Especial esp){
        String sql = "Update Especial set fechaEspecial= ?, cantidadPorciones = ?, masa = ?,relleno = ?, cobertura = ?, descripcionEspecial= ? where codigoEspecial = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDate(1, esp.getFechaEspecial());
            ps.setString(2, esp.getCantidadPorciones());
            ps.setString(3, esp.getMasa());
            ps.setString(4, esp.getRelleno());
            ps.setString(5, esp.getCobertura());
            ps.setString(6, esp.getDescripcionEspecial());
            ps.setInt(7, esp.getCodigoEspecial());
            ps.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    //Metodo Eliminar
    public void eliminar (int id){
        String sql ="delete from especial where codigoEspecial ="+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
	