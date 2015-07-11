*------------------------------------------------------------
* Title      : Problema 1
* Written by : Profesores de la asignatura
* Date       : 07/03/2014
* Description: Contar el número de elementos positivos y
*              el número de elementos negativos de un vector
*------------------------------------------------------------
    ORG    $1000

    N:     EQU 5
    V:     DC.B 2,-3,-10,8,0
    NELMP: DC.B 0
    NELMN: DC.B 0
    DS.W 0

START:

    MOVE.B  #N,D0
    SUBQ.B  #1,D0
    
    LEA.L   V,A0
    
LOOP:
    MOVE.B  (A0)+,D1
    BPL POS
    ADDQ.B  #1,NELMN
    MOVE.B  NELMN,D3

NEXT:
    DBRA D0,LOOP

    SIMHALT

POS:
    ADDQ.B  #1,NELMP
    MOVE.B  NELMP,D2
    BRA NEXT

    END    START



*~Font name~Courier New~
*~Font size~10~
*~Tab type~1~
*~Tab size~4~
