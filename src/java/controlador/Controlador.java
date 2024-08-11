
package controlador;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.Carrito;
import modelo.CarritoDAO;
import modelo.Direccion;
import modelo.DireccionDAO;
import modelo.Especial;
import modelo.EspecialDAO;
import modelo.Factura;
import modelo.FacturaDAO;
import modelo.Locales;
import modelo.LocalesDAO;
import modelo.Pedido;
import modelo.PedidoDAO;
import modelo.Producto;
import modelo.ProductoDAO;
import modelo.Promocion;
import modelo.PromocionDAO;
import modelo.TipoProducto;
import modelo.TipoProductoDAO;
import modelo.TipoUsuario;
import modelo.TipoUsuarioDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;

@MultipartConfig
public class Controlador extends HttpServlet {
    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDao = new UsuarioDAO();
    TipoProducto tipoProducto = new TipoProducto();
    TipoProductoDAO tipoProductoDao = new TipoProductoDAO();
    Especial especial = new Especial();
    EspecialDAO especialDao = new EspecialDAO();
    TipoUsuario tipoUsuario = new TipoUsuario();
    TipoUsuarioDAO tipoUsuarioDao = new TipoUsuarioDAO();
    Direccion direccion = new Direccion();
    DireccionDAO direccionDao = new DireccionDAO();
    Locales locales = new Locales();
    LocalesDAO localesDao = new LocalesDAO();
    Pedido pedido = new Pedido();
    PedidoDAO pedidoDao = new PedidoDAO();
    Factura factura = new Factura();
    FacturaDAO facturaDao = new FacturaDAO();
    Promocion promocion = new Promocion();
    PromocionDAO promocionDao = new PromocionDAO();
    Producto producto = new Producto();
    ProductoDAO productoDao = new ProductoDAO();
    ProductoDAO productDao = new ProductoDAO();
    Carrito carrito = new Carrito();
    CarritoDAO carritoDao = new CarritoDAO();
    List<Carrito> lista = new ArrayList<>();
    int codFactura;
    int codLocales;
    int codDireccion;
    int codUsuario;
    int codEspecial;
    int codTipoUsuario;
    int codTipoProducto;
    int codPedido;
    int codPromocion;
    int codProducto;
    int item = 1; // Inicializa el número de ítem en 1
    double impuesto = 0.0;
    double precio, subTotal = 0.0;
    double total = 0.0;
    int cantid = 0;
    String descrip ="";
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if(menu.equals("Principal")){
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        } else if(menu.equals("Home")){
            request.getRequestDispatcher("Home.jsp").forward(request, response);
        } else if(menu.equals("Usuario")){
            switch(accion){
                case "Listar":
                    List listaUsuarios = usuarioDao.listar();
                    request.setAttribute("usuarios", listaUsuarios);
                    List listaTipoUsu = tipoUsuarioDao.listar();
                    request.setAttribute("tipoUsuarios", listaTipoUsu);
                break;
                case "Editar":
                    codUsuario = Integer.parseInt(request.getParameter("codigoUsuario"));
                    Usuario e = usuarioDao.listarCodigoUsuario(codUsuario);
                    request.setAttribute("usuario", e);
                    request.getRequestDispatcher("Controlador?menu=Usuario&accion=Listar").forward(request, response);
                break;
                case "Agregar":
                    String nom = request.getParameter("txtNombresUsuario");
                    String ape = request.getParameter("txtApellidosUsuario");
                    String tel = request.getParameter("txtTelefonoUsuario");
                    String cor = request.getParameter("txtCorreoUsuario");
                    String user = request.getParameter("txtUsuario");
                    String cont = request.getParameter("txtPassword");
                    int tipoUser = Integer.parseInt(request.getParameter("txtTipoUsuario"));
                    usuario.setNombresUsuario(nom);
                    usuario.setApellidosUsuario(ape);
                    usuario.setTelefonoUsuario(tel);
                    usuario.setCorreoUsuario(cor);
                    usuario.setUsuario(user);
                    usuario.setContrasena(cont);
                    usuario.setCodigoTipoUsuario(tipoUser);
                    usuarioDao.agregar(usuario);
                    request.getRequestDispatcher("Controlador?menu=Usuario&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nomUsu = request.getParameter("txtNombresUsuario");
                    String apeUsu = request.getParameter("txtApellidosUsuario");
                    String telUsu = request.getParameter("txtTelefonoUsuario");
                    String corUsu = request.getParameter("txtCorreoUsuario");
                    String userUsu = request.getParameter("txtUsuario");
                    String contUsu = request.getParameter("txtPassword");
                    int tipoUserUsu = Integer.parseInt(request.getParameter("txtTipoUsuario"));
                    usuario.setNombresUsuario(nomUsu);
                    usuario.setApellidosUsuario(apeUsu);
                    usuario.setTelefonoUsuario(telUsu);
                    usuario.setCorreoUsuario(corUsu);
                    usuario.setUsuario(userUsu);
                    usuario.setContrasena(contUsu);
                    usuario.setCodigoTipoUsuario(tipoUserUsu);
                    usuario.setCodigoUsuario(codUsuario);
                    usuarioDao.actualizar(usuario);
                    request.getRequestDispatcher("Controlador?menu=Usuario&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codUsuario = Integer.parseInt(request.getParameter("codigoUsuario"));
                    usuarioDao.eliminar(codUsuario);
                    request.getRequestDispatcher("Controlador?menu=Usuario&accion=Listar").forward(request, response);
                    break;
            }
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
            switch(accion) {
                case "Listar":
                    List<TipoUsuario> listaTipoUsuario = tipoUsuarioDao.listar();
                    request.setAttribute("tipoUsuarios", listaTipoUsuario);
                    break;
                case "Agregar":
                    String nombreTipoUsuario = request.getParameter("txtNombreTipoUsuario");
                    String descripcion = request.getParameter("txtDescripcion");
                    String permisos = request.getParameter("txtPermisos");
                    boolean estado = Boolean.parseBoolean(request.getParameter("txtEstado"));
                    tipoUsuario.setNombreTipoUsuario(nombreTipoUsuario);
                    tipoUsuario.setDescripcion(descripcion);
                    tipoUsuario.setPermisos(permisos);
                    tipoUsuario.setEstado(estado);
                    tipoUsuarioDao.agregar(tipoUsuario);
                    request.getRequestDispatcher("Controlador?menu=TipoUsuario&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codTipoUsuario = Integer.parseInt(request.getParameter("codigoTipoUsuario"));
                    TipoUsuario tu = tipoUsuarioDao.listarCodigoTipoUsuario(codTipoUsuario);
                    request.setAttribute("tipoUsuario", tu);
                    request.getRequestDispatcher("Controlador?menu=TipoUsuario&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nomTipoUsuario = request.getParameter("txtNombreTipoUsuario");
                    String descTipoUsuario = request.getParameter("txtDescripcion");
                    String permTipoUsuario = request.getParameter("txtPermisos");
                    boolean estTipoUsuario = Boolean.parseBoolean(request.getParameter("txtEstado"));
                    tipoUsuario.setCodigoTipoUsuario(codTipoUsuario);
                    tipoUsuario.setNombreTipoUsuario(nomTipoUsuario);
                    tipoUsuario.setDescripcion(descTipoUsuario);
                    tipoUsuario.setPermisos(permTipoUsuario);
                    tipoUsuario.setEstado(estTipoUsuario);
                    tipoUsuarioDao.actualizar(tipoUsuario);
                    request.getRequestDispatcher("Controlador?menu=TipoUsuario&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codTipoUsuario = Integer.parseInt(request.getParameter("codigoTipoUsuario"));
                    tipoUsuarioDao.eliminar(codTipoUsuario);
                    request.getRequestDispatcher("Controlador?menu=TipoUsuario&accion=Listar").forward(request, response);
                    break;
            }
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
            switch(accion){
            case "Listar":
                List listaDireccion = direccionDao.listar();
                request.setAttribute("direcciones", listaDireccion);
                break;
            case "Agregar":
                String direccionCom = request.getParameter("txtDireccionCompleta");
                String departa = request.getParameter("txtDepartamento");
                String muni = request.getParameter("txtMunicipio");
                String ot = request.getParameter("txtOtro");
                direccion.setDireccionCompleta(direccionCom);
                direccion.setDepartamento(departa);
                direccion.setMunicipio(muni);
                direccion.setOtro(ot);
                direccionDao.agregar(direccion);
                request.getRequestDispatcher("Controlador?menu=Direccion&accion=Listar").forward(request, response);
                break;
            case "Editar":
                codDireccion = Integer.parseInt(request.getParameter("codigoDireccion"));
                Direccion d = direccionDao.listarDireccion(codDireccion);
                request.setAttribute("direccion", d);
                 request.getRequestDispatcher("Controlador?menu=Direccion&accion=Listar").forward(request, response);
                break;
            case "Actualizar":
                String direccionComp = request.getParameter("txtDireccionCompleta");
                String departam = request.getParameter("txtDepartamento");
                String munic = request.getParameter("txtMunicipio");
                String otr = request.getParameter("txtOtro");
                direccion.setDireccionCompleta(direccionComp);
                direccion.setDepartamento(departam);
                direccion.setMunicipio(munic);
                direccion.setOtro(otr);
                direccion.setCodigoDireccion(codDireccion);
                direccionDao.actualizar(direccion);
                request.getRequestDispatcher("Controlador?menu=Direccion&accion=Listar").forward(request, response);
                break;
            case "Eliminar":
                codDireccion = Integer.parseInt(request.getParameter("codigoDireccion"));
                direccionDao.eliminar(codDireccion);
                request.getRequestDispatcher("Controlador?menu=Direccion&accion=Listar").forward(request, response);
                break;
                    
            }
            request.getRequestDispatcher("Direccion.jsp").forward(request, response);
        } else if(menu.equals("Locales")){
            switch(accion){
                case "Listar":
                    List listaLocal = localesDao.listar();
                    request.setAttribute("local", listaLocal);
                    break;
                case "Agregar":
                    String codLocal = request.getParameter("txtCodigoLocal");
                    String nombreLoc = request.getParameter("txtNombreLocal");
                    String horariosLoc = request.getParameter("txtHorariosLocal");
                    String horariosEsp = request.getParameter("txtHorarioEspecialLocal");
                    String telefonoLoc = request.getParameter("txtTelefonoLocal");
                    String codDir = request.getParameter("txtCodigoDireccion");
                    locales.setCodigoLocal(Integer.parseInt(codLocal));
                    locales.setNombreLocal(nombreLoc);
                    locales.setHorariosLocal(horariosLoc);
                    locales.setHorarioEspecialLocal(horariosEsp);
                    locales.setTelefonoLocal(telefonoLoc);
                    locales.setCodigoDireccion(Integer.parseInt(codDir));
                    localesDao.agregar(locales);
                    request.getRequestDispatcher("Controlador?menu=Locales&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codLocales = Integer.parseInt(request.getParameter("codigoLocal"));
                    Locales l= localesDao.listarCodigoLocales(codLocales);
                    request.setAttribute("locales", l);
                    request.getRequestDispatcher("Controlador?menu=Locales&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String codLocals = request.getParameter("txtCodigoLocal");
                    String nombreLoca = request.getParameter("txtNombreLocal");
                    String horariosLoca = request.getParameter("txtHorariosLocal");
                    String horariosEspe = request.getParameter("txtHorarioEspecialLocal");
                    String telefonoLoca = request.getParameter("txtTelefonoLocal");
   
                    locales.setCodigoLocal(Integer.parseInt(codLocals));
                    locales.setNombreLocal(nombreLoca);
                    locales.setHorariosLocal(horariosLoca);
                    locales.setHorarioEspecialLocal(horariosEspe);
                    locales.setTelefonoLocal(telefonoLoca);
                    localesDao.actualizar(locales);
                    request.getRequestDispatcher("Controlador?menu=Locales&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codLocales = Integer.parseInt(request.getParameter("codigoLocal"));
                    localesDao.eliminar(codLocales);
                    request.getRequestDispatcher("Controlador?menu=Locales&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Locales.jsp").forward(request, response);
        } else if(menu.equals("Producto")){
            switch(accion){
                case "Listar":
                    List listaProducto = productoDao.listar();
                    request.setAttribute("productos", listaProducto);
                    break;
                case "Agregar":
                    String codigoProducto = request.getParameter("txtCodigoProducto");
                    String nombreProducto = request.getParameter("txtNombreProducto");
                    String descripcionProducto = request.getParameter("txtDescripcionProducto");
                    String precioProducto = request.getParameter("txtPrecioProducto");
                    String disponibilidadProducto = request.getParameter("txtDisponibilidadProducto");
                    String existenciaProducto = request.getParameter("txtExistenciaProducto");
                    String ingredientesProducto = request.getParameter("txtIngredientesProducto");
                    String tipoProducto = request.getParameter("txtCategoriaProducto");
                    
                    Part part = request.getPart("fotoProducto");
                    InputStream inputStream = part.getInputStream();
                    
                    producto.setCodigoProducto(Integer.parseInt(codigoProducto));
                    producto.setNombreProducto(nombreProducto);
                    producto.setDescripcion(descripcionProducto);
                    producto.setPrecio(Double.parseDouble(precioProducto));
                    producto.setDisponibilidad(Boolean.valueOf(disponibilidadProducto));
                    producto.setExistencia(Integer.parseInt(existenciaProducto));
                    producto.setIngredientes(ingredientesProducto);
                    producto.setCodigoTipoProducto(Integer.parseInt(tipoProducto));
                    
                    if(part != null && part.getSize()>0){
                        producto.setImagen(inputStream);
                    }else{
                        producto.setImagen(null);
                    }
                    
                    productoDao.agregar(producto);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codProducto = Integer.parseInt(request.getParameter("codigoProducto"));
                    Producto pr = productoDao.listarCodigoProducto(codProducto);
                    request.setAttribute("producto", pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nombreProduct = request.getParameter("txtNombreProducto");
                    String descripcionProduct = request.getParameter("txtDescripcionProducto");
                    String precioProduct = request.getParameter("txtPrecioProducto");
                    String disponibilidadProduct = request.getParameter("txtDisponibilidadProducto");
                    String existenciaProduct = request.getParameter("txtExistenciaProducto");
                    String ingredientesProduct = request.getParameter("txtIngredientesProducto");
                    
                    Part parte = request.getPart("fotoProducto");
                    
                    producto.setNombreProducto(nombreProduct);
                    producto.setDescripcion(descripcionProduct);
                    producto.setPrecio(Double.parseDouble(precioProduct));
                    producto.setDisponibilidad(Boolean.valueOf(disponibilidadProduct));
                    producto.setExistencia(Integer.parseInt(existenciaProduct));
                    producto.setIngredientes(ingredientesProduct);
                    
                    if(parte != null && parte.getSize()>0){
                        InputStream inputSt = parte.getInputStream();
                        producto.setImagen(inputSt);
                    }else{
                        Producto productoExistente = productoDao.listarCodigoProducto(codProducto);
                        producto.setImagen(productoExistente.getImagen());
                    }
                    producto.setCodigoProducto(codProducto);
                    
                    productoDao.actualizar(producto);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codProducto = Integer.parseInt(request.getParameter("codigoProducto"));
                    productoDao.eliminar(codProducto);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        } else if(menu.equals("Promocion")){
            switch(accion){
                case "Listar":
                    List listaPromocion = promocionDao.listar();
                    request.setAttribute("promociones", listaPromocion);
                    break;
                case "Agregar":
                    String nombrePromocion = request.getParameter("txtNombrePromocion");
                    String fechaInicio = request.getParameter("txtFechaInicio");
                    String fechaFin = request.getParameter("txtFechaFin");
                    String precioProm = request.getParameter("txtPrecioPromocion");
                    String codProducto = request.getParameter("txtProductoPromocion");
                    
                    promocion.setNombrePromocion(nombrePromocion);
                    promocion.setFechaInicio(fechaInicio);
                    promocion.setFechaFin(fechaFin);
                    promocion.setPrecioPromocion(Double.parseDouble(precioProm));
                    promocion.setCodigoProducto(Integer.parseInt(codProducto));
                    
                    promocionDao.agregar(promocion);
                    request.getRequestDispatcher("Controlador?menu=Promocion&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codPromocion = Integer.parseInt(request.getParameter("codigoPromocion"));
                    Promocion p = promocionDao.listarCodigoPromocion(codPromocion);
                    request.setAttribute("promocion", p);
                    request.getRequestDispatcher("Controlador?menu=Promocion&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codPromocion = Integer.parseInt(request.getParameter("codigoPromocion"));
                    promocionDao.eliminar(codPromocion);
                    request.getRequestDispatcher("Controlador?menu=Promocion&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nombreProm = request.getParameter("txtNombrePromocion");
                    String fechInicio = request.getParameter("txtFechaInicio");
                    String fechFin = request.getParameter("txtFechaFin");
                    String precProm = request.getParameter("txtPrecioPromocion");
                    //String codProduc = request.getParameter("txtProductoPromocion");
                    
                    promocion.setNombrePromocion(nombreProm);
                    promocion.setFechaInicio(fechInicio);
                    promocion.setFechaFin(fechFin);
                    promocion.setPrecioPromocion(Double.parseDouble(precProm));
                    //promocion.setCodigoProducto(Integer.parseInt(codProduc));
                    promocion.setCodigoPromocion(codPromocion);
                    
                    promocionDao.actualizar(promocion);
                    request.getRequestDispatcher("Controlador?menu=Promocion&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Promocion.jsp").forward(request, response);
        } else if(menu.equals("DetalleCarrito")){
            request.getRequestDispatcher("DetalleCarrito.jsp").forward(request, response);
        } else if(menu.equals("Pedido")){
            switch(accion){
                case "Listar":
                    List listaPedidos = pedidoDao.listar();
                    request.setAttribute("pedidos", listaPedidos);
                break;
                case "Editar":
                    codPedido = Integer.parseInt(request.getParameter("codigoPedido"));
                    Pedido e = pedidoDao.listarCodigoPedido(codPedido);
                    request.setAttribute("pedido", e);
                    request.getRequestDispatcher("Controlador?menu=Pedido&accion=Listar").forward(request, response);
                break;
                case "Agregar":
                    String nombres = request.getParameter("txtNombreReceptor");
                    String apellidos = request.getParameter("txtApellidoReceptor");
                    String telefono = request.getParameter("txtTelefonoReceptor");
                    String telefonoSecundario = request.getParameter("txtTelefonoSecundario");
                    String correo = request.getParameter("txtCorreoReceptor");
                    int codDirec = Integer.parseInt(request.getParameter("txtCodigoReceptor"));
                    int codUser = Integer.parseInt(request.getParameter("txtCodigoUsuario"));
                    
                    pedido.setNombreReceptor(nombres);
                    pedido.setApellidoReceptor(apellidos);
                    pedido.setTelefonoReceptor(telefono);
                    pedido.setTelefonoSecundario(telefonoSecundario);
                    pedido.setCorreoReceptor(correo);
                    pedido.setCodigoDireccion(codDirec);
                    pedido.setCodigoUsuario(codUser);
                    pedidoDao.agregar(pedido);
                    request.getRequestDispatcher("Controlador?menu=Pedido&accion=Listar");
                break;
                case "Actualizar":
                    String nombresRecep = request.getParameter("txtNombreReceptor");
                    String apellidosRecep = request.getParameter("txtApellidoReceptor");
                    String telefonoRecep = request.getParameter("txtTelefonoReceptor");
                    String telefonoSecundarioRecep = request.getParameter("txtTelefonoSecundario");
                    String correoRecep = request.getParameter("txtCorreoReceptor");
                    codDireccion = direccion.getCodigoDireccion();
                    codUsuario = usuario.getCodigoUsuario();
                    
                    pedido.setNombreReceptor(nombresRecep);
                    pedido.setApellidoReceptor(apellidosRecep); 
                    pedido.setTelefonoReceptor(telefonoRecep);
                    pedido.setTelefonoSecundario(telefonoSecundarioRecep);
                    pedido.setCorreoReceptor(correoRecep);
                    pedido.setCodigoPedido(codPedido);
                    pedidoDao.actualizar(pedido);
                    request.getRequestDispatcher("Controlador?menu=Pedido&accion=Listar");
                break;
                case "Eliminar":
                    codPedido = Integer.parseInt(request.getParameter("codigoPedido"));
                    pedidoDao.eliminar(codPedido);
                    request.getRequestDispatcher("Controlador?menu=Pedido&accion=Listar").forward(request, response);
                break;
            }
            request.getRequestDispatcher("Pedido.jsp").forward(request, response);
        } else if(menu.equals("Carrito")){
            switch(accion){
                case "BuscarPedido":
                    int codigoPedido = Integer.parseInt(request.getParameter("txtCodigoPedido"));
                    pedido.setCodigoPedido(codigoPedido);
                    pedido = pedidoDao.listarCodigoPedido(codigoPedido);
                    request.setAttribute("pedido", pedido);
                    break;
                case "BuscarProducto":
                    codProducto = Integer.parseInt(request.getParameter("txtCodigoProducto"));
                    producto = productoDao.listarCodigoProducto(codProducto);
                    request.setAttribute("producto", producto);
                    request.setAttribute("lista", lista);
                    request.setAttribute("total", total);
                    request.setAttribute("pedido", pedido);
                    break;
                case "BuscarFactura":
                      int codFactura = Integer.parseInt(request.getParameter("txtCodigoFactura"));
                    factura.setCodigoFactura(codFactura);
                    factura = facturaDao.listarCodigoFactura(codFactura);
                    request.setAttribute("factura", factura);   
                    break;
                case "Agregar":
                    request.setAttribute("pedido", pedido);
                    codProducto = producto.getCodigoProducto();
                    String descripcion = request.getParameter("txtNombreProducto");
                    precio = Double.parseDouble(request.getParameter("txtPrecio"));
                    int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
                    subTotal = precio * cantidad;
                    
                    // Verificar si el producto ya está en el carrito
                    boolean productoExiste = false;
                    for (Carrito itemCarrito : lista) {
                        if (itemCarrito.getCodigoProducto() == codProducto) {
                            // Actualizar cantidad y subtotal
                            itemCarrito.setCantidad(itemCarrito.getCantidad() + cantidad);
                            itemCarrito.setSubTotal(itemCarrito.getPrecio() * itemCarrito.getCantidad());
                            productoExiste = true;
                            break;
                        }
                    }
                    
                    // Si el producto no existe, agregarlo como nuevo
                    if (!productoExiste) {
                        Carrito carrito = new Carrito();
                        carrito.setItem(item++);
                        carrito.setCodigoProducto(codProducto);
                        carrito.setDescripcionCarrito(descripcion);
                        carrito.setPrecio(precio);
                        carrito.setCantidad(cantidad);
                        carrito.setSubTotal(subTotal);
                        lista.add(carrito);
                    }
                    
                    // Calcular total
                    total = 0.0;
                    for (Carrito itemCarrito : lista) {
                        total += itemCarrito.getSubTotal();
                    }
                    
                    impuesto = total * 0.12;
                    request.setAttribute("total", total + impuesto);
                    request.setAttribute("lista", lista);
                    break;
                case "Eliminar":
                    int codigoProductoEliminar = Integer.parseInt(request.getParameter("codigo"));
                    lista.removeIf(carrito -> carrito.getCodigoProducto() == codigoProductoEliminar);
                    
                    // Reordenar los números de ítem
                    item = 1;
                    for (Carrito itemCarrito : lista) {
                        itemCarrito.setItem(item++);
                    }
                    
                    // Recalcular total
                    total = 0.0;
                    for (Carrito itemCarrito : lista) {
                        total += itemCarrito.getSubTotal();
                    }
                    
                    impuesto = total * 0.12;
                    request.setAttribute("total", total + impuesto);
                    request.setAttribute("lista", lista);
                    break;
                case "ActualizarCantidad":
                    int codigoProductoActualizar = Integer.parseInt(request.getParameter("txtCodigoProducto"));
                    int nuevaCantidad = Integer.parseInt(request.getParameter("txtCantidad"));
                    
                    for (Carrito itemCarrito : lista) {
                        if (itemCarrito.getCodigoProducto() == codigoProductoActualizar) {
                            itemCarrito.setCantidad(nuevaCantidad);
                            itemCarrito.setSubTotal(itemCarrito.getPrecio() * nuevaCantidad);
                            break;
                        }
                    }
                    
                    // Recalcular total
                    total = 0.0;
                    for (Carrito itemCarrito : lista) {
                        total += itemCarrito.getSubTotal();
                    }
                    
                    impuesto = total * 0.12;
                    request.setAttribute("total", total + impuesto);
                    request.setAttribute("lista", lista);
                    break;
                case "GenerarVenta":


                    for(int i=0; i<lista.size(); i++){
                        Producto pr= new Producto();
                        int cantid =lista.get(i).getCantidad();
                        int idProducto = lista.get(i).getCodigoProducto(); 
                        pr=productoDao.listarCodigoProducto(idProducto);
                        int sac = pr.getExistencia()-cantid;
                        productoDao.actualizarExistencia(idProducto, sac);
                        
                        carrito.setCantidad(cantid);
                        carrito.setSubTotal(lista.get(i).getSubTotal());
                        carrito.setTotal(total); // total es una variable acumulada
                        carrito.setImpuesto(impuesto); // impuesto es una variable acumulada
                        carrito.setDescripcionCarrito(lista.get(i).getDescripcionCarrito());
                        carrito.setCodigoEspecial(lista.get(i).getCodigoEspecial());
                        carrito.setCodigoPedido(lista.get(i).getCodigoPedido());
                        carrito.setCodigoProducto(idProducto);


                        // Agregar el carrito a la base de datos
                        carritoDao.agregar(carrito);
                       }
                    lista.clear(); // Vaciar el carrito después de generar la venta
                    total = 0.0;
                    impuesto = 0.0;
                    break;
                case "Cancelar":
                    // Implementar lógica para cancelar el carrito
                    lista.clear(); // Vaciar el carrito
                    total = 0.0;
                    impuesto = 0.0;
                    break;
            }
            request.getRequestDispatcher("Carrito.jsp").forward(request, response);
        } else if(menu.equals("Factura")){
                        switch(accion){
                case "Listar":
                    List listaFactura = facturaDao.listar();
                    request.setAttribute("facturas", listaFactura);
                break;
                case "Agregar":
                    String NIT = request.getParameter("txtNITFactura");
                    String metodo = request.getParameter("txtMetodoPago");
                    boolean est = Boolean.parseBoolean(request.getParameter("txtEstadoFactura"));
                    Integer pedido = Integer.parseInt(request.getParameter("txtCodigoPedido"));
                    factura.setNITFactura(NIT);
                    factura.setMetodoPago(metodo);
                    factura.setEstadoFactura(est);
                    factura.setCodigoPedido(pedido);
                    facturaDao.Agregar(factura);
                    request.getRequestDispatcher("Controlador?menu=Factura&accion=Listar").forward(request, response);
                break;
                case "Editar":
                    codFactura = Integer.parseInt(request.getParameter("codigoFactura"));
                    Factura f = facturaDao.listarCodigoFactura(codFactura);
                    request.setAttribute("factura", f);
                    request.getRequestDispatcher("Controlador?menu=Factura&accion=Listar").forward(request, response);
                break;
                case "Actualizar":
                    String NITFac = request.getParameter("txtNITFactura");
                    String metodoFac = request.getParameter("txtMetodoPago");
                    boolean estFac =  Boolean.parseBoolean(request.getParameter("txtEstadoFactura"));
                    factura.setNITFactura(NITFac);
                    factura.setMetodoPago(metodoFac);
                    factura.setEstadoFactura(estFac);
                    factura.setCodigoFactura(codFactura);
                    facturaDao.actualizar(factura);
                    request.getRequestDispatcher("Controlador?menu=Factura&accion=Listar").forward(request, response);
                break;
                case "Eliminar":
                    codFactura = Integer.parseInt(request.getParameter("codigoFactura"));
                    facturaDao.eliminar(codFactura);
                     request.getRequestDispatcher("Controlador?menu=Factura&accion=Listar").forward(request, response);
                break;      
        }
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
