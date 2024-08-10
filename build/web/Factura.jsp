<%-- 
    Document   : Factura
    Created on : Jul 12, 2024, 6:38:54 PM
    Author     : juan0
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">   
        <title>Factura</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Factura" method ="POST">
                        <div class="form-group">
                            <label><strong>NIT Factura:</strong></label>
                            <input type="text" value="${factura.getNITFactura()}" name="txtNITFactura" class="form-control">
                        </div>
                         <div class="form-group">
                            <label><strong>Método de Pago:</strong></label>
                            <input type="text" value="${factura.getMetodoPago()}" name="txtMetodoPago" class="form-control">
                        </div>
                         <div class="form-group">
                            <label><strong>Estado:</strong></label>
                            <input type="text" value="${factura.getEstadoFactura()}" name="txtEstadoFactura" class="form-control">
                        </div>
                        <div class="form-group">
                            <label><strong>Código de Pedido:</strong></label>
                            <input type="text" value="${factura.getCodigoPedido()}" name="txtCodigoPedido" class="form-control">
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
                             <th>NIT</th>
                             <th>MÉTODO DE PAGO</th>
                             <th>ESTADO DE LA FACTURA</th>
                             <th>NO.PEDIDO</th>  
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="factura"items="${facturas}">
                        <tr>
                            <td>${factura.getCodigoFactura()}</td>
                            <td>${factura.getNITFactura()}</td>
                            <td>${factura.getMetodoPago()}</td>
                            <td>${factura.getEstadoFactura()}</td>
                            <td>${factura.getCodigoPedido()}</td>
                            <td>
                               <a class="btn btn-warning" href="Controlador?menu=Factura&accion=Editar&codigoFactura=${factura.getCodigoFactura()}">Editar</a>
                               <a class="btn btn-danger" href="Controlador?menu=Factura&accion=Eliminar&codigoFactura=${factura.getCodigoFactura()}">Eliminar</a>
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
