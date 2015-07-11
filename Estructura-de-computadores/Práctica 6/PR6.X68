*-----------------------------------------------------------
* Title      : Práctica 4
* Written by : Pablo Riutort
* Date       : 1/4/15
* Description: Fetch
*-----------------------------------------------------------
    ORG    $1000
    
EPROG:  DC.W    $060A, $0818, $060B, $0814, $0207, $040C, $0C00
                DC.W    $0820,  $040C, $0C00, $0001, $0002, $0000
                
EIR:        DC.W    0   ;eregistro de instrucción
EPC:        DC.W    0   ;econtador de programa
ER0:        DC.W    0   ;eregistro R0 (acumulador)
ER1         DC.W    0   ;eregistro R1 (buffer de memoria)
ESR:        DC.W    0   ;eregistro de flags (00000000 00000ZNC) 

N   EQU 10                
CODE:   DS.W    N

START:                  ; first instruction of program

* Put program code here

    CLR.W   EPC
    LEA CODE,A1
    MOVE.W #N,D0
    SUBQ.W #1,D0
    
FETCH:
    LEA.L EPROG,A0    
    MOVE.W  EPC,D1
    ASL.W   #1,D1   ;multiplicamos el registro EPC por 2 (nos movemos words)
    ADD.W   D1,A0 ; con esto sabremos cual es la siguiente instrucción
    
    MOVE.W  (A0),EIR ; EIR ahora contiene la siguiente instrucción a ejecutar
    
    SUBQ.L  #2,A7 ;Reserva de espacio para variable local
    MOVE.W  EIR,-(A7) ;pasamos el registro EIR a la pila
    JSR DESCO
    ADDQ.L  #2,A7 ;restauramos la pila
    MOVE.W  (A7)+,D3
    
    ;Nos preparamos para la ejecución
    CLR.W   D4 ;registro auxiliar usado próximamente
    MULU    #6,D3
    MOVEA.L D3,A2
    JMP JMPLIST(A2)
    
UPEPC:
    ADDQ.W  #1,EPC
    DBRA D0,FETCH
    
    BRA EHALT

    
DESCO:
    MOVE.L  D2,-(A7) ;guardamos el registro d2

    ;MOVE.W  EIR,D2
    MOVE.W  8(A7),D2
    BTST    #11,D2
    BNE PRIMERUNO

    BTST    #10,D2
    BNE STOREOLOAD
    BTST    #9,D2
    BNE JMN
    BTST    #8,D2
    BNE JMZ
    ;sino, se trata de la instrucción jmi
    MOVE.W  #0,10(A7)
    BRA END
    
PRIMERUNO:
    BTST #10,D2
    BNE HALT
    ;pasamos los dont care (X)
    BTST #5,D2
    BNE R0R1
    BTST    #4,D2
    BNE NOCMP
    ;es un cmp
    MOVE.W  #5,10(A7)
    BRA END
    
STOREOLOAD:
    BTST    #9,D2
    BNE LOAD
    ;es un store
    MOVE.W  #3,10(A7)
    BRA END
    
NOCMP:
    BTST    #3,D2
    BNE R1R0
    BTST    #2,D2
    BNE SUB
    ;es un add
    MOVE.W  #6,10(A7)
    BRA END
    
SUB:
    ;es un sub
    MOVE.W  #7,10(A7)
    BRA END
    
R1R0:
    ;es un r1r0
    MOVE.W  #8,10(A7)
    BRA END
    
R0R1:
    ;es un r0r1
    MOVE.W  #9,10(A7)
    BRA END
    
JMN:
    ;es un jmn
    MOVE.W  #2,10(A7)
    BRA END 
    
JMZ:
    ;es un jmz
    MOVE.W  #1,10(A7)
    BRA END
    
LOAD:
    ;es un load
    MOVE.W  #4,10(A7)
    BRA END

HALT:
    ;es un halt
    MOVE.W  #10,10(A7)
    BRA END
    
END:
    MOVE.L  (A7)+,D2
    RTS

;Subrutina de Flags
;obtendremos los flags mirando el resultado del word
FLAGS:
    MOVE.L  D4,-(A7)
    MOVE.W  ESR,D4 ;Registro auxiliar para los flags
    
    BTST #12, D5
    BEQ NEG
    BSET #0,D4 ;actualizamos el flag c
NEG:
    BTST  #11, D5
    BEQ ZERO
    BSET #1,D4 ;actualizamos el flag n

ZERO:
    ;Comprobamos el flag z
    BTST #0, D5
    BNE CLEAR ;Si está a 1 el flag z no debe ser actualizado
    BTST  #1, D5
    BNE CLEAR
    BTST  #1, D5
    BNE CLEAR
    BTST  #2, D5
    BNE CLEAR
    BTST  #3, D5
    BNE CLEAR
    BTST  #4, D5
    BNE CLEAR
    BTST  #5, D5
    BNE CLEAR
    BTST  #6, D5
    BNE CLEAR
    BTST  #7, D5
    BNE CLEAR
    BTST  #8, D5
    BNE CLEAR
    BTST  #9, D5
    BNE CLEAR
    BTST  #10, D5
    BNE CLEAR
    BSET #2,D4 ;Actualizamos el flag z
    
CLEAR:
    MOVE.W D4,ESR
    MOVE.L  (A7)+,D4
    
    RTS
    
TRUNCATE:
;Preparamos los registros para el formato de la PEPA
    BCLR #15, D5
    BCLR #14, D5
    BCLR #13, D5
    BCLR #12, D5
    
    BCLR #15, D4
    BCLR #14, D4
    BCLR #13, D4
    BCLR #12, D4
    RTS
    

JMPLIST:
    JMP EJMI
    JMP EJMZ
    JMP EJMN
    JMP ESTORE
    JMP ELOAD
    JMP ECMP
    JMP EADD
    JMP ESUB
    JMP ER1R0
    JMP ER0R1
    JMP EHALT
    
EJMI:
    MOVE.W  EIR,D4
    AND #$00FF, D4
    MOVE.W  D4, EPC
    DBRA D0,FETCH ;No debemos actualizar el EPC

;Para las siguientes instrucciones (EJMZ, EJMN y EJMC), miramos el valor del flag que nos interesa
;dependiendo del resultado, ejecutaremos un salto incondicional (EJMI).    
EJMZ:
    MOVE.W  ESR,D4
    BTST    #2,D4   ;Si Z=1 entonces, JMI
    BNE EJMI
    JMP UPEPC
    
EJMN:
    MOVE.W  ESR,D4
    BTST    #1,D4 ;Si N=1 entonces, JMI
    BNE EJMI
    JMP UPEPC
    
EJMC:
    MOVE.W  ESR,D4
    BTST    #0,D4
    BNE EJMI
    JMP UPEPC
    
ESTORE:
    MOVE.W  EIR, D4
    AND #$00FF, D4
    MOVE.W  D4, A3
    MOVE.W  (ER1), A3
    JMP UPEPC
    
ELOAD:
    MOVE.W  EIR,D4
    AND #$00FF, D4
    ASL.W   #1,D4
    MOVEA.L  D4, A3
    MOVE.W  EPROG(A3), ER1
    JMP UPEPC
    
ECMP:
    LEA ER0,A3
    LEA ER1,A4
    MOVE.W  (A3),D4
    MOVE.W  (A4),D5
    NEG.W   D5
    JSR TRUNCATE
    ADD.W   D4,D5
    ;actualizar los flags
    JSR FLAGS
    JMP UPEPC
    
EADD:
    LEA ER0,A3
    LEA ER1,A4
    MOVE.W  (A3),D4
    MOVE.W  (A4),D5
    JSR TRUNCATE
    ADD.W   D4,D5
    JSR FLAGS
    MOVE.W  D5,ER0
    JMP UPEPC
    
ESUB:
    ; A-B = A + (¬B) + 1 -> Esto lo que tiene que hacerse (PEPA)
    LEA ER0,A3
    LEA ER1,A4
    MOVE.W  (A3),D4
    MOVE.W  (A4),D5
    NEG.W   D5
    JSR TRUNCATE
    ADD.W   D4,D5
    JSR FLAGS
    MOVE.W  D5,ER0
    JMP UPEPC
    
ER0R1:
    MOVE.W (ER0), ER1
    JMP UPEPC
    
ER1R0:
    MOVE.W  (ER1), ER0
    JMP UPEPC
    
EHALT:
    SIMHALT
    
    END START











*~Font name~Courier New~
*~Font size~10~
*~Tab type~1~
*~Tab size~4~
