package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DireccionDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    
    //Metodo de Listar
    public List<Direccion> listar() {
        String sql = "select * from Direccion";
        List<Direccion> listaDireccion = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Direccion dir = new Direccion();
                dir.setCodigoDireccion(rs.getInt(1));
                dir.setDireccionCompleta(rs.getString(2));
                dir.setDepartamento(rs.getString(3));
                dir.setMunicipio(rs.getString(4));
                dir.setOtro(rs.getString(5));
                listaDireccion.add(dir);
            }
        }catch (Exception e) {
    }
    return listaDireccion;
}
    
    // Metodo de Agregar
    public int agregar(Direccion dir) {
        String sql  = "insert into Direccion ( direccionCompleta, departamento, municipio, otro) values (?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, dir.getDireccionCompleta());
            ps.setString(2, dir.getDepartamento());
            ps.setString(3, dir.getMunicipio());
            ps.setString(4, dir.getOtro());
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    // Metodo de buscar
    public Direccion listarDireccion(int id) {
        Direccion dir = new Direccion();
        String sql = "select * from Direccion where codigoDireccion =" +id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                dir.setCodigoDireccion(rs.getInt(1));
                dir.setDireccionCompleta(rs.getString(2));
                dir.setDepartamento(rs.getString(3));
                dir.setMunicipio(rs.getString(4));
                dir.setOtro(rs.getString(5));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return dir;
    }
    
    
    // Metodo de Editar
    public int actualizar(Direccion dir) {
        String sql = "Update Direccion set direccionCompleta = ?,departamento = ?,municipio = ?,otro = ? where codigoDireccion = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, dir.getDireccionCompleta());
            ps.setString(2, dir.getDepartamento());
            ps.setString(3, dir.getMunicipio());
            ps.setString(4, dir.getOtro());
            ps.setInt(5, dir.getCodigoDireccion());
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    
    
    // Metodo de Eliminar
    public void eliminar(int id) {
        String sql = "DELETE FROM Direccion WHERE codigoDireccion =" + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}