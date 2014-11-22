Llistes Escolars
===

Projecte que gestiona els cursos, assignatures i alumnes d'una suposada escola mitjançant llistes linkades.

##Nodes
Un node conté una dada (curs, assignatura o alumne) i una referència al següent node de la llista.

##Llistes
---
- Llista de Cursos: Una llista que gestiona els nodes de cursos.
- Llista d'Assignatures: Una llista que gestiona els nodes d'assignatures.
- Llista d'Alumnes: Una llista que gestiona els nodes d'alumnes.

##Llistes de referència
---
- Llista de Referència d'Assignatures: Cada alumne conté aquesta llista, que diu de quines assignatures està matriculat aquest alumne.
- Llista de Referència d'Alumnes: Cada assignatura conté aquesta llista, que diu quins alumnes estàn matriculats a aquesta assignatura. 

##Referència
Una referència conté dues dades (Alumne i Assignatura) i una referència a la següent referència de l'alumne o assignatura.

##Curs
Conté una llista d'Assignatures i mètodes que retornen l'informació del curs.

##Assignatura
Conté una llista de Referència d'Alumnes i mètodes que retornen informació de l'assignatura.

##Alumnes
Conté una llista de Referència d'Assignatures i mètodes que retornen informació de l'alumne.

##Gestor
Mètodes i altres utilitats per a gestionar les classes anteriors i simular el funcionament d'una escola.


