
DROP TABLE IF EXISTS `departamentos`;
CREATE TABLE `departamentos` (
  `CODIGO` int NOT NULL,
  `NOMBRE` varchar(255) NOT NULL,
  `PRESUPUESTO` decimal(10,0) NOT NULL,
  PRIMARY KEY (`CODIGO`)
);

INSERT INTO `departamentos` VALUES (14,'IT',65000),(37,'Accounting',15000),(59,'Human Resources',240000),(77,'Research',55000);


DROP TABLE IF EXISTS `empleados`;
CREATE TABLE `empleados` (
  `DNI` int NOT NULL,
  `NOMBRE` varchar(255) NOT NULL,
  `APELLIDOS` varchar(255) NOT NULL,
  `DEPARTAMENTO` int NOT NULL,
  PRIMARY KEY (`DNI`),
  CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`DEPARTAMENTO`) REFERENCES `departamentos` (`CODIGO`)
);

INSERT INTO `empleados` VALUES (123234877,'Michael','Rogers',14),(152934485,'Anand','Manikutty',14);

