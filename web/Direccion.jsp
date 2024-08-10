<%-- 
    Document   : Direccion
    Created on : 12/07/2024, 07:55:05 PM
    Author     : DELL
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
                    <form action="Controlador?menu=Direccion" method="POST">
                        <div class="form-group">
                            <label><strong>Codigo Direccion:</strong></label>
                            <input type="text" value="${direccion.getCodigoDireccion()}" name="txtCodigoDireccion" class="form-control" disabled>
                        </div>
                        <div class="form-group">
                            <label><strong>Direccion Completa:</strong></label>
                            <input type="text" value="${direccion.getDireccionCompleta()}" name="txtDireccionCompleta" class="form-control">
                        </div> 
                        <div class="form-group">
                            <label><strong>Departamento:</strong></label>
                            <input type="text" value="${direccion.getDepartamento()}" name="txtDepartamento" class="form-control">
                        </div> 
                        <div class="form-group">
                            <label><strong>Municipio:</strong></label>
                            <input type="text" value="${direccion.getMunicipio()}" name="txtMunicipio" class="form-control">
                        </div> 
                        <div class="form-group">
                            <label><strong>Otro:</strong></label>
                            <input type="text" value="${direccion.getOtro()}" name="txtOtro" class="form-control">
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
                            <th>CODIGODIRECCION</th>
                            <th>DIRECCIONCOMPLETA</th>
                            <th>DEPARTAMENTO</th>
                            <th>MUNICIPIO</th>
                            <th>OTRO</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="direccion" items="${direcciones}">
                        <tr>
                            <td>${direccion.getCodigoDireccion()}</td>
                            <td>${direccion.getDireccionCompleta()}</td>
                            <td>${direccion.getDepartamento()}</td>
                            <td>${direccion.getMunicipio()}</td>
                            <td>${direccion.getOtro()}</td>
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Direccion&accion=Editar&codigoDireccion=${direccion.getCodigoDireccion()}">Editar</a><br>
                                <a class="btn btn-danger" href="Controlador?menu=Direccion&accion=Eliminar&codigoDireccion=${direccion.getCodigoDireccion()}">Eliminar</a>
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
