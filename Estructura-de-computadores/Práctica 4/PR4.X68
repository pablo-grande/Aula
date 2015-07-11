*-----------------------------------------------------------
* Title      : Práctica 4
* Written by : Pablo Riutort
* Date       : 1/4/15
* Description: Fetch
*-----------------------------------------------------------
    ORG    $1000
    
EPROG:  DC.W    $060A, $0818, $060B, $0814, $0207, $040C, $0C00
                DC.W    $0820,  $040C, $0C00, $0001, $0002, $0000
                
CODE:   DC.W    0
                
EIR:        DC.W    0   ;eregistro de instrucción
EPC:        DC.W    0   ;econtador de programa
ER0:        DC.W    0   ;eregistro R0 (acumulador)
ER1         DC.W    0   ;eregistro R1 (buffer de memoria)
ESR:        DC.W    0   ;eregistro de flags (00000000 00000ZNC)

N   EQU     10  ;Número de instrucciones a codificar

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

;DECODE
    MOVE.W  EIR,D2
    BTST    #11,D2
    BNE PRIMERUNO

    BTST    #10,D2
    BNE STOREOLOAD
    BTST    #9,D2
    BNE JMN
    BTST    #8,D2
    BNE JMZ
    ;sino, se trata de la instrucción jmi
    MOVE.W  #0,(A1)+
    BRA NEXT
    
PRIMERUNO:
    BTST #10,D2
    BNE HALT
    ;pasamos los dont care (X)
    BTST #5,D2
    BNE R0R1
    BTST    #4,D2
    BNE NOCMP
    ;es un cmp
    MOVE.W  #5,(A1)+
    BRA NEXT
    
STOREOLOAD:
    BTST    #9,D2
    BNE LOAD
    ;es un store
    MOVE.W  #3,(A1)+
    BRA NEXT
    
NOCMP:
    BTST    #3,D2
    BNE R1R0
    BTST    #2,D2
    BNE SUB
    ;es un add
    MOVE.W  #6,(A1)+
    
SUB:
    ;es un sub
    MOVE.W  #7,(A1)+
    BRA NEXT
    
R1R0:
    ;es un r1r0
    MOVE.W  #8,(A1)+
    BRA NEXT
    
R0R1:
    ;es un r0r1
    MOVE.W  #9,(A1)+
    BRA NEXT
    
JMN:
    ;es un jmn
    MOVE.W  #2,(A1)+
    BRA NEXT
    
JMZ:
    ;es un jmz
    MOVE.W  #1,(A1)+
    BRA NEXT
    
LOAD:
    ;es un load
    MOVE.W  #4,(A1)+
    BRA NEXT

HALT:
    ;es un halt
    MOVE.W  #10,(A1)+
    BRA NEXT


NEXT:
    ADDQ.W  #1,EPC
    DBRA.W  D0,FETCH

    SIMHALT             ; halt simulator

    END    START        ; last line of source
*~Font name~Courier New~
*~Font size~10~
*~Tab type~1~
*~Tab size~4~
