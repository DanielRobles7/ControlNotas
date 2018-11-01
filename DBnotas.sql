create database control_notas;
use control_notas;

create table acceso(
id_acceso int not null auto_increment primary key,
usuario varchar(50),
contrasena varchar(50),
nivel_acceso varchar(50),
campo varchar(20)
);

create table escuelas(
codigo_escuela int not null primary key,
nombre_escuela varchar(100),
direccion varchar (200),
municipio varchar (20),
telefono varchar(20),
correo varchar(20),
longitud varchar(20),
latitud varchar(20),
nombre_director varchar(50),
id_acceso int not null,
campo varchar(20),
foreign key (id_acceso) references acceso (id_acceso)
);

create table nivel(
grado varchar(20) not null primary key,
codigo_escuela int not null,
campo varchar(20),
foreign key (codigo_escuela) references escuelas (codigo_escuela)
);

create table alumnos(
nie int not null primary key, 
nombre varchar(50),
apellido varchar(50),
email varchar(30),
direccion varchar(200),
edad int(2),
telefono varchar(15),
fecha_nacimiento varchar(20),
fecha_registro varchar(20),
id_acceso int not null,
codigo_escuela int not null,
grado varchar(20) not null,
campo varchar(20),
foreign key (id_acceso) references acceso (id_acceso),
foreign key (codigo_escuela) references escuelas (codigo_escuela),
foreign key (grado) references nivel (grado)
);

create table profesores(
escalafon int not null primary key,
nombre varchar(50),
apellido varchar(50),
email varchar(30),
direccion varchar(200),
edad int(2),
telefono varchar(15),
fecha_nacimiento varchar(20),
fecha_registro varchar(20),
id_acceso int not null,
codigo_escuela int not null,
grado varchar(20) not null,
campo varchar(20),
foreign key (id_acceso) references acceso (id_acceso),
foreign key (codigo_escuela) references escuelas (codigo_escuela),
foreign key (grado) references nivel (grado)
);

create table materias(
nombre_materia varchar(50) not null primary key,
grado varchar(20) not null,
ponderacion_1 double(5,2),
ponderacion_2 double(5,2),
ponderacion_3 double(5,2),
ponderacion_4 double(5,2),
ponderacion_5 double(5,2),
ponderacion_6 double(5,2),
campo varchar(20),
foreign key (grado) references nivel (grado)
);

create table notas(
id_nota int not null auto_increment primary key,
nombre_materia varchar(50) not null,
nota_1 double(5,2),
nota_2 double(5,2),
nota_3 double(5,2),
nota_4 double(5,2),
nota_5 double(5,2),
nota_6 double(5,2),
promerio double(5,2),
reposicion double(5,2),
final double(5,2),
campo varchar(20),
foreign key (nombre_materia) references materias (nombre_materia)
);