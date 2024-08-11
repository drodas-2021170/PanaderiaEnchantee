<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Carrito de Compras</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
    <style>
        .form-control {
            margin-bottom: 1rem;
        }
        .btn-outline-info {
            margin-left: 10px;
        }
        .card-footer {
            background-color: #f8f9fa;
        }
        
        @media print{
            .parte1, .btn, .botonesN{
                display: none;
            }
        }
    </style>
</head>
<body>
    <div class="container mt-4 ">
        <div class="row">
            <div class="col-md-4 parte1">
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title">Detalles del Carrito</h5>
                    </div>
                    <div class="card-body">
                        <form action="Controlador?menu=Carrito" method="POST">
                            <div class="form-group">
                                <label>Datos Pedido</label>
                                <div class="input-group mb-3">
                                    <input type="text" name="txtCodigoPedido" value="${pedido.codigoPedido}" class="form-control" placeholder="Código">
                                    <div class="input-group-append">
                                        <button type="submit" name="accion" value="BuscarPedido" class="btn btn-outline-info">Buscar</button>
                                    </div>
                                </div>
                                <input type="text" name="txtNombreReceptor" value="${pedido.nombreReceptor}" class="form-control" placeholder="Nombre">
                                
                            </div>
                            <div class="form-group">
                                <label><strong>Datos Producto:</strong></label>
                                <div class="input-group mb-3">
                                    <input type="text" name="txtCodigoProducto" value="${producto.codigoProducto}" class="form-control" placeholder="Código Producto">
                                    <div class="input-group-append">
                                        <button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info">Buscar</button>
                                    </div>
                                </div>
                                <input type="text" name="txtNombreProducto" value="${producto.nombreProducto}" class="form-control" placeholder="Nombre Producto">
                                <input type="number" name="txtCantidad" value="1" class="form-control" placeholder="Cantidad" min="1">
                                <input type="text" name="txtPrecio" value="${producto.precio}" class="form-control" placeholder="Precio" readonly>
                                <input type="text" name="txtDisponibilidad" value="${producto.disponibilidad}" class="form-control" placeholder="Disponibilidad" readonly>
                                <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info mt-2">Agregar al Carrito</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title">Productos en el Carrito</h5>
                    </div>
                    <div class="card-body">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Descripción</th>
                                    <th>Cantidad</th>
                                    <th>Precio Unitario</th>
                                    <th>Subtotal</th>
                                    <th class="botonesN">Acción</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="item" items="${lista}">
                                    <tr>
                                        <td>${item.item}</td>
                                        <td>${item.descripcionCarrito}</td>
                                        <td>${item.cantidad}</td>
                                        <td>${item.precio}</td>
                                        <td>${item.subTotal}</td>
                                        <td>
                                            <form action="Controlador?menu=Carrito" method="POST" style="display:inline;">
                                                <input type="hidden" name="codigo" value="${item.codigoProducto}">
                                                <button type="submit" name="accion" value="Eliminar" class="btn btn-outline-danger btn-sm">Eliminar</button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer">
                        <div class="row">
                            <div class="col-md-6">
                                <form action="Controlador?menu=Carrito" method="POST">
                                    <button type="submit" name="accion" value="GenerarVenta" onclick ="print()" class="btn btn-primary">Generar Venta</button>
                                    <button type="submit" name="accion" value="Cancelar" class="btn btn-secondary">Cancelar</button>
                                </form>
                            </div>
                            <div class="col-md-6 text-right">
                                <p><strong>Total:</strong> ${total}</p>
                                <p><strong>Impuesto (12%):</strong> ${impuesto}</p>
                                <p><strong>Total con Impuesto:</strong> ${total + impuesto}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>