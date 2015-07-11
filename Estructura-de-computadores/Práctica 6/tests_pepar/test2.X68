*--------------------------------------------------------------
* Program : TEST2
* Written by : Profesores de la asignatura
* Date : 14/03/2015
* Description: Ejecutar comprobando que todos los Eregistros
* y todas las Eposiciones de memoria toman
* el valor correcto al final de cada Einstrucción.
*--------------------------------------------------------------
    ORG $1100
    
EPROG: DC.W $060A, $0818, $060B, $0814, $0207, $040C, $0C00
       DC.W $0820, $040C, $0C00, $0001, $0002, $0000
ER1: DC.W 0 ;eregistre R1 (buffer de memòria)
EIR: DC.W 0 ;eregistre d'instrucció
ER0: DC.W 0 ;eregistre R0 (acumulador)
ESR: DC.W 0 ;eregistre de flags (00000000 00000ZNC)
EPC: DC.W 0 ;ecomptador de programa

*~Font name~Courier New~
*~Font size~10~
*~Tab type~1~
*~Tab size~4~
