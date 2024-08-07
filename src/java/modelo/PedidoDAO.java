/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josem
 */
public class PedidoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    
    //Elementos Del CRUD
    //Listar
    public List listar(){
        String sql = "Select * From Pedido";
        List<Pedido> listaPedido = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Pedido pedido = new Pedido();
                pedido.setCodigoPedido(rs.getInt(1));
                pedido.setNombreReceptor(rs.getString(2));
                pedido.setApellidoReceptor(rs.getString(3));
                pedido.setTelefonoReceptor(rs.getString(4));
                pedido.setTelefonoSecundario(rs.getString(5));
                pedido.setCorreoReceptor(rs.getString(6));
                pedido.setCodigoDireccion(rs.getInt(7));
                pedido.setCodigoUsuario(rs.getInt(8));
            }           
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaPedido;
    }
    
    
    //Agregar
    public int agregar(Pedido pedido){
        String sql = "insert into Pedido(NombreReceptor,ApellidoReceptor,TelefonoReceptor,TelefonoSecundario,CorreoReceptor,CodigoDireccion,CodigoUsuario) value(?,?,?,?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, pedido.getNombreReceptor());
            ps.setString(2, pedido.getApellidoReceptor());
            ps.setString(3, pedido.getTelefonoReceptor());
            ps.setString(4, pedido.getTelefonoSecundario());
            ps.setString(5, pedido.getCorreoReceptor());
            ps.setInt(6, pedido.getCodigoDireccion());
            ps.setInt(7, pedido.getCodigoUsuario());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    
    //Bucar por codigo
    public Pedido listarCodigoPedido(int id){
        Pedido pedido = new Pedido();
        String sql = "Select * From Pedido where CodigoPedido = " + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                pedido.setNombreReceptor(rs.getString(2));
                pedido.setApellidoReceptor(rs.getString(3));
                pedido.setTelefonoReceptor(rs.getString(4));
                pedido.setTelefonoSecundario(rs.getString(5));
                pedido.setCorreoReceptor(rs.getString(6));
                pedido.setCodigoDireccion(rs.getInt(7));
                pedido.setCodigoUsuario(rs.getInt(8));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return pedido;
    }
    
    
    //Editar
    public int actualizar (Pedido pedido){
        String sql = "Update Pedido set NombreReceptor=?, ApellidoReceptor=?, TelefonoReceptor=?, TelefonoSecundario=?, CorreoReceptor=? where codigoPedido = ?";
        try{
            con=cn.Conexion();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, pedido.getNombreReceptor());
            ps.setString(2, pedido.getApellidoReceptor());
            ps.setString(3, pedido.getTelefonoReceptor());
            ps.setString(4, pedido.getTelefonoSecundario());
            ps.setString(5, pedido.getCorreoReceptor());
            ps.setInt(6, pedido.getCodigoPedido());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    
    //Eliminar
    public void eliminar(int id){
        String sql = "Delete from Pedido where codigoPedido = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
