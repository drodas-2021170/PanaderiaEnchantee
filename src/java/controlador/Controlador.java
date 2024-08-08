
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Especial;
import modelo.EspecialDAO;
import modelo.TipoProducto;
import modelo.TipoProductoDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;

public class Controlador extends HttpServlet {
    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDao = new UsuarioDAO();
    TipoProducto tipoProducto = new TipoProducto();
    TipoProductoDAO tipoProductoDao = new TipoProductoDAO();
    int codTipoProducto;
    Especial especial = new Especial();
    EspecialDAO especialDao = new EspecialDAO();
    int codEspecial;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if(menu.equals("Principal")){
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        } else if(menu.equals("Home")){
            request.getRequestDispatcher("Home.jsp").forward(request, response);
        } else if(menu.equals("Usuario")){
            request.getRequestDispatcher("Usuario.jsp").forward(request, response);
        } else if(menu.equals("TipoProducto")){
            switch (accion) {
                case "Listar":
                    List listarTipoProducto = tipoProductoDao.Listar();
                    request.setAttribute("TipoProductos", listarTipoProducto  );
                    
                    break;
                case "Agregar":
                    String nombreTipo = request.getParameter("txtNombreTipoProducto");
                    String descripcion = request.getParameter("txtDescripcion");
                    String temporada = request.getParameter("txtTemporada");
                    tipoProducto.setNombreTipoProducto(nombreTipo);
                    tipoProducto.setDescripcion(descripcion);
                    tipoProducto.setTemporada(temporada);
                    tipoProductoDao.Agregar(tipoProducto);
                    request.getRequestDispatcher("Controlador?menu=TipoProducto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codTipoProducto = Integer.parseInt(request.getParameter("codigoTipoProducto"));
                    TipoProducto tp = tipoProductoDao.listarCodigoTipoProducto(codTipoProducto);
                    request.setAttribute("tipoProducto", tp);
                    request.getRequestDispatcher("Controlador?menu=TipoProducto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String NombreTipo = request.getParameter("txtNombreTipoProducto");
                    String DescripcionTipo = request.getParameter("txtDescripcion");
                    String TemporadaTipo = request.getParameter("txtTemporada");
                    tipoProducto.setNombreTipoProducto(NombreTipo);
                    tipoProducto.setDescripcion(DescripcionTipo);
                    tipoProducto.setTemporada(TemporadaTipo);
                    tipoProducto.setCodigoTipoProducto(codTipoProducto);
                    tipoProductoDao.Actualizar(tipoProducto);
                    request.getRequestDispatcher("Controlador?menu=TipoProducto&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codTipoProducto = Integer.parseInt(request.getParameter("codigoTipoProducto"));
                    tipoProductoDao.Eliminar(codTipoProducto);
                    request.getRequestDispatcher("Controlador?menu=TipoProducto&accion=Listar").forward(request, response);
                    break;
            }
            
            request.getRequestDispatcher("TipoProducto.jsp").forward(request, response);
        } else if(menu.equals("TipoUsuario")){
            request.getRequestDispatcher("TipoUsuario.jsp").forward(request, response);
        } else if(menu.equals("Especiales")){
            switch(accion){
                case "Listar":
                    List listaEspeciales = especialDao.listar();
                    request.setAttribute("especiales", listaEspeciales);
                break;
                case "Agregar":
                    String feEspecial = request.getParameter("txtFechaEspecial");
                    String cantiPorciones = request.getParameter("txtCantidadPorciones");
                    String masa = request.getParameter("txtMasa");
                    String relleno = request.getParameter("txtRelleno");
                    String cobertura = request.getParameter("txtCobertura");
                    String desEspecial = request.getParameter("txtDescripcionEspecial");
                    especial.setFechaEspecial(Date.valueOf(feEspecial));
                    especial.setCantidadPorciones(cantiPorciones);
                    especial.setMasa(masa);
                    especial.setRelleno(relleno);
                    especial.setCobertura(cobertura);
                    especial.setDescripcionEspecial(desEspecial);
                    especialDao.agregar(especial);
                    request.getRequestDispatcher("Controlador?menu=Especiales&accion=Listar").forward(request, response);
                break;
                case "Editar":
                    codEspecial = Integer.parseInt(request.getParameter("codigoEspecial"));
                    Especial e = especialDao.listarCodigoEspecial(codEspecial);
                    request.setAttribute("especial", e);
                    request.getRequestDispatcher("Controlador?menu=Especiales&accion=Listar").forward(request, response);
                break;
                case "Actualizar":
                String fechaEmp = request.getParameter("txtFechaEspecial");
                String cantidadEmp = request.getParameter("txtCantidadPorciones");
                String masaEmp = request.getParameter("txtMasa");
                String rellenoEmp = request.getParameter("txtRelleno");
                String coberturaEmp = request.getParameter("txtCobertura");
                String descripcionEmp = request.getParameter("txtDescripcionEspecial");
                especial.setFechaEspecial(Date.valueOf(fechaEmp));
                especial.setCantidadPorciones(cantidadEmp);
                especial.setMasa(masaEmp);
                especial.setRelleno(rellenoEmp);
                especial.setCobertura(coberturaEmp);
                especial.setDescripcionEspecial(descripcionEmp);
                especial.setCodigoEspecial(codEspecial);
                especialDao.actualizar(especial);
                request.getRequestDispatcher("Controlador?menu=Especiales&accion=Listar").forward(request, response);
                break;
                case "Eliminar":
                    codEspecial = Integer.parseInt(request.getParameter("codigoEspecial"));
                    especialDao.eliminar(codEspecial);
                    request.getRequestDispatcher("Controlador?menu=Especiales&accion=Listar").forward(request, response);
                break;
            }	
            request.getRequestDispatcher("Especial.jsp").forward(request, response);
        } else if(menu.equals("Direccion")){
            request.getRequestDispatcher("Direccion.jsp").forward(request, response);
        } else if(menu.equals("Locales")){
            request.getRequestDispatcher("Locales.jsp").forward(request, response);
        } else if(menu.equals("Producto")){
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        } else if(menu.equals("Promocion")){
            request.getRequestDispatcher("Promocion.jsp").forward(request, response);
        } else if(menu.equals("DetalleCarrito")){
            request.getRequestDispatcher("DetalleCarrito.jsp").forward(request, response);
        } else if(menu.equals("Pedido")){
            request.getRequestDispatcher("Pedido.jsp").forward(request, response);
        } else if(menu.equals("Carrito")){
            request.getRequestDispatcher("Carrito.jsp").forward(request, response);
        } else if(menu.equals("Factura")){
            request.getRequestDispatcher("Factura.jsp").forward(request, response);
        }
     
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
