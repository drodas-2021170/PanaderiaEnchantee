
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
                ca.setCodigoCarrito(rs.getInt(1));
                ca.setTotal(rs.getDouble(2));
                ca.setImpuesto(rs.getDouble(3));
                ca.setDescripcionCarrito(rs.getString(4));
                ca.setCodigoDetalleCarrito(rs.getInt(5));
                ca.setCodigoPedido(rs.getInt(6));
                listaCarrito.add(ca);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaCarrito;
    }

    // AGREGAR
    public int agregar(Carrito ca) {
        String sql = "insert into Carrito (total, impuesto, descripcionCarrito, codigoDetalleCarrito, codigoPedido) values (?,?,?,?,?);";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, ca.getTotal());
            ps.setDouble(2, ca.getImpuesto());
            ps.setString(3, ca.getDescripcionCarrito());
            ps.setInt(4, ca.getCodigoDetalleCarrito());
            ps.setInt(5, ca.getCodigoPedido());
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
            while (rs.next()) {
                ca.setCodigoCarrito(rs.getInt(1));
                ca.setTotal(rs.getDouble(2));
                ca.setImpuesto(rs.getDouble(3));
                ca.setDescripcionCarrito(rs.getString(4));
                ca.setCodigoDetalleCarrito(rs.getInt(5));
                ca.setCodigoPedido(rs.getInt(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ca;
    }

    //EDITAR
    public int actualizar(Carrito ca) {
        String sql = "Update Carrito set total = ?, impuesto = ?, descripcionCarrito = ?, codigoDetalleCarrito = ?, codigoPedido = ? where codigoCarrito = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, ca.getTotal());
            ps.setDouble(2, ca.getImpuesto());
            ps.setString(3, ca.getDescripcionCarrito());
            ps.setInt(4, ca.getCodigoDetalleCarrito());
            ps.setInt(5, ca.getCodigoPedido());
            ps.setInt(6, ca.getCodigoCarrito());
            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    //ELIMINAE

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

    
}
