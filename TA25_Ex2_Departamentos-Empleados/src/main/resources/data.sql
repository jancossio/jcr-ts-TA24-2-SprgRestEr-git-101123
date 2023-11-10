DROP TABLE IF EXISTS empleados;
DROP table IF EXISTS departamento;


CREATE TABLE departamento (
  codigo int NOT NULL AUTO_INCREMENT,
  nombre varchar(250) DEFAULT NULL,
  presupuesto int DEFAULT NULL,
  PRIMARY KEY (codigo)
);

CREATE TABLE empleados (
  dni varchar(8) NOT NULL,
  nombre varchar(250) DEFAULT NULL,
  apellido varchar(250) DEFAULT NULL,
  departamento  int DEFAULT NULL,
  PRIMARY KEY (dni),
  FOREIGN KEY (departamento) REFERENCES departamento (codigo)
);


insert into departamento (nombre, presupuesto)values('Desarrollo', 9000);
insert into departamento (nombre, presupuesto)values('Investigacion', 6000);
insert into departamento (nombre, presupuesto)values('Marketing', 3000);
insert into departamento (nombre, presupuesto)values('RRHH', 2000);
insert into departamento (nombre, presupuesto)values('Calidad', 1500);

insert into empleados (dni, nombre, apellido, departamento) values ('qwertyui','Elena','Morada',1);
insert into empleados (dni, nombre, apellido, departamento) values ('zxcvbnmk','Patricia','Lopez',3);
insert into empleados (dni, nombre, apellido, departamento) values ('zdkfghml','Anna','Perez',4);