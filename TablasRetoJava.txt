CREATE TABLE USUARIOS(
idUsuario number(10) constraint PK_idUsuario Primary Key,
nombreUsuario varchar2(20),
apellidoUsuario varchar2(40),
emailUsuario varchar2(50),
password varchar2(40),
direccion varchar2(20),
edAdmin number(1));


CREATE TABLE TIPO(
idTipo number(10) constraint PK_idTipo Primary Key,
nombreTipo varchar2(20));


CREATE TABLE PRODUCTOS(
idProd number(10) constraint PK_idProd Primary Key,
nombreProd varchar2(20),
descriptProd varchar2(100),
medidasProd varchar2(10),
idTipo number(10) constraint FK_idTipo references TIPO(idTipo));


CREATE TABLE COMPRAS(
idCompra number(10) constraint PK_idCompra Primary Key,
idUsuario number(10) constraint FK_idUsuario references USUARIOS(idUsuario),
idProd number(10) constraint FK_idProdCompras references PRODUCTOS(idProd),
fechaCompra date);