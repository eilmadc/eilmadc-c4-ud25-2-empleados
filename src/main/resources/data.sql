
DROP TABLE IF EXISTS departamentos;
CREATE TABLE departamentos (
  CODIGO int NOT NULL AUTO_INCREMENT,
  NOMBRE varchar(255) DEFAULT NULL,
  PRESUPUESTO decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (CODIGO)
);




DROP TABLE IF EXISTS empleados;
CREATE TABLE empleados (
  DNI varchar(8) NOT NULL,
  NOMBRE varchar(255) DEFAULT NULL,
  APELLIDOS varchar(255) DEFAULT NULL,
  PRIMARY KEY (DNI),
  DEPARTAMENTO int DEFAULT NULL,
  CONSTRAINT empleados_ibfk_1 FOREIGN KEY (DEPARTAMENTO) REFERENCES departamentos (CODIGO) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO departamentos (codigo, nombre, presupuesto) VALUES (14,'IT',65000),(37,'Accounting',15000),(59,'Human Resources',240000),(77,'Research',55000);
INSERT INTO empleados  (dni, nombre, apellidos, departamento) VALUES('12323487','Michael','Rogers',14),('15293445','Anand','Manikutty',14);

