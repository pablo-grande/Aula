;Pablo Riutort Grande
;Axel Victor Aliaga Batanero

;retorna veritat si conjunt és una llista sense elements repetits.
(defun es-conjunt(c)
	(cond	((null c) t)
		((equal (car c) (car(cdr c))) nil)
		(t (es-conjunt (cdr c)))))


;converteix una llista d’elements en un conjunt, eliminant tots els elements repetits.
(defun fer-conjunt(l)
	(cond	((null l) nil)
		((equal (car l)(car(cdr l))) (cons(car(cdr l))(fer-conjunt (cdr (cdr l)))))
		(t (cons (car l)(fer-conjunt(cdr l))))))

;retorna un nou conjunt que és la unió dels elements del conjunt1 i del conjunt2 
;els elements que apareixen als dos conjunts únicament han d’aparèixer una vegada dins el conjunt unió.
(defun unio(c1 c2)
	(cond	((null c1) c2)
		((null c2) c1)
		(t	(cons(car c1)(unio(cdr c1)c2)))))

;retorna un nou conjunt resultat de fer la intersecció entre el conjunt1 i el conjunt2.
(defun interseccio(c1 c2)
	(cond	((null c1) nil)
		((null c2) nil)
		((eql	(car c1)(car c2))	(cons (car c1)(interseccio(cdr c1) c2)))
		(t	(interseccio c1(cdr c2)))))

;retorna un nou conjunt que és la diferència entre el primer i el segon. 
;Recordau que la diferència de dos conjunts A i B es defineix com els elements de A que no pertanyen a B.
(defun diferencia(c1 c2)
	(cond	((null c1) nil)
		((null c2) c1)
		((eql	(member(car c1) c2) nil)	(cons(car c1)(diferencia(cdr c1)c2)))
		(t	(diferencia(cdr c1)(cdr c2)))))

;retorna un nou conjunt amb la diferència simètrica entre els dos conjunts. Recordau que la
;diferència simètrica de dos conjunts A i B és la unió de la diferència A-B i de la diferència B-A.
(defun diferencia-simetrica(c1 c2)
	(cond	((null c1) nil)
		((null c2) nil)
		(t (unio(diferencia c1 c2)(diferencia c2 c1)))))

;retorna un nou conjunt amb totes les parelles ordenades (a,b) on a és un element de A i b és un
;element de B.
(defun producte-cartesia (a b)
        (cond ((null a) nil)
                        (t (append (escalar (car a) b) (producte-cartesia (cdr a) b)))))

(defun escalar (a b)
        (cond ((null (cdr b)) (cons (list a (car b)) nil))
                (t (cons (list a (car b)) (escalar a (cdr b))))))


;que retorna el número d’elements d’un conjunt
(defun cardinal(c)
	(cond 	((null c) 0)
		(t	(+ 1 (cardinal(cdr c))))))


