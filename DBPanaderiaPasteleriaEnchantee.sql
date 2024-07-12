drop database if exists DBPanaderiaPasteleriaEnchantee;
create database DBPanaderiaPasteleriaEnchantee;

use DBPanaderiaPasteleriaEnchantee;
 
create table TipoProducto(
	codigoTipoProducto int not null auto_increment,
    nombreTipoProducto varchar(50),
    descripcion varchar(100) not null,
    temporada varchar(50) not null,
    primary key PK_codigoTipoProducto (codigoTipoProducto)
);

create table TipoUsuario(
	codigoTipoUsuario int auto_increment not null,
    nombreTipoUsuario varchar(45) not null,
    descripcion varchar(50) not null,
    permisos varchar(50) not null,
    estado boolean not null,
    primary key PK_codigoTipoUsuario (codigoTipoUsuario)
);

create table Especial(
	codigoEspecial int not null auto_increment,
    fechaEspecial date not null,
    cantidadPorciones varchar(30) not null,
    masa varchar(40) not null,
    relleno varchar(40) not null,
    cobertura varchar(40) not null,
    descripcionEspecial varchar(100) not null,
    primary key PK_codigoEspecial (codigoEspecial)
);

create table Direccion(
	codigoDireccion int not null auto_increment,
    direccionCompleta varchar(150) not null,
    departamento varchar(50) not null,
    municipio varchar(50) not null,
    otro varchar(100),
    primary key PK_codigoDireccion (codigoDireccion) 
);

create table Locales(
	codigoLocal int not null,
	nombreLocal varchar(30) not null,
    horariosLocal varchar(50) not null,
    horariosEspecialLocal varchar(50),
    telefonoLocal varchar(9) not null,
    codigoDireccion int not null,
    primary key PK_codigoLocal (codigoLocal),
    constraint FK_Locales_Direccion foreign key
		(codigoDireccion) references Direccion(codigoDireccion)
);

create table Producto(
	codigoProducto int not null,
    nombreProducto varchar(70) not null,
    descripcion varchar(150) not null,
    precio decimal(10,2) not null,
    disponibilidad boolean not null,
    existencia int not null,
    imagen longblob,
    ingredientes varchar(200),
    codigoTipoProducto int not null,
    primary key PK_CodigoProducto (codigoProducto),
    constraint FK_Producto_TipoProducto foreign key
		(codigoTipoProducto) references TipoProducto (codigoTipoProducto)
);

create table Promocion(
	codigoPromocion int auto_increment not null,
    nombrePromocion varchar(50) not null,
    fechaInicio date not null,
    fechaFin date not null,
    precioPromocion double(10,2) not null,
    codigoProducto int not null,
    primary key PK_codigoPromocion (codigoPromocion),
    constraint FK_Promocion_Producto foreign key
		(codigoProducto) references Producto (codigoProducto)
);

create table DetalleCarrito(
	codigoDetalleCarrito int not null auto_increment,
    cantidad int not null,
    subtotal decimal(10,2),
    codigoProducto int not null,
	codigoEspecial int,
    Primary key PK_codigoDetalleCarrito (codigoDetalleCarrito),
	constraint FK_DetalleCarrito_Producto foreign key
		(codigoProducto) references Producto (codigoProducto),
	constraint FK_DetalleCarrito_Especial foreign key 
		(codigoEspecial) references Especial (codigoEspecial)
);

create table Usuario(
	codigoUsuario int auto_increment not null ,
    nombresUsuario varchar(50) not null,
    apellidosUsuario varchar(50) not null,
    telefonoUsuario varchar(9) not null,
    correoUsuario varchar(70) not null,
	usuario varchar(70) not null,
	contrasena varchar(70) not null,
    codigoTipoUsuario int not null,
    primary key PK_codigoUsuario (codigoUsuario),
    constraint FK_Usuario_TipoUsuario foreign key
		(codigoTipoUsuario) references TipoUsuario (codigoTipoUsuario)
);

create table Pedido(
	codigoPedido int not null auto_increment,
    nombreReceptor varchar(50) not null,
    apellidoReceptor varchar(50) not null,
    telefonoReceptor varchar(9)not null,
    telefonoSecundario varchar(9),
    correoReceptor varchar(50) not null,
    codigoDireccion int not null,
    codigoUsuario int not null,
    primary key PK_codigoPedido (codigoPedido),
    constraint FK_Pedido_Direccion foreign key
		(codigoDireccion) references Direccion (codigoDireccion),
	constraint FK_Pedido_Usuario foreign key
		(codigoUsuario) references Usuario (codigoUsuario)
);


create table Carrito(
	codigoCarrito int not null auto_increment,
    total decimal(10,2) default 0 ,
    impuesto decimal(10,2) default 0,
	descripcionCarrito varchar(100) not null,
    codigoDetalleCarrito int not null,
    codigoPedido int not null,
    primary key PK_codigoCarrito (codigoCarrito),
    constraint FK_Carrito_DetalleCarrito foreign key
		(codigoDetalleCarrito) references DetalleCarrito (codigoDetalleCarrito),
	constraint FK_Carrito_Pedido foreign key
		(codigoPedido) references Pedido (codigoPedido)
);

create table Factura(
	codigoFactura int not null auto_increment,
    NITFactura varchar(10) not null,
    metodoPago varchar(30) not null,
    estadoFactura boolean,
	codigoPedido int not null,
    primary key PK_codigoFactura (codigoFactura),
    constraint FK_Factura_Pedido foreign key
		(codigoPedido) references Pedido (codigoPedido)
);

insert into TipoUsuario (nombreTipoUsuario, descripcion, permisos, estado) values ('Administrador', 'Encargado de llevar el orden de la página web', 'Todos', true);
insert into TipoUsuario (nombreTipoUsuario, descripcion, permisos, estado) values ('Cliente', 'Persona que accede a la página para comprar', 'Limitados', true);