<%-- 
    Document   : TipoProducto
    Created on : 12/07/2024, 03:30:14 PM
    Author     : julia
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">   
        <title>TipoProducto</title>
    </head>
    <body>
    <h1 class="text-center my-4" style="color: #ffb6c1;">Gestión de Tipo de Producto</h1>
<div class="d-flex justify-content-left">
    <div class="card col-md-4 shadow-lg">
        <div class="card-header" style="background-color: #ffb6c1; color: white;">
            <h4 class="mb-0">Detalles del Tipo de Producto</h4>
        </div>
        <div class="card-body">
            <form action="Controlador?menu=TipoProducto" method="POST">
                <div class="form-group mb-3">
                    <label for="nombreProducto" class="form-label" style="color: #ff85a2;"><strong>Codigo Tipo Producto:</strong></label>
                    <input type="text" id="nombreTipo" value="${tipoProducto.getCodigoTipoProducto()}" name="txtCodigoTipoProducto" class="form-control" placeholder="Codigo" disabled= >
                </div>
                <div class="form-group mb-3">
                    <label for="nombreProducto" class="form-label" style="color: #ff85a2;"><strong>Nombre Tipo Producto:</strong></label>
                    <input type="text" id="nombreTipo" value="${tipoProducto.getNombreTipoProducto()}" name="txtNombreTipoProducto" class="form-control" placeholder="Ingrese el nombre">
                </div>
                <div class="form-group mb-3">
                   <label for="descripcion" class="form-label" style="color: #ff85a2;"><strong>Descripción:</strong></label>
                   <input type="text" id="descripcion" value="${tipoProducto.getDescripcion()}" name="txtDescripcion" class="form-control" placeholder="Ingrese una descripción">
                </div>
                <div class="form-group mb-4">
                    <label for="temporada" class="form-label" style="color: #ff85a2;"><strong>Temporada:</strong></label>
                    <input type="text" id="temporada" value="${tipoProducto.getTemporada()}" name="txtTemporada" class="form-control" placeholder="Ingrese la temporada">
                </div>
                <div class="d-flex justify-content-between">
                    <button type="submit" name="accion" value="Agregar" class="btn" style="background-color: #ffb6c1; color: white;"><i class="fas fa-plus"></i> Agregar</button>
                    <button type="submit" name="accion" value="Actualizar" class="btn" style="background-color: #ff85a2; color: white;"><i class="fas fa-sync-alt"></i> Actualizar</button>
                </div>
            </form>
        </div>
    </div>
    <div class="col-sm-8 mt-4">
        <table class="table table-hover table-bordered">
            <thead style="background-color: #ff85a2; color: white;">
                <tr>
                    <th>Codigo</th> 
                    <th>Nombre Tipo Producto</th>
                    <th>Descripción</th>
                    <th>Temporada</th>
                    
                </tr>
            </thead>
            <tbody>
                <c:forEach var="tipoProducto" items="${TipoProductos}">
                    <tr>
                        <td>${tipoProducto.getCodigoTipoProducto()}</td>
                        <td>${tipoProducto.getNombreTipoProducto()}</td>
                        <td>${tipoProducto.getDescripcion()}</td>
                        <td>${tipoProducto.getTemporada()}</td>   
                        <td class="text-center">
                            <a class="btn btn-warning btn-sm me-2" href="Controlador?menu=TipoProducto&accion=Editar&codigoTipoProducto=${tipoProducto.codigoTipoProducto}">
                                <i class="fas fa-edit"></i> Editar
                            </a>
                            <a class="btn btn-danger btn-sm" href="Controlador?menu=TipoProducto&accion=Eliminar&codigoTipoProducto=${tipoProducto.codigoTipoProducto}">
                                <i class="fas fa-trash-alt"></i> Eliminar
                            </a>
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