<%-- 
    Document   : Principal
    Created on : 11/07/2024, 08:58:58 PM
    Author     : Kendy Rodas
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Princiapal Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    </head>
    <body>
       <nav  style="background-color: #B76E79" class="navbar navbar-expand-lg navbar-light ">
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
              <li class="nav-item active">
                  <a  style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Home" target="myFrame">Home <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item">
                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=TipoUsuario" target="myFrame">Tipo Usuario</a>
              </li>
              <li class="nav-item">
                  <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Usuario" target="myFrame">Usuario</a>
              </li>
              <li class="nav-item">
                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=TipoProducto&accion=Listar" target="myFrame">Tipo Producto</a>
              </li>
              <li class="nav-item">
                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Especiales" target="myFrame">Especiales</a>
              </li>
              <li class="nav-item">
                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Direccion" target="myFrame">Dirección</a>
              </li>
              <li class="nav-item">
                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Locales" target="myFrame">Locales</a>
              </li>
              <li class="nav-item">
                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Producto" target="myFrame">Producto</a>
              </li>
              <li class="nav-item">
                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Promocion" target="myFrame">Promoción</a>
              </li>
              <li class="nav-item">
                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=DetalleCarrito" target="myFrame">Detalle Carrito</a>
              </li>
              <li class="nav-item">
                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Pedido" target="myFrame">Pedido</a>
              </li>
              <li class="nav-item">
                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Carrito" target="myFrame">Carrito</a>
              </li>
              <li class="nav-item">
                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Factura" target="myFrame">Factura</a>
              </li>
            </ul>
          </div>
          <div class="dropdown">
            <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              ${usuario.getNombresUsuario()}
            </button>
            <div  class="dropdown-menu text-center" aria-labelledby="dropdownButton">
                <a class="dropdown-item" href="$">
                    <img src="img/personaIcon.png" alt="60" width="60"/>
                </a>
                <a class="dropdown-item" href="#">${usuario.getUsuario()}</a>
                <a class="dropdown-item" href="#">${usuario.getCorreoUsuario()}</a>
                <div class="dropdown-divider"></div>
                <form action="Validar" method="POST">
                    <button name="accion" name="Salir" class="dropdown-item" href="#">Salir</button>
                </form>
            </div>
          </div>
       </nav>
                <div class="m-4" style="height: 600px">
                    <iframe name="myFrame" style="height: 100%; width: 100%; border: 1"></iframe>
                </div>
        
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    </body>
</html>

