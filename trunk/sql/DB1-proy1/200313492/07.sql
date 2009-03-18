/**CONSULTA 7*/
/*
DAR LA LISTA DE LOS CATEDRATICOS PONCAHDORES QUE EN CADA CARRERA SE CARACTERIZAN POR TENER LA MAYOR CANTIDAD DE ALUMNOR REPROBADOS

Obtenemos  todos los catedraticos que tengan mayor numero de promedio de estudiantes reprobados por carrera usando vista REPROBADOS_POR_CAT_CAR
*/
SELECT CAT.CATEDRATICO,CAT.NOMBRE,CA1.CARRERA,CA1.NOMBRE,MAX(PROM_REP)
FROM CATEDRATICO CAT, CARRERA CA1, (
	SELECT R.CARR"RCARRERA",R.CAT"RCATED",AVG(NUM_REPROBADOS)"PROM_REP"
	FROM REPROBADOS_POR_CAT_CAR R
	GROUP BY R.CARR,R.CAT
	),CARRERA CAR
WHERE CA1.CARRERA = RCARRERA
AND RCATED = CAT.CATEDRATICO
GROUP BY CAT.CATEDRATICO,CAT.NOMBRE,CA1.CARRERA,CA1.NOMBRE
;


