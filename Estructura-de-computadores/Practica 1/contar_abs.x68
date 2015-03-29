*-----------------------------------------------------------
* Title      : Práctica 1
* Written by : Pablo Riutort Grande
* Date       : 7/3/2015
* Description: El programa debe contar el número total de elementos
*               de un vector cuyo valor absoluto sea
*                mayor o igual a T1 y menor o igual a T2 
*               C = T1 =< V[x] =< T2                             
*-----------------------------------------------------------
    ORG    $1000
    N: EQU 7
    V: DC.B -10,120,8,70,0,-99,-106
    C: DC.B 0
    T1: EQU 8
    T2: EQU 99
    
START:                  ; first instruction of program

    MOVE.B  #N,D0
    SUBQ.B  #1,D0
    
    LEA.L   V,A0
    
LOOP:
    MOVE.B  (A0)+,D1
    EXT.W   D1
    BPL ABS
    NEG D1
    
ABS:
    CMPI #T1,D1
    BLO NOT
    CMPI #T2,D1
    BHI NOT
    ADDQ.B  #1,C
    MOVE.B  C,D2
    
NOT:
    DBRA D0,LOOP
    

    SIMHALT             ; halt simulator

* Put variables and constants here

    END    START        ; last line of source


*~Font name~Courier New~
*~Font size~10~
*~Tab type~1~
*~Tab size~4~
