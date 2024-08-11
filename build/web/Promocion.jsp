<%-- 
    Document   : Promocion
    Created on : 12/07/2024, 05:33:57 PM
    Author     : Pablo Realiquez
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">   
        <title>Promocion</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Promocion" method="POST">
                        <div class="form-group">
                            <label><strong>Código</strong></label>
                            <input type="text" value="${promocion.getCodigoPromocion()}" name="txtCodigoPromocion" class="form-control"disabled>
                        </div>
                        <div class="form-group">
                            <label><strong>Nombre de la Promoción</strong></label>
                            <input type="text" value="${promocion.getNombrePromocion()}" name="txtNombrePromocion" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Fecha de Inicio</strong></label>
                            <input type="text" value="${promocion.getFechaInicio()}" name="txtFechaInicio" class="form-control" placeholder="Año-Día-Mes">
                        </div>
                        <div class="form-group">
                            <label><strong>Fecha de Finalización</strong></label>
                            <input type="text" value="${promocion.getFechaFin()}" name="txtFechaFin" class="form-control" placeholder="Año-Día-Mes">
                        </div>
                        <div class="form-group">
                            <label><strong>Precio</strong></label>
                            <input type="text" value="${promocion.getPrecioPromocion()}" name="txtPrecioPromocion" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Productos de la Promoción</strong></label>
                            <input type="text" value="${promocion.getCodigoProducto()}" name="txtProductoPromocion" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>CODIGO</th>
                            <th>NOMBRE</th>
                            <th>INICIO</th>
                            <th>FINALIZACIÓN</th>
                            <th>PRECIO</th>
                            <th>PRODUCTOS</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="promocion" items="${promociones}">
                            <tr>
                                <td>${promocion.getCodigoPromocion()}</td>
                                <td>${promocion.getNombrePromocion()}</td>
                                <td>${promocion.getFechaInicio()}</td>
                                <td>${promocion.getFechaFin()}</td>
                                <td>${promocion.getPrecioPromocion()}</td>
                                <td>${promocion.getCodigoProducto()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Promocion&accion=Editar&codigoPromocion=${promocion.getCodigoPromocion()}">EDITAR</a>
                                    <a class=" btn btn-danger" href="Controlador?menu=Promocion&accion=Eliminar&codigoPromocion=${promocion.getCodigoPromocion()}">ELIMINAR</a>
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
