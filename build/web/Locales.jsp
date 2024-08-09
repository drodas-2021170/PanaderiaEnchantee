<%-- 
    Document   : Locales
    Created on : 12/07/2024, 06:02:49 PM
    Author     : diego
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">   
        <title>Página Locales</title>
    </head>
    <body>
      <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Locales" method="POST">
                        <div class="form-group">
                            <label><strong>CodLocal:</strong></label>
                            <input type="text" value="${locales.getCodigoLocal()}" name="txtCodigoLocal" class="form-control">
                        </div>
                         <div class="form-group">
                            <label><strong>Nombre Local:</strong></label>
                            <input type="text" value="${locales.getNombreLocal()}" name="txtNombreLocal" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Horarios:</strong></label>
                            <input type="text" value="${locales.getHorariosLocal()}" name="txtHorariosLocal" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Horarios Especiales:</strong></label>
                            <input type="text" value="${locales.getHorarioEspecialLocal()}" name="txtHorarioEspecialLocal" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Telefono Local:</strong></label>
                            <input type="text" value="${locales.getTelefonoLocal()}" name="txtTelefonoLocal" class="form-control">
                        </div>
                         <div class="form-group">
                            <label><strong>Direccion Local:</strong></label>
                            <input type="text" value="${locales.getCodigoDireccion()}" name="txtCodigoDireccion" class="form-control">
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
                            <th>CODIGO LOCAL</th>
                             <th>NOMBRE LOCAL</th>
                             <th>HORARIOS</th>
                             <th>HORARIOS ESPECIALES</th>
                             <th>TELEFONO</th>
                             <th>DIRECCION</th>
            
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="locales" items="${local}">
                        <tr>
                            <td>${locales.getCodigoLocal()}</td>
                            <td>${locales.getNombreLocal()}</td>
                            <td>${locales.getHorariosLocal()}</td>
                            <td>${locales.getHorarioEspecialLocal()}</td>
                            <td>${locales.getTelefonoLocal()}</td>
                            <td>${locales.getCodigoDireccion()}</td>
                            <td>
                               <a class="btn btn-warning" href="Controlador?menu=Locales&accion=Editar&codigoLocal=${locales.getCodigoLocal()}">Editar</a>
                               <a class="btn btn-danger" href="Controlador?menu=Locales&accion=Eliminar&codigoLocal=${locales.getCodigoLocal()}">Eliminar</a> 
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div> 
        </div>    
    </body>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script> 
</html>
