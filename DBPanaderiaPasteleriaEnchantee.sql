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



