*-----------------------------------------------------------
* Title      : Práctica 5
* Written by : Pablo Riutort
* Date       : 1/4/15
* Description: Fetch, decodificación y ejecución
*-----------------------------------------------------------
    ORG    $1000
    
EPROG:  DC.W    $060A, $0818, $060B, $0814, $0207, $040C, $0C00
                DC.W    $0820,  $040C, $0C00, $0001, $0002, $0000
                
N   EQU 10
                
CODE:   DS.W    N
                
EIR:        DC.W    0   ;eregistro de instrucción
EPC:        DC.W    0   ;econtador de programa
ER0:        DC.W    0   ;eregistro R0 (acumulador)
ER1         DC.W    0   ;eregistro R1 (buffer de memoria)
ESR:        DC.W    0   ;eregistro de flags (00000000 00000ZNC)

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
    MOVE.W  (A7)+,(A1)+
    
    ADDQ.W  #1,EPC
    DBRA D0,FETCH
    
    BRA FINAL
    
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
    
FINAL:
    SIMHALT
    
    END START



*~Font name~Courier New~
*~Font size~10~
*~Tab type~1~
*~Tab size~4~
