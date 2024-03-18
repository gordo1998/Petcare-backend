drop database petcare;
create database petcare;
use petcare;

create table cuenta
(
idCuenta int auto_increment,
nombre varchar(100),
apellidoPrimero varchar(100),
apellidoDos varchar(100),
username varchar(100),
passwd varchar(100),
email varchar(100),
movil int(9),
telefono int(9),
urlImagenes varchar(200),
tipoPerdil boolean,
constraint pk_cuenta primary key (idCuenta)
);

create table dueño
(
idDueño int auto_increment,
descripcion varchar(100),
cuentaDueño int,
constraint pk_dueño primary key (idDueño),
constraint fk_dueñoUno foreign key (cuentaDueño) references cuenta(idCuenta)
);

create table cuidador
(
idCuidador int auto_increment,
descripcion longtext,
cuentaCuidador int,
constraint pk_cuidador primary key (idCuidador),
constraint fk_cuidadorUno foreign key (cuentaCuidador) references cuenta(idCuenta)
);

create table servicios
(
idServicio int auto_increment,
nombreServicio varchar(100),
constraint pk_servicio primary key (idServicio)
);

create table servicioCuidador
(
idServicio int,
idCuidador int,
cuidadorSC int,
servicioSC int,
constraint pf_servicioCuidador primary key(idServicio, idCuidador),
constraint fk_uno foreign key (cuidadorSC) references cuidador(idCuidador),
constraint fk_dos foreign key (servicioSC) references servicios(idServicio)
);


create table reservas
(
idReserva int auto_increment,
cuidadorR int,
duenyoR int,
constraint pk_reserva primary key (idReserva),
constraint fk_cuidadorR foreign key (cuidadorR) references cuidador(idCuidador),
constraint fk_duenyoR foreign key (duenyoR) references dueño(idDueño)
);

use petcare;

CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `petcare`.`sacarcuidadores` AS
    SELECT 
        `petcare`.`cuenta`.`idCuenta` AS `idCuenta`,
        `petcare`.`cuenta`.`nombre` AS `nombre`,
        `petcare`.`cuenta`.`apellidoPrimero` AS `apellidoPrimero`,
        `petcare`.`cuenta`.`apellidoDos` AS `apellidoDos`,
        `petcare`.`cuenta`.`username` AS `username`,
        `petcare`.`cuenta`.`passwd` AS `passwd`,
        `petcare`.`cuenta`.`email` AS `email`,
        `petcare`.`cuenta`.`movil` AS `movil`,
        `petcare`.`cuenta`.`telefono` AS `telefono`,
        `petcare`.`cuenta`.`urlImagenes` AS `urlImagenes`,
        `petcare`.`cuenta`.`tipoPerdil` AS `tipoPerdil`,
        `petcare`.`cuidador`.`idCuidador` AS `idCuidador`,
        `petcare`.`cuidador`.`descripcion` AS `descripcion`,
        `petcare`.`cuidador`.`cuentaCuidador` AS `cuentaCuidador`
    FROM
        (`petcare`.`cuenta`
        JOIN `petcare`.`cuidador` ON ((`petcare`.`cuenta`.`idCuenta` = `petcare`.`cuidador`.`cuentaCuidador`)))






