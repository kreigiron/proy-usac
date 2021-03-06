;Declaracion del segmento de pila
PILA SEGMENT STACK
DB 256 DUP(0)
PILA ENDS

ASSUME CS:CODIGO,DS:CODIGO ;REGISTROS PARA DEFINIR BLOQUES DE DECLARACION DE VAR Y DE CODIGO

;**************************DECLARACION DE VARIABLES

CODIGO SEGMENT
	MENSAJE DW 0
	IZQ DB ' HAS PRESIONADO IZQUIERDA','$'
	TIT DB 'INICIANDO PROGRAMA','$'
	ARR DB ' HAS PRESIONADO ARRIBA','$'
	DER DB ' HAS PRESIONADO DERECHA','$'
	ADI DB ' ********************SALIDA**********************','$'
	BANDERA DW 0
	REGISTRO DW 0

;**************************SEGMENTO DE CODIGO


MAIN PROC FAR	; CODIGO PRINCIPAL
	MOV AX,CS
	MOV DS,AX
	CALL INICIASER
	MOV MENSAJE,OFFSET TIT
	CALL ESCRIBIR


	SALTO:
	MOV AH,1
	MOV DL,0FFH
	INT 21H
	;CMP AL,13
	;JE  SERIALMAN
	;CMP AL,27
	;JE  SERIALREC
	;80 ES PARA ABAJO
	CMP AL,77	;COMPARA SI ES DERECHA
	JE ESCRITURA3
	CMP AL,72	;COMPARA SI ES TECLA ARRIBA
	JE ESCRITURA2
	CMP AL,75	;COMPARA SI ES TECLA IZQUIERDA
	JE ESCRITURA
	CMP AL,27	;COMPARA SI SALE
	JE FINAL
	
	JMP SALTO


;***********************************************FLECHAS*********************************************************
MAIN ENDP
ESCRITURA PROC NEAR
	MOV MENSAJE,OFFSET IZQ
	CALL ESCRIBIR
	CALL SERIALMANIZQ
	JMP SALTO
ESCRITURA ENDP
ESCRITURA2 PROC NEAR
	MOV MENSAJE,OFFSET ARR
	CALL ESCRIBIR
	CALL SERIALMANARR
	JMP SALTO
ESCRITURA2 ENDP
ESCRITURA3 PROC NEAR
	MOV MENSAJE,OFFSET DER
	CALL ESCRIBIR
	CALL SERIALMANDER
	JMP SALTO
ESCRITURA3 ENDP

FINAL PROC NEAR
	MOV MENSAJE,OFFSET ADI
	CALL ESCRIBIR
	JMP ADIOS
FINAL ENDP

;*************************************************PUERTO SERIAL**************************************************


;**************************RUTINA PARA INICIALIZAR EL SERIAL
INICIASER PROC NEAR
	MOV SP,PILA
	MOV DX,0;ASIGNAR EL PUERTO COM
	MOV AL,0E3H
	MOV AH,0
	INT 14H
	JMP SALTO
INICIASER ENDP
;**************************RUTINA PARA ESCRIBIR EN EL SERIAL
SERIALMANIZQ PROC NEAR 
	MOV DX,0;ELIGE PUERTO COM1
	MOV AH,1;ASIGNA FUNCION DE TRANSMITIR DATOS EN AH
	MOV AL,01
	INT 14H
SERIALMANIZQ ENDP

SERIALMANDER PROC NEAR 
	MOV DX,0;ELIGE PUERTO COM1
	MOV AH,1;ASIGNA FUNCION DE TRANSMITIR DATOS EN AH
	MOV AL,10
	INT 14H
SERIALMANDER ENDP

SERIALMANARR PROC NEAR 
	MOV DX,0;ELIGE PUERTO COM1
	MOV AH,1;ASIGNA FUNCION DE TRANSMITIR DATOS EN AH
	MOV AL,11
	INT 14H
SERIALMANARR ENDP

;**************************RUTINA PARA LEER EN EL SERIAL
SERIALREC PROC NEAR
	MOV DX,0;ELIGE PUERTO COM1
	MOV AH,2;ASIGNA FUNCION DE RECIBIR DATOS EN AH
	MOV AL,0002
	INT 14H
	JMP SALTO
SERIALREC ENDP

;***************************************************ESCRIBIR******************************************************
ESCRIBIR PROC NEAR
	PUSH AX
	PUSH DX
	MOV AH,09H
	MOV DX,MENSAJE
	INT 21H
	MOV AH,06
	MOV DL,0DH
	INT 21H
	MOV AH,06H
	MOV DL,0AH
	INT 21H
	POP DX
	POP AX
	RET
ESCRIBIR ENDP

;**************************************************TECLADO*********************************************************


	ADIOS:
	MOV DX,0;ELIGE PUERTO COM1
	MOV AH,1;ASIGNA FUNCION DE TRANSMITIR DATOS EN AH
	MOV AL,00
	INT 14H

	MOV AH,06
	MOV DL,0DH
	INT 21H
	MOV AH,06H
	MOV DL,0AH
	INT 21H
	
	MOV AH,4CH
	INT 21H
CODIGO ENDS
END MAIN

