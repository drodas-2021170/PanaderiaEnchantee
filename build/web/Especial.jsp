<%-- 
    Document   : Especial
    Created on : 12-jul-2024, 16:13:35
    Author     : JEFFERSON
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">   
        <title>Los Especiales</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Especiales" method="POST">
                        <div class="form-group">
                            <label><strong>Fecha Especial:</strong></label>
                            <input type="text" value="${especial.getFechaEspecial()}" name="txtFechaEspecial" class="form-control"placeholder="YYYY-MM-DD">
                        </div>
                        <div class="form-group">
                            <label><strong>Cantidad de porciones:</strong></label>
                            <input type="text" value="${especial.getCantidadPorciones()}" name="txtCantidadPorciones" class="form-control">
                        </div> 
                        <div class="form-group">
                            <label><strong>Masa:</strong></label>
                            <input type="text" value="${especial.getMasa()}" name="txtMasa" class="form-control">
                        </div> 
                        <div class="form-group">
                            <label><strong>Relleno:</strong></label>
                            <input type="text" value="${especial.getRelleno()}" name="txtRelleno" class="form-control">
                        </div> 
                        <div class="form-group">
                            <label><strong>Cobertura:</strong></label>
                            <input type="text" value="${especial.getCobertura()}" name="txtCobertura" class="form-control">
                        </div> 
                        <div class="form-group">
                            <label><strong>Descripción Especial:</strong></label>
                            <input type="text" value="${especial.getDescripcionEspecial()}" name="txtDescripcionEspecial" class="form-control">
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
                            <th>CÓDIGO</th>
                            <th>FECHAESPECIAL</th>
                            <th>CANTIDAD PORCIONES</th>
                            <th>MASA</th>
                            <th>RELLENO</th>
                            <th>COBERTURA</th>
                            <th>DESCRIPCION ESPECIAL</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="especial" items="${especiales}">
                        <tr>
                            <td>${especial.getCodigoEspecial()}</td>
                            <td>${especial.getFechaEspecial()}</td>
                            <td>${especial.getCantidadPorciones()}</td>
                            <td>${especial.getMasa()}</td>
                            <td>${especial.getRelleno()}</td>
                            <td>${especial.getCobertura()}</td>
                            <td>${especial.getDescripcionEspecial()}</td>
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Especiales&accion=Editar&codigoEspecial=${especial.getCodigoEspecial()}">Editar</a><br>
                                <a class="btn btn-danger" href="Controlador?menu=Especiales&accion=Eliminar&codigoEspecial=${especial.getCodigoEspecial()}">Eliminar</a>
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
