<%-- 
    Document   : Usuario
    Created on : 13/07/2024, 07:33:25 PM
    Author     : Kendy Rodas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">   
        <title>Usuario</title>
    </head>
    <body>
        <h1 class="text-center my-4" style="color: #ffb6c1;">Gestión de Usuarios</h1>
        <div class="d-flex justify-content-left">
            <div class="card col-md-4 shadow-lg">
                <div class="card-header" style="background-color: #ffb6c1; color: white;">
                <h4 class="mb-0">Usuarios</h4>
                </div>
                <div class="card-body">
                    <form action="Controlador?menu=Usuario" method="POST">
                        <div class="form-group mb-3">
                            <label class="form-label" style="color: #ff85a2;"><strong>Código</strong></label>
                            <input type="text" value="${usuario.getCodigoUsuario()}" name="txtCodigoUsuario" class="form-control"disabled>
                        </div>
                        <div class="form-group">
                            <label class="form-label" style="color: #ff85a2;"><strong>Nombres</strong></label>
                            <input type="text" value="${usuario.getNombresUsuario()}" name="txtNombresUsuario" class="form-control">
                        </div>
                        <div class="form-group">
                            <label class="form-label" style="color: #ff85a2;"><strong>Apellidos</strong></label>
                            <input type="text" value="${usuario.getApellidosUsuario()}" name="txtApellidosUsuario" class="form-control">
                        </div>
                        <div class="form-group">
                            <label class="form-label" style="color: #ff85a2;"><strong>Telefono</strong></label>
                            <input type="text" value="${usuario.getTelefonoUsuario()}" name="txtTelefonoUsuario" class="form-control">
                        </div>
                        <div class="form-group">
                            <label class="form-label" style="color: #ff85a2;"><strong>Correo</strong></label>
                            <input type="text" value="${usuario.getCorreoUsuario()}" name="txtCorreoUsuario" class="form-control">
                        </div>
                        <div class="form-group">
                            <label class="form-label" style="color: #ff85a2;"><strong>Usuario</strong></label>
                            <input type="text" value="${usuario.getUsuario()}" name="txtUsuario" class="form-control">
                        </div>
                        <div class="form-group">
                            <label class="form-label" style="color: #ff85a2;"><strong>Contraseña</strong></label>
                            <input type="password" value ="${usuario.getContrasena()}" name="txtPassword" class="form-control">
                        </div>
                        <div class="form-group ">
                            <label class="form-label" style="color: #ff85a2;" ><strong>Tipo Usuario</strong></label>
                            <input type="text" value="${usuario.getCodigoTipoUsuario()}" name="txtTipoUsuario" class="form-control">
                        </div>
                         <select name="ddlTipoUsuario" class="form-control" disabled>
                               <option value="">Tipo Usuario</option> <!-- Opción por defecto -->
                            <c:forEach var="tipoUsuario" items="${tipoUsuarios}">
                                <option value="${tipoUsuario.codigoTipoUsuario}"
                                    <c:if test="${tipoUsuario.codigoTipoUsuario == usuario.codigoTipoUsuario}">
                                        selected
                                    </c:if>
                                >${tipoUsuario.nombreTipoUsuario}</option>
                            </c:forEach>
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
                            <th>NOMBRES</th>
                            <th>APELLIDOS</th>
                            <th>TELEFONO</th>
                            <th>CORREO</th>
                            <th>USUARIO</th>
                            <th>TIPO USUARIO</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="usuario" items="${usuarios}" >
                            <tr>
                                <td>${usuario.getCodigoUsuario()}</td>
                                <td>${usuario.getNombresUsuario()}</td>
                                <td>${usuario.getApellidosUsuario()}</td>
                                <td>${usuario.getTelefonoUsuario()}</td>
                                <td>${usuario.getCorreoUsuario()}</td>
                                <td>${usuario.getUsuario()}</td>
                                <td>${usuario.getCodigoTipoUsuario()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Usuario&accion=Editar&codigoUsuario=${usuario.getCodigoUsuario()}">Editar</a>
                                    <a class=" btn btn-danger" href="Controlador?menu=Usuario&accion=Eliminar&codigoUsuario=${usuario.getCodigoUsuario()}">ELIMINAR</a>
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
