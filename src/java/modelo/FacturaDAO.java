
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class FacturaDAO {
    
    // variables para el CRUD    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;   


 // Elementos del CRUD
    //Listar-Facturas
    
    public List listar(){
        String sql = "select * from Factura";
        List <Factura> listaFactura = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Factura fac = new Factura();
                fac.setCodigoFactura(rs.getInt(1));
                fac.setNITFactura(rs.getString(2));
                fac.setMetodoPago(rs.getString(3));
                fac.setEstadoFactura(rs.getBoolean(4));
                fac.setCodigoPedido(rs.getInt(5));
                listaFactura.add(fac);  
            }    
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaFactura;      
    }        
    
    //Agregar-Factura
    
    public int Agregar(Factura fac){
       String sql = "insert into Factura (NITFactura, metodoPago, estadoFactura, codigoPedido) values (?,?,?,?)"; 
       try{
          con = cn.Conexion();
          ps = con.prepareStatement(sql);
          ps.setString(1, fac.getNITFactura());
          ps.setString(2, fac.getMetodoPago());
          ps.setBoolean(3, fac.getEstadoFactura());
          ps.setInt(4, fac.getCodigoPedido());
          ps.executeUpdate();
       
       
       
       }catch(Exception e){
           e.printStackTrace();
       }        
        return resp;
    }

    //Buscar-Factura
    public Factura listarCodigoFactura(int id){
    
    Factura fac = new Factura();
    String sql = "Select * from Factura where codigoFactura = "+ id;
    
    try{
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
    
    while(rs.next()){
        fac.setNITFactura(rs.getString(2));
        fac.setMetodoPago(rs.getString(3));
        fac.setEstadoFactura(rs.getBoolean(4));
        fac.setCodigoPedido(rs.getInt(5));
        }
    }catch(Exception e){
        e.printStackTrace();   
    }  
        return fac;
    }
    
    //Editar-Factura
    public int actualizar (Factura fac){
    String sql = "Update Factura set NITFactura = ?, metodoPago = ?, estadoFactura = ? where codigoFactura = ?";
    
    try{
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        ps.setString(1, fac.getNITFactura());
        ps.setString(2, fac.getMetodoPago());
        ps.setBoolean(3, fac.getEstadoFactura());
        ps.setInt(4,fac.getCodigoFactura());
        ps.executeUpdate();    
    }catch(Exception e){
        e.printStackTrace();
    }
    return resp;
    }
    
    //Eliminar-Factura
    public void eliminar(int id){
    String sql ="Delete from Factura where codigoFactura = "+ id;
        try{
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        ps.executeUpdate();
        }catch(Exception e){
        e.printStackTrace();
        }
    }   
}

