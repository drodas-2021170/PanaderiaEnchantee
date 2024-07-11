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





