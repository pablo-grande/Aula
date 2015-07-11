*--------------------------------------------------------------
* Program : TEST3
* Written by : Profesores de la asignatura
* Date : 15/03/2015
* Description: Ejecutar y comprobar el contenido de la memoria
* y los eregistros tras la ejecución.
*--------------------------------------------------------------
    ORG $1100
    
EPROG: DC.W $0615, $0810, $0214, $0417, $0820, $0416, $0617
       DC.W $0818, $0618, $0814, $0820, $0417, $0111, $0616
       DC.W $0818, $0617, $0001, $0616, $0818, $0617, $0C00
       DC.W $00FA, $0000, $0000, $0001
ER1: DC.W 0 ;eregistre R1 (buffer de memòria)
EIR: DC.W 0 ;eregistre d'instrucció
ER0: DC.W 0 ;eregistre R0 (acumulador)
ESR: DC.W 0 ;eregistre de flags (00000000 00000ZNC)
EPC: DC.W 0 ;ecomptador de programa

*~Font name~Courier New~
*~Font size~10~
*~Tab type~1~
*~Tab size~4~
