*-----------------------------------------------------------
* Title      : Práctica 3
* Written by : Pablo Riutort
* Date       : 29/3/2015
* Description: Selection sort sobre V; VIN = V invertido.
*-----------------------------------------------------------
        ORG    $1000
N:      EQU 6
V:      DC.B    5,3,8,10,1,4
VIN:    DS.B    N
        DS.W    0
         
START:                  ; first instruction of program

;INICIALIZACION
    ;bucle externo
    MOVE.B  #N,D0
    SUBQ.B  #2,D0

    ;vaciamos el registro para colocar el vector    
    LEA V,A0 
    ;índice interno de iteraciones
    MOVE.B  #1,D1
   
LOOP:
    MOVE.B  D0,D2 ;D2 contendrá el valor auxiliar del recorrido del vector
    MOVE.B  (A0)+,D3  ;D3 contendrá el valor que se está evaluando
    MOVE.B  D3,D5 ; D5 contendrá el valor mínimo (ahora D3)
LOOP2:
    ; recorrido del vector
    MOVE.B  (A0)+,D4
    EXT.W   D4
    EXT.W   D5
    CMP.B   D4,D5
    BLO NEXT
    
    MOVE.B  D4,D5 ; actualizamos el valor mínimo
    MOVE.B  #N,D6
    SUBQ.B  #1,D6
    SUB.B  D2,D6   ;D6 = indice del menor elemento
    
NEXT:
    DBRA    D2,LOOP2
    CMP.B   D3,D5
    ; si el actual era el mínimo, no haremos SWAP
    BEQ ACT
    
    ;SWAP
    ;intercambiamos los valores
    ; i = posición del valor mínimo
    ; j = posición del valor actual
    ; v[i] = valor mínimo
    ; v[j] = valor que se está evaluando
    LEA V,A0
    MOVE.B  (A0,D6),D7 ;v[i]
    MOVE.B  D1,D5
    SUBQ.B  #1,D5   ;j
    MOVE.B  (A0,D5),(A0,D6) V[i] = V[j]
    MOVE.B  D7,(A0,D5) ;actualizamos el valor actual
    
ACT:
    ;ACTUALIZACION
    ; pasamos al siguiente valor del vector
    LEA V,A0
    ADD.L D1,A0
    ADDQ.B  #1,D1
    CLR.W   D2
    
    DBRA    D0,LOOP
    
;Calculo de VIN
    
    CLR.W D0
    MOVE.B  #N,D0
    SUBQ.B  #1,D0
    
    LEA VIN,A1
    ADDQ.L  #1,A0
    
FINISH:
    ; dejamos en VIN los valores de V en
    ; orden inverso
    MOVE.B  -(A0),(A1)+
    DBRA D0,FINISH
    
* Put program code here

    SIMHALT             ; halt simulator

    END    START        ; last line of source
*~Font name~Courier New~
*~Font size~10~
*~Tab type~1~
*~Tab size~4~
