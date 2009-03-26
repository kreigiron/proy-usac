/**CONSULTA 4*/
/*
DAR EL NOMBRE DE LOS ESTUDIANTES QUE HAN LLEVADO ALGUN CURSO QUE HA SIDO IMPARTIDO POR ALGUNO DE LOS CATEDRATICOSQUE ALGUNA VEZ LE HAN DADO CLASE A ALGUNO DE LOS ESTUDIANTES QUE GANO ALGUN CURSO CON ALGUNO DE LOS CATEDRATICOS QUE HAN IMPARTIDO AL MENOS UNA VEZ EL CURSO DE BASE DE DATOS A ALGUNO DE LO LOS ESTUDIANTES QUE NO HAN GANADO EL CURSO DE SISTEMAS OPERATIVOS PERO SI LO HAN LLEVADO AL MENOS UNA VEZ

Obtenemos estudiante tal que tenga un curso asingado que exista en la seccion dado el mismo anio y ciclo de asignacion y tal que el catedratico que dio el curso tal que existan dos secciones una de base de datos y otra de SO de la misma carrera que el estudiante y que esten aprobadas

*/
SELECT E1.CARNET, E1.PRIMER_NOMBRE || ' ' || E1.PRIMER_APELLIDO
FROM ESTUDIANTE E1
WHERE EXISTS(
	SELECT 1
	FROM CURSO CU1
	WHERE EXISTS(
		SELECT 1
		FROM ASIGNACION AS1
		WHERE AS1.CARNET = E1.CARNET
		AND AS1.CODIGO = CU1.CURSO
		AND EXISTS(
			SELECT 1
			FROM SECCION SE1
			WHERE SE1.CODIGO = AS1.CODIGO
			AND AS1.ANIO = SE1.ANIO
			AND AS1.CICLO = SE1.CICLO
			AND EXISTS(
				SELECT 1
				FROM CATEDRATICO CAT1
				WHERE SE1.CATEDRATICO = CAT1.CATEDRATICO
				AND EXISTS(
					SELECT 1
					FROM ASIGNACION A2, ASIGNACION A3, PLAN PL1, CARRERA CA1, APROBACION AP1
					WHERE A2.CODIGO = (
						SELECT CU1.CURSO FROM CURSO CU2 WHERE CU2.NOMBRE = '%BASES DE DATOS%'
					)
					AND A3.CODIGO = (
						SELECT CU1.CURSO FROM CURSO CU2 WHERE CU2.NOMBRE = '%SISTEMAS OPERATIVOS%'
					)
					AND A3.CARNET IN (
						SELECT E3.CARNET
						FROM ESTUDIANTE E3
						WHERE E3.CARNET = A3.CARNET
					)
					AND PL1.CARRERA = E1.CARRERA
					AND CA1.CARRERA = E1.CARRERA
					AND ((PL1.ANIO_INICIO = A3.ANIO AND PL1.CICLO_INICIO <= A3.CICLO)
						OR (PL1.ANIO_FIN = A3.ANIO AND PL1.CICLO_FIN >= A3.CICLO)
						OR (PL1.ANIO_INICIO < A3.ANIO AND PL1.ANIO_FIN > A3.ANIO)
					)
					AND AP1.PLAN = PL1.PLAN
					AND AP1.CARRERA = PL1.CARRERA
					AND AP1.CICLO = A3.CICLO
					AND A3.NOTA >= AP1.NOTA_APROBACION
					AND A3.ZONA >= AP1.ZONA_MINIMA
				)
			)
		)		
	)
);
