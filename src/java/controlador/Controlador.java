
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;
import modelo.UsuarioDAO;

public class Controlador extends HttpServlet {
    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDao = new UsuarioDAO();
   
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
            request.getRequestDispatcher("TipoProducto.jsp").forward(request, response);
        } else if(menu.equals("TipoUsuario")){
            request.getRequestDispatcher("TipoUsuario.jsp").forward(request, response);
        } else if(menu.equals("Especiales")){
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
