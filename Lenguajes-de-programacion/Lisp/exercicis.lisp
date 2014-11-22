;afegirenar dues llistes l1 y l2 en una llista nova
(defun afegir(l1 l2)
	(cond	((null l1)	l2)
	(t	(cons(car l1)(afegir (cdr l1) l2)))))

;borra n elements de la llista l
(defun borra_n (n l)
	(cond 	((= n 0) l)
		(t (borra_n (- n 1)(cdr l)))))

;Donat un element, borra totes les aparicions d'aquest a una llista
(defun borra_tots(x l)
	(cond	((null l)	nil)
		((equal	x (car l)) (borra_tots x (cdr l)))
		(t	(cons (car l)(borra_tots x (cdr l))))))

;Borra la primera aparició d'un element d'una llista
(defun borra_un (x l)
	(cond 	(null l)	nil)
		(equal	x (car l) (cdr l))
		(t	cons (car l)(borra_un x (cdr l)))) ;deixam l'element comprovat com estava i passam al següent

;Mostra el darrer element de la llista
(defun darrer (l) (car(reverse l)))

;Fa la divisió entera entre dos nombres
(defun divisio (m n)
	(cond	((< m n) 0)
		(t	(+ 1(divisio (- m n)n)))))

;Multiplica una constant per tots els elements d'una llista
(defun escala (x l)
	(cond	((null l)	nil)
		(t (cons (* x (car l)) (escala x (cdr l))))))

;eleva el primer parámetre al segon i dona el resultat
(defun exponent (m n)
	(cond ((= n 0) 1)
	(t	(* m (exponent m (- n 1))))))

;calcula el nombre factorial. Definició de recursivitat
(defun factorial(n) 
	(cond	((= n 0) 1)
	(t (* n (factorial(- 1 n))))))

(defun fer_primer (n l)
	(cond 	((= n 0) l)
		(t	(cons(car l)(fer_primer(- n 1)(cdr l))))))

(defun fib(n)
	(cond	((= n 1) 1)
		((= n 2) 1)
		(t (+(fib(-n 1))(fib (- n 2))))))

(defun inserta_dreta (n m l)
	(cond	((null l)	nil)
		((eql n(car l))(cons(car l)(cons m(cdr l))))
		(t (cons(car l)(inserta_dreta n m (cdr l))))))

(defun inserta_esquerra (n m l)
	(cond	((null l)	nil)
		((eql n (car l)) cons'(m l)
		(t	(cons'(car l)(inserta_esquerra (n m (cdr l))))))))

;Comportament semblant a la comanda member:
(defun my_member (x l)
	(cond	((null l)	nil)
		(eql	x (car l)	l)
		(t	(my_member(x (cdr l))))))

;Mostra el numero d'elements de la llista pasada per paràmetre
(defun num_elements(l)
	(cond ((null l)	0)
	(t (+ 1 (num_elements(cdr l))))))

;Mostra si un element pertany a una llista
(defun pertany(x l)
	(cond	((null l)	nil)	;Cas de la llista buida
		((eql x (car l)) t)	;Si pertany al primer element de la llista, l'hem trobat
		(t (pertany x (cdr l)))))	;Sino, llavors feim recursivitat amb la resta de la llista

;sqrt(x)
(defun quadrat(x) (* x x))

;torna el darrer element d'una llista
(defun rac(l)
	(cond (null (cdr l)	(car l))
	(t	(rac(cdr l)))))

;retorna una llista sense el seu darrer element
(defun rdc (l)
	(cond	((null (cdr l))	nil)
		(t	(cons(car(rdc (cdr l)))))))

;construye una llista por el final
(defun snoc (x l)
	(cond	((null l)	(cons x nil))
		(t	(cons(car l) (snoc x (cdr l))))))

(defun substituir (m n l)
	(cond 	((null l)	nil)
		(eql(m(car l)(cons n)))
		(t	(cons(car l)(substituir m n (cdr l))))))

;Mostra el tercer element d'una llista
(defun tercer_element(l) 
	(car (car (car l))))
;------------------;------------------;------------------;------------------;------------------;------------------
;------------------;------------------;------------------;------------------;------------------;------------------
;Mapcar: Aplica una funcio a una llista (mapcar 'suma '(1 2 3)) -> fa la suma d'aquests elements
(defun escala (m l)
	(mapcar '(lambda(n)(* n m) l)))

(defun transposta (l)
	(cond	((null l) nil)
		(t	(cons(mapcar 'car m)(transposta(mapcar 'cdr l))))))
