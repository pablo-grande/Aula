*------------------------------------------------------------
* Title      : Problema 3
* Written by : Profesores de la asignatura
* Date       : 07/03/2014
* Description: Contar el número de elementos de un vector
*              cuyo valor absoluto supere un cierto valor T
*------------------------------------------------------------
    ORG    $1000

    N:    EQU 5
    V:    DC.B -20,-110,80,100,104
    T:    EQU 100
    NELM: DC.B 0
    DS.W 0

START:
    MOVE.B  #N,D0
    SUBQ.B  #1,D0
    
    LEA.L   V,A0
    
LOOP:
    MOVE.B  (A0)+,D1
    EXT.W   D1
    BPL ABS
    NEG.W   D1
ABS:
    CMPI  #T,D1
    BLE NEXT
    ADDQ.B  #1,NELM
    
NEXT:
    DBRA.W D0,LOOP

    SIMHALT

    END    START




*~Font name~Courier New~
*~Font size~10~
*~Tab type~1~
*~Tab size~4~
