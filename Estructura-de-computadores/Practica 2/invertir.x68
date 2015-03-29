*-----------------------------------------------------------
* Title      : Práctica 2
* Written by : Pablo Riutort Grande
* Date       : 7/3/2015
* Description: V2 debe contener los mismos valores que V1 en
*               orden invertido y valor absoluto.No se puede usar NEG.
*               Acceso a V1 por predecremento. Acceso a V2 indexado.
*-----------------------------------------------------------
    ORG    $1000
    N: EQU 5
*    V1: DC.W -10,-15,-100,89,-1
    V1: DC.W    1,2,3,4,5
    V2: DS.W N
    
START:                  ; first instruction of program
    MOVE.B  #N,D0
    SUBQ.B  #1,D0
    
    LEA.L   V1,A0
    ADD.W   #10,A0  ;tienes que sumar el valor 2*N al registro A0    
    MOVEA.L #0,A1
    
LOOP:
    MOVE.W  -(A0),D2
    EXT.W   D2
    BPL ABS
    SUB.W #0,D2

ABS:
    MOVE.W  D2,V2(A1)
    ADDQ.L  #1,A1
    
    DBRA D0,LOOP

    SIMHALT             ; halt simulator

* Put variables and constants here

    END    START        ; last line of source




*~Font name~Courier New~
*~Font size~10~
*~Tab type~1~
*~Tab size~4~
