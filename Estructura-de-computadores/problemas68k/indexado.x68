*-----------------------------------------------------------
* Title      : Ejemplo de uso del indexado
* Written by : Pablo Riutort Grande
* Date       : 15/3/15
* Description: Ejemplo del uso del indexado en 68k.
*                   La ejecucion del programa recorre las posiciones del vector.
*                   Para ver el correcto funcionamiento hay que ejecutar paso a paso
*                   el programa y observar el registro D1.
*-----------------------------------------------------------
    ORG    $1000
    
N:      EQU 6
V:      DC.B    5,3,8,10,1,4
VIN:   DS.B    N 

START:                  ; first instruction of program

    MOVE.B  #N, D0 ;Inicializamos el proceso, numero de veces a recorrer el vector.
    SUBQ.B  #1, D0
    
    MOVEA.L #0,A0 ;esto inicializa el registro de memoria sobre el cual nos moveremos con el vector.
    
LOOP:
    MOVE.B  V(A0),D1 ;La primera vez sera V[0]
    ADDQ.L  #1,A0 ; si añadimos un 1, entonces la proxima iteracion sera V[1]
    DBRA D0,LOOP ;y asi sucesivamente.

* Put program code here

    SIMHALT             ; halt simulator

* Put variables and constants here

    END    START        ; last line of source

*~Font name~Courier New~
*~Font size~10~
*~Tab type~1~
*~Tab size~4~
