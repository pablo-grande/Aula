*------------------------------------------------------------
* Title      : Problema 2
* Written by : Profesores de la asignatura
* Date       : 07/03/2014
* Description: Calcular el valor absoluto de un número
*------------------------------------------------------------
    ORG    $1000

    X:    DC.B -128
    DS.W 0
    ABSX: DS.W 1

START:
   MOVE.B   X,D0
   EXT.W    D0
   BPL DONTH
   NEG.W    D0
   
DONTH:
    MOVE.B  D0,ABSX
    MOVE.B  ABSX,D1
    
        SIMHALT

    END    START



*~Font name~Courier New~
*~Font size~10~
*~Tab type~1~
*~Tab size~4~
