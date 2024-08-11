<%-- 
    Document   : Producto
    Created on : 12/07/2024, 05:25:50 PM
    Author     : Pablo Realiquez
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">   
        <title>Producto</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Producto" method="POST" enctype="multipart/form-data">
                        <div class="form-group">
                            <label><strong>Código</strong></label>
                            <input type="text" value="${producto.getCodigoProducto()}" name="txtCodigoProducto" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Nombre del Producto</strong></label>
                            <input type="text" value="${producto.getNombreProducto()}" name="txtNombreProducto" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Descripción del Producto</strong></label>
                            <input type="text" value="${producto.getDescripcion()}" name="txtDescripcionProducto" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Precio</strong></label>
                            <input type="text" value="${producto.getPrecio()}" name="txtPrecioProducto" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Disponibilidad</strong></label>
                            <input type="text" value="${producto.getDisponibilidad()}" name="txtDisponibilidadProducto" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Existencia</strong></label>
                            <input type="text" value="${producto.getExistencia()}" name="txtExistenciaProducto" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Lista de Ingredientes</strong></label>
                            <input type="text" value="${producto.getIngredientes()}" name="txtIngredientesProducto" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Categoría</strong></label>
                            <input type="text" value="${producto.getCodigoTipoProducto()}" name="txtCategoriaProducto" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                        <hr>
                        <input type="file" name="fotoProducto" value="Subir Imágen" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>FOTO</th>
                            <th>CODIGO</th>
                            <th>NOMBRE</th>
                            <th>DESCRIPCIÓN</th>
                            <th>PRECIO</th>
                            <th>DISPONIBILIDAD</th>
                            <th>EXISTENCIA</th>
                            <th>INGREDIENTES</th>
                            <th>TIPO</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="producto" items="${productos}">
                            <tr>
                                <td><img src="ControladorImagen?id=${producto.getCodigoProducto()}" width="100" height="150" onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/img/logoInicial.jpeg';"></td>
                                <td>${producto.getCodigoProducto()}</td>
                                <td>${producto.getNombreProducto()}</td>
                                <td>${producto.getDescripcion()}</td>
                                <td>${producto.getPrecio()}</td>
                                <td>${producto.getDisponibilidad()}</td>
                                <td>${producto.getExistencia()}</td>
                                <td>${producto.getIngredientes()}</td>
                                <td>${producto.getCodigoTipoProducto()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Producto&accion=Editar&codigoProducto=${producto.getCodigoProducto()}">EDITAR</a>
                                    <a class=" btn btn-danger" href="Controlador?menu=Producto&accion=Eliminar&codigoProducto=${producto.getCodigoProducto()}">ELIMINAR</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>   
    </body>
</html>
