
package modelo;
    
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LocalesDAO {
   Conexion cn = new Conexion();
   Connection con;
   PreparedStatement ps;
   ResultSet rs;
   int resp;
   
   
   //Listar 
   public List listar(){
   String sql = "Select * from Locales";
    List<Locales> listaLocales = new ArrayList<>();
    try{
    con = cn.Conexion();
    ps = con.prepareStatement(sql);
    rs = ps.executeQuery();
    while(rs.next()){
        Locales loc = new Locales();
        loc.setCodigoLocal(rs.getInt(1));
        loc.setNombreLocal(rs.getString(2));
        loc.setHorariosLocal(rs.getString(3));
        loc.setHorarioEspecialLocal(rs.getString(4));
        loc.setTelefonoLocal(rs.getString(5));
        loc.setCodigoDireccion(rs.getInt(6));
        listaLocales.add(loc);
    
    }
    
    }catch(Exception e){
        e.printStackTrace();
    
    }
   return listaLocales;
   }
   //Agregar
   public int agregar (Locales loc){
   String sql = "INSERT INTO Locales (codigoLocal, nombreLocal, horariosLocal,horarioEspecialLocal, telefonoLocal,codigoDireccion)VALUES (?,? ,? ,? ,?,? )";
   try{
       con = cn.Conexion();
       ps = con.prepareStatement(sql);
       ps.setInt(1, loc.getCodigoLocal());
       ps.setString(2, loc.getNombreLocal());
       ps.setString(3, loc.getHorariosLocal());
       ps.setString(4, loc.getHorarioEspecialLocal());
       ps.setString(5,loc.getTelefonoLocal());
       ps.setInt(6, loc.getCodigoDireccion());
       ps.executeUpdate();
   }catch(Exception e){
       e.printStackTrace();
   
   }
   return resp;
   
   
   }
   //Buscar
   
   public Locales listarCodigoLocales(int id){
       Locales loc = new Locales();
       String sql = "Select * from Locales where codigoLocal="+id;
       try{
           con= cn.Conexion();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
       while(rs.next()){
           loc.setNombreLocal(rs.getString(2));
           loc.setHorariosLocal(rs.getString(3));
           loc.setHorarioEspecialLocal(rs.getString(4));
           loc.setTelefonoLocal(rs.getString(5));
           loc.setCodigoDireccion(rs.getInt(6));
            }
     
       }catch(Exception e){
           e.printStackTrace();
       
       }
    return loc;
   }
   //Actualizar
   
   public int actualizar (Locales loc){
       String sql = "UPDATE Locales SET nombreLocal=? ,horariosLocal = ?, horarioEspecialLocal = ?,telefonoLocal=? WHERE codigoLocal = ?";
       try{
           con = cn.Conexion();
           ps = con.prepareStatement(sql);
           ps.setString(1, loc.getNombreLocal());
           ps.setString(2, loc.getHorariosLocal());
           ps.setString(3, loc.getHorarioEspecialLocal());
           ps.setString(4, loc.getTelefonoLocal());
           ps.setInt(5,loc.getCodigoLocal());
           ps.executeUpdate();
       }catch(Exception e){
           e.printStackTrace();
       }
       return resp;
   }
   
   //Eliminar 
   public void eliminar (int id){
       String sql = "delete from Locales where codigoLocal="+id;
       try{
           con = cn.Conexion();
           ps = con.prepareStatement(sql);
           ps.executeUpdate();
       }catch(Exception e){
           e.printStackTrace();
       }
    }
}
