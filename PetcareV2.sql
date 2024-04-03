drop database petcare;
create database petcare;
use petcare;

# nada
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
tipoPerfil tinyint(1),
constraint pk_cuenta primary key (idCuenta)
);

# Debe tener los animales. Debe tener una descripción corta y una larga.
#  Debe contener un numero que identifique las veces que un usuario se ha conectado. 
# El numero nos servirá para poder identificar la primera vez que el usuario se conecta como dueño.
create table dueño
(
idDueño int auto_increment,
descripcion varchar(100),
accesFirstTime int,
cuentaDueño int,
constraint pk_dueño primary key (idDueño),
constraint fk_dueñoUno foreign key (cuentaDueño) references cuenta(idCuenta)
on delete cascade on update cascade
);

# Debe tener los animales que cuida. Debe tener una descripción larga y una corta.
# Debe tener puntuación.
create table cuidador
(
idCuidador int auto_increment,
descripcion longtext,
accesFirstTime int,
cuentaCuidador int,
constraint pk_cuidador primary key (idCuidador),
constraint fk_cuidadorUno foreign key (cuentaCuidador) references cuenta(idCuenta)
on delete cascade on update cascade
);

# nada
create table servicios
(
idServicio int auto_increment,
nombreServicio varchar(100),
constraint pk_servicio primary key (idServicio)
);
# Revisar enpoints que devuelvan información que provenga de esta tabla porque la he modificado
create table servicioCuidador
(
idServicio int,
idCuidador int,
cuidadorSC int,
servicioSC int,
constraint pf_servicioCuidador primary key(idServicio, idCuidador),
constraint fk_uno foreign key (cuidadorSC) references cuidador(idCuidador)
on delete cascade on update cascade,
constraint fk_dos foreign key (servicioSC) references servicios(idServicio)
on delete cascade on update cascade
);

#Esta tabla contendrá los dias no disponibles de un cuidador para las reservas
create table DiaNoDisponible
(

);

# Esta tabla es para guardar los usuarios que un cuidador ha guardado en favoritos
create table cuidadorFavorito
(
idCuidadorFavorito int,
idDueñoDelFavorito int,
constraint pk_cuidadorFavorito primary key (idCuidadorFavorito, idDueñoDelFavorito),
constraint fk_cuidadorFavorito foreign key (idCuidadorFavorito) references cuidador(idCuidador)
on delete cascade on update cascade,
constraint fk_dueloDelFavorito foreign key (idDueñoDelFavorito) references dueño(idDueño)
on delete cascade on update cascade
);

# Debe tener la fecha y la hora de la reserva. Debe tener la ubicación. Debe tener 
create table reservas
(
idReserva int auto_increment,
cuidadorR int,
duenyoR int,
constraint pk_reserva primary key (idReserva),
constraint fk_cuidadorR foreign key (cuidadorR) references cuidador(idCuidador)
on delete cascade on update cascade,
constraint fk_duenyoR foreign key (duenyoR) references dueño(idDueño)
on delete cascade on update cascade
);

# Aquí guardaremos el animal
create table animal
(
idAnimal int auto_increment,
nombre varchar(100) not null,
constraint pk_animal primary key (idAnimal)
);

#Aquí guardaremos la raza de los animales
create table raza
(
idRaza int auto_increment,
nombre varchar(100) not null,
animalRaza int,
constraint pk_raza primary key (idRaza),
constraint fk_animal foreign key (animalRaza) references animal(idAnimal)
on delete cascade on update cascade

);

create table alimento
(
idAlimento int auto_increment,
nombre varchar(100),
constraint pk_alimento primary key (idAlimento)
);

# Aquí guardaremos todas las mascotas que tiene un usuario dueño
create table mascota
(
idMascota int auto_increment,
nombre varchar(100),
edad int, 
peso float,
descEnfermedades longtext,
descSobreMascota longtext,
alimentoMascota int,
duenyoMascota int,
razaMascota int,
constraint pk_mascota primary key (idMascota),
constraint fk_alimento foreign key (alimentoMascota) references alimento(idAlimento) 
on delete cascade on update cascade,
constraint fk_duenyo foreign key (duenyoMascota) references dueño(idDueño)
on delete cascade on update cascade,
constraint fk_raza foreign key (razaMascota) references raza(idRaza)
on delete cascade on update cascade
);

create table mascotaReservado
(

);

create table cuidadorAnimal
(

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






