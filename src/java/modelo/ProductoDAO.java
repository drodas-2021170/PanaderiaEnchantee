package modelo;

import config.Conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

//PRUEBA
public class ProductoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public List listar(){
        String sql = "SELECT * FROM Producto";
        List<Producto> listaProducto = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Producto product = new Producto();
                product.setCodigoProducto(rs.getInt(1));
                product.setNombreProducto(rs.getString(2));
                product.setDescripcion(rs.getString(3));
                product.setPrecio(rs.getDouble(4));
                product.setDisponibilidad(rs.getBoolean(5));
                product.setExistencia(rs.getInt(6));
                product.setImagen(rs.getBinaryStream(7));
                product.setIngredientes(rs.getString(8));
                product.setCodigoTipoProducto(rs.getInt(9));
                listaProducto.add(product);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaProducto;
    }
    
    public int agregar(Producto product){
        String sql = "INSERT INTO Producto (codigoProducto, nombreProducto, descripcion, precio, disponibilidad, existencia, imagen, ingredientes, codigoTipoProducto) VALUES (?,?,?,?,?,?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, product.getCodigoProducto());
            ps.setString(2, product.getNombreProducto());
            ps.setString(3, product.getDescripcion());
            ps.setDouble(4, product.getPrecio());
            ps.setBoolean(5, product.getDisponibilidad());
            ps.setInt(6, product.getExistencia());
            ps.setBlob(7, product.getImagen());
            ps.setString(8, product.getIngredientes());
            ps.setInt(9, product.getCodigoTipoProducto());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    public Producto listarCodigoProducto(int id){
        Producto product = new Producto();
        String sql = "SELECT * FROM Producto WHERE codigoProducto = "+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                product.setCodigoProducto(rs.getInt(1));
                product.setNombreProducto(rs.getString(2));
                product.setDescripcion(rs.getString(3));
                product.setPrecio(rs.getDouble(4));
                product.setDisponibilidad(rs.getBoolean(5));
                product.setExistencia(rs.getInt(6));
                product.setImagen(rs.getBinaryStream(7));
                product.setIngredientes(rs.getString(8));
                product.setCodigoTipoProducto(rs.getInt(9));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return product;
    }
    
    public void listarImagen(int id, HttpServletResponse response){
        String sql = "SELECT * FROM Producto WHERE codigoProducto = "+id;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        response.setContentType("image/*");
        
        try{
            outputStream = response.getOutputStream();
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                inputStream = rs.getBinaryStream("imagen");
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            int i=0;
            while((i=bufferedInputStream.read())!=-1){
                bufferedOutputStream.write(i);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public int actualizar(Producto product){
        String sql = "UPDATE Producto SET nombreProducto = ?, descripcion = ?, precio = ?, disponibilidad = ?, existencia = ?, imagen = ?, ingredientes = ? WHERE codigoProducto = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, product.getNombreProducto());
            ps.setString(2, product.getDescripcion());
            ps.setDouble(3, product.getPrecio());
            ps.setBoolean(4, product.getDisponibilidad());
            ps.setInt(5, product.getExistencia());
            ps.setBlob(6, product.getImagen());
            ps.setString(7, product.getIngredientes());
            ps.setInt(8, product.getCodigoProducto());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    public void eliminar(int id){
        String sql = "DELETE FROM Producto WHERE codigoProducto = "+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
     public int actualizarExistencia(int id, int stock){
        String sql = "update producto set existencia=? where codigoProducto=?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
}
