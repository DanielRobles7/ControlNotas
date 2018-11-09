/*-----Triggers BD_notas-----*/


/*
**	Trigger "esc_new_grados": Este trigger genera los cursos (primero a noveno grado)
	de una escuela al ingresar una nueva escuela a la base de datos.
**	CONCAT(string1, string2) concatena el "grado" (string1) con "NEW.codigo_escuela"
	para generar el id del nivel (grado) donde "NEW.codigo_escuela" es el codigo de
	la escuela creada.
**	Para cada escuela se generaran 9 grados, siendo un total de 9 grados.
*/
DELIMITER \\
DROP TRIGGER IF EXISTS esc_new_grados \\
CREATE TRIGGER esc_new_grados AFTER INSERT ON escuelas FOR EACH ROW
BEGIN
INSERT INTO nivel VALUES (CONCAT('1° Grado - ', NEW.codigo_escuela), NEW.codigo_escuela, 'activo', NULL);
INSERT INTO nivel VALUES (CONCAT('2° Grado - ', NEW.codigo_escuela), NEW.codigo_escuela, 'activo', NULL);
INSERT INTO nivel VALUES (CONCAT('3° Grado - ', NEW.codigo_escuela), NEW.codigo_escuela, 'activo', NULL);
INSERT INTO nivel VALUES (CONCAT('4° Grado - ', NEW.codigo_escuela), NEW.codigo_escuela, 'activo', NULL);
INSERT INTO nivel VALUES (CONCAT('5° Grado - ', NEW.codigo_escuela), NEW.codigo_escuela, 'activo', NULL);
INSERT INTO nivel VALUES (CONCAT('6° Grado - ', NEW.codigo_escuela), NEW.codigo_escuela, 'activo', NULL);
INSERT INTO nivel VALUES (CONCAT('7° Grado - ', NEW.codigo_escuela), NEW.codigo_escuela, 'activo', NULL);
INSERT INTO nivel VALUES (CONCAT('8° Grado - ', NEW.codigo_escuela), NEW.codigo_escuela, 'activo', NULL);
INSERT INTO nivel VALUES (CONCAT('9° Grado - ', NEW.codigo_escuela), NEW.codigo_escuela, 'activo', NULL);
END \\
DELIMITER ;


/*
**	Trigger "niv_new_materia": Este trigger genera las materias basicas para cada grado
	(Ciencias, Lenguage, Matematicas, Sociales).
**	NEW.grado = nuevo grado generado.
**	SELECT YEAR(curdate()): consulta que devuelve el año actual, donde YEAR(2018-11-09)
	solo toma el año de una fecha y curdate() es una funcion que devuelve la fecha actual.
**	Para cada grado se generaran 4 materias, que por 9 grados creados por escuela
	generara un total de 36 materias por escuela.
*/
DELIMITER \\
DROP TRIGGER IF EXISTS niv_new_materia \\
CREATE TRIGGER niv_new_materia AFTER INSERT ON nivel FOR EACH ROW
BEGIN
INSERT INTO materias VALUES (CONCAT(NEW.grado, ' - Ciencias'), NEW.grado, 0, 0, 0, 0, 0, 0, (SELECT YEAR(curdate())), 'en curso', 'activo', NULL);
INSERT INTO materias VALUES (CONCAT(NEW.grado, ' - Lenguage'), NEW.grado, 0, 0, 0, 0, 0, 0, (SELECT YEAR(curdate())), 'en curso', 'activo', NULL);
INSERT INTO materias VALUES (CONCAT(NEW.grado, ' - Matematicas'), NEW.grado, 0, 0, 0, 0, 0, 0, (SELECT YEAR(curdate())), 'en curso', 'activo', NULL);
INSERT INTO materias VALUES (CONCAT(NEW.grado, ' - Sociales'), NEW.grado, 0, 0, 0, 0, 0, 0, (SELECT YEAR(curdate())), 'en curso', 'activo', NULL);
END \\
DELIMITER ;


/*
**	Trigger "alu_new_notas": Este trigger ganarara los registros de notas de cada alumno
	ingresado al registro (generado un registro de notas por materia, en este caso 4).
**	NEW.nie = NIE del alumno recien agregado al registro
*/
DELIMITER \\
DROP TRIGGER IF EXISTS alu_new_notas \\
CREATE TRIGGER alu_new_notas AFTER INSERT ON alumnos FOR EACH ROW
BEGIN
INSERT INTO notas VALUES (0, NEW.nie, CONCAT(NEW.grado, ' - Ciencias'), 0, 0, 0, 0, 0, 0, 0, 0, 0, 'por definir', 'activo', NULL);
INSERT INTO notas VALUES (0, NEW.nie, CONCAT(NEW.grado, ' - Lenguage'), 0, 0, 0, 0, 0, 0, 0, 0, 0, 'por definir', 'activo', NULL);
INSERT INTO notas VALUES (0, NEW.nie, CONCAT(NEW.grado, ' - Matematicas'), 0, 0, 0, 0, 0, 0, 0, 0, 0, 'por definir', 'activo', NULL);
INSERT INTO notas VALUES (0, NEW.nie, CONCAT(NEW.grado, ' - Sociales'), 0, 0, 0, 0, 0, 0, 0, 0, 0, 'por definir', 'activo', NULL);
END \\
DELIMITER ;


/*-----INSERT para probar tablas*/

/*
**	SET @randcod: Variable local.
**	SELECT (100000 + ROUND(RAND() * (999999-100000))) INTO @randcod;
		Consulta que inserta resultado en la variable local @randcod, donde RAND()
		genera un numero real aleatorio entre 0 y 1, y ROUND("numero real") redondea
		el numero real (convierte en entero de la cantidad de digitos ingresados)
		
*/
SET @randcod = NULL;
SELECT (100000 + ROUND(RAND() * (999999-100000))) INTO @randcod;
INSERT INTO acceso VALUES (0, CONCAT('DIR', @randcod), @randcod, 'director', 'activo', NULL);

SET @randcod = NULL;
SELECT (100000 + ROUND(RAND() * (999999-100000))) INTO @randcod;
INSERT INTO escuelas VALUES (@randcod, 'Centro Escolar la Ceiba', 'San Salvador', 'San Salvador', '2591-9567', 'ceceiba@edu.sv', '-89.20346900000004', '13.716102403875961', 'Ricardo Castillo', 1, 'activo', NULL);

SET @randcod = NULL;
SELECT (1000 + ROUND(RAND() * (9999-1000))) INTO @randcod;
INSERT INTO acceso VALUES (0, CONCAT('EST', @randcod), @randcod, 'estudiante', 'activo', NULL);

SET @randcod = NULL;
SELECT (10000000 + ROUND(RAND() * (99999999-10000000))) INTO @randcod;
INSERT INTO alumnos VALUES (@randcod, 'Juan', 'Perez', 'juanp78@gmail.com', 'Soyapango', 10, '2486-5328', '26/04/2008', (DATE_FORMAT(CURRENT_DATE, '%d/%m/%Y')), 2, '423356', '4° Grado - 423356', 'activo', NULL);