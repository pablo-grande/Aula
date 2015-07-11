*-----------------------------------------------------------
* Program : TEST1
* Written by : Profesores de la asignatura
* Date : 14/03/2015
* Description: Comprueba si la subrutina DESCO cumple
* con las especificaciones.
*-----------------------------------------------------------
    ORG $1100
    
N: EQU 11
ECOD:  DC.W $043D,$0155,$0C00,$00AA,$0818
       DC.W $02FF,$0804,$06E1,$0820,$0814,$0810
NUMCO: DS.W N
RINS:  DS.W 1
CPRO:  DS.W 1

START:
    CLR.W CPRO
    MOVE.W #N,D0
    SUBQ.W #1,D0
    
    LOOP:
        MOVE.W CPRO,D5
        ASL.W #1,D5
        MOVE.W D5,A3
        MOVE.W ECOD(A3),RINS
        ADDQ.W #1,CPRO
        
        SUBQ.L #2,SP
        MOVE.W RINS,-(SP)
        
        JSR DESCO
        
        ADDQ.L #2,SP
        MOVE.W (SP)+,NUMCO(A3)
        
    DBRA D0,LOOP

    MOVE.B #9,D0
    TRAP #15
    
DESCO:
    ; Colocar aquí el código de vuestra subrutina!
    
    END START



*~Font name~Courier New~
*~Font size~10~
*~Tab type~1~
*~Tab size~4~
