package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarritoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    // LISTAR
    public List<Carrito> listar() {
        String sql = "select * from Carrito";
        List<Carrito> listaCarrito = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Carrito ca = new Carrito();
                ca.setCodigoCarrito(rs.getInt("codigoCarrito"));
                ca.setCantidad(rs.getInt("cantidad"));
                ca.setSubTotal(rs.getDouble("subtotal"));
                ca.setTotal(rs.getDouble("total"));
                ca.setImpuesto(rs.getDouble("impuesto"));
                ca.setDescripcionCarrito(rs.getString("descripcionCarrito"));
                ca.setCodigoPedido(rs.getInt("codigoPedido"));
                ca.setCodigoProducto(rs.getInt("codigoProducto"));
                ca.setCodigoEspecial(rs.getInt("codigoEspecial"));
                listaCarrito.add(ca);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaCarrito;
    }

    // AGREGAR
   public int agregar(Carrito ca) {
        String sql = "insert into Carrito (cantidad, subtotal, total, impuesto, descripcionCarrito ) values (?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ca.getCantidad());
            ps.setDouble(2, ca.getSubTotal());
            ps.setDouble(3, ca.getTotal());
            ps.setDouble(4, ca.getImpuesto());
            ps.setString(5, ca.getDescripcionCarrito());
           // ps.setInt(6, ca.getCodigoPedido());
           // ps.setInt(7, ca.getCodigoProducto());
          //  ps.setInt(8, ca.getCodigoEspecial());
            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    // BUSCAR POR CODIGO
    public Carrito listarCodigoCarrito(int id) {
        Carrito ca = new Carrito();
        String sql = "Select * from Carrito where codigoCarrito =" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                ca.setCodigoCarrito(rs.getInt("codigoCarrito"));
                ca.setCantidad(rs.getInt("cantidad"));
                ca.setSubTotal(rs.getDouble("subtotal"));
                ca.setTotal(rs.getDouble("total"));
                ca.setImpuesto(rs.getDouble("impuesto"));
                ca.setDescripcionCarrito(rs.getString("descripcionCarrito"));
                ca.setCodigoPedido(rs.getInt("codigoPedido"));
                ca.setCodigoProducto(rs.getInt("codigoProducto"));
                ca.setCodigoEspecial(rs.getInt("codigoEspecial"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ca;
    }

    // EDITAR
    public int actualizar(Carrito ca) {
        String sql = "Update Carrito set cantidad = ?, subtotal = ?, total = ?, impuesto = ?, descripcionCarrito = ?, codigoPedido = ?, codigoProducto = ?, codigoEspecial = ? where codigoCarrito = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ca.getCantidad());
            ps.setDouble(2, ca.getSubTotal());
            ps.setDouble(3, ca.getTotal());
            ps.setDouble(4, ca.getImpuesto());
            ps.setString(5, ca.getDescripcionCarrito());
            ps.setInt(6, ca.getCodigoPedido());
            ps.setInt(7, ca.getCodigoProducto());
            ps.setInt(8, ca.getCodigoEspecial());
            ps.setInt(9, ca.getCodigoCarrito());
            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    // ELIMINAR
    public void eliminar(int id) {
        String sql = "Delete from Carrito where codigoCarrito=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int iDCarrito(){
        int idcarrito = 0;
        String sql="select max(codigoCarrito) from carrito";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeQuery();
            while(rs.next()){
                idcarrito = rs.getInt(1);
            }
        }catch(Exception e){
         e.printStackTrace();
        }
        return idcarrito;
    }
}

