<%-- 
    Document   : Pedido
    Created on : 12-jul-2024, 19:12:34
    Author     : josem
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles.css" rel="stylesheet" type="text/css"/>
        <title>Pedido</title>
    </head>
    <body>
        <h1 class="text-center my-4 title">Gestión de Tipo de Pedido</h1>
        <div class="container d-flex justify-content-between">
            <div class="custom-card col-md-5 shadow-sm">
                <div class="title">
                    <h4 class="mb-0">Pedido</h4>
                </div>
                <div class="custom-card-body">
                    <form action="Controlador?menu=Pedido" method="POST">
                        <div class="form-group mb-3">
                            <label><strong>Nombre: </strong></label>
                            <input type="text" value="${pedido.getNombreReceptor()}" name="txtNombreReceptor" class="form-control">
                        </div>
                        <div class="form-group mb-3">
                            <label><strong>Apellido: </strong></label>
                            <input type="text" value="${pedido.getApellidoReceptor()}" name="txtApellidoReceptor" class="form-control">
                        </div> 
                        <div class="form-group mb-3">
                            <label><strong>Telefono: </strong></label>
                            <input type="text" value="${pedido.getTelefonoReceptor()}" name="txtTelefonoReceptor" class="form-control">
                        </div>
                        <div class="form-group mb-3">
                            <label><strong>Telefono Secundario: </strong></label>
                            <input type="text" value="${pedido.getTelefonoSecundario()}" name="txtTelefonoSecundario" class="form-control">
                        </div>
                        <div class="form-group mb-3">
                            <label><strong>Correo: </strong></label>
                            <input type="text" value="${pedido.getCorreoReceptor()}" name="txtCorreoReceptor" class="form-control">
                        </div>
                        <div class="form-group mb-3">
                            <label><strong>Codigo Receptor: </strong></label>
                            <input type="text" value="${pedido.getCodigoDireccion()}" name="txtCodigoReceptor" class="form-control">
                        </div>
                        <div class="form-group mb-4">
                            <label><strong>Codigo Usuario</strong></label>
                            <input type="text" value="${pedido.getCodigoUsuario()}" name="txtCodigoUsuario" class="form-control">
                        </div>
                        <div class="d-flex justify-content-between">
                            <input type="submit" name="accion" value="Agregar" class="btn custom-btn-pink">
                            <input type="submit" name="accion" value="Actualizar" class="btn custom-btn-light-pink">
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-md-6 mt-4">
                <table class="table table-hover table-bordered custom-table">
                    <thead class="custom-thead-pink">
                        <tr>
                            <th>Codigo</th>
                            <th>Nombres</th>
                            <th>Apellidos</th>
                            <th>Telefono</th>
                            <th>Telefono2</th>
                            <th>Correo</th>
                            <th>Cod-Receptor</th>
                            <th>cod-Usuario</th>
                            <th>acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pedi" items="${pedidos}">
                            <tr>
                                <td>${pedi.getCodigoPedido()}</td>
                                <td>${pedi.getNombreReceptor()}</td>
                                <td>${pedi.getApellidoReceptor()}</td>
                                <td>${pedi.getTelefonoReceptor()}</td>
                                <td>${pedi.getTelefonoSecundario()}</td>
                                <td>${pedi.getCorreoReceptor()}</td>
                                <td>${pedi.getCodigoDireccion()}</td>
                                <td>${pedi.getCodigoUsuario()}</td>
                                <td class="text-center">
                                    <a class="btn custom-btn-warning btn-sm me-2" href="Controlador?menu=Pedido&accion=Editar&codigoPedido=${pedi.getCodigoPedido()}"><i class="fas fa-edit">Editar</i></a> 
                                    <a class="btn custom-btn-danger btn-sm" href="Controlador?menu=Pedido&accion=Eliminar&codigoPedido=${pedi.getCodigoPedido()}"><i class="fas fa-trash-alt">Eliminar</i></a>
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
