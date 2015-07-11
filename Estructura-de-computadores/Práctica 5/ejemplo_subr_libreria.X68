*-----------------------------------------------------------
* Title      : Ejemplo de subrutina de libreria.
* Written by : A. Ortiz
* Date       : 22/04/2013
* Description: Se usa la pila para el
*              paso de parametros. 
*              Se preserva el valor de
*              los registros modificados por la subrutina.
*              La subrutina define una variable local.
*-----------------------------------------------------------
    ORG    $1000
N   EQU 4
V   DC.W 4,-7,-5,1
S   DS.W 1
START:                  ; first instruction of program

    MOVE.W #N,-(A7)
    LEA V,A0
    MOVE.L A0,-(A7)
    JSR SUMAVEC
    ADDQ.L #4,A7
    MOVE.W (A7)+,S

    SIMHALT             ; halt simulator
    
SUMAVEC:
    MOVE.L A0,-(A7)
    MOVE.L D0,-(A7)
    MOVE.L D1,-(A7)
    
    SUBQ.L #2,A7        ; reserve space for local variable S

    MOVE.L 18(A7),A0    ; @V
    MOVE.W 22(A7),D0    ; N
    SUBQ.W #1,D0
    CLR.W (A7)
    LOOP:
    MOVE.W (A0)+,D1
    ADD.W D1,(A7)
    DBRA D0,LOOP
    MOVE.W (A7),22(A7)  ; place result in 'N' place
    
    ADDQ.L #2,A7        ; release space of local variable S
    
    MOVE.L (A7)+,D1
    MOVE.L (A7)+,D0
    MOVE.L (A7)+,A0
    RTS

    END    START        ; last line of source

*~Font name~Courier New~
*~Font size~10~
*~Tab type~1~
*~Tab size~4~
