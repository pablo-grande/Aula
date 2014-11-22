; ---------------------------------------------------------
; Entrega Pràctica de Lisp
;
; Axel Víctor Aliaga Batanero,
; Pablo Riutort Grande
; ---------------------------------------------------------

;===================
;Funcions auxiliars
;===================

; INSERIR AL FINAL DE UNA LLISTA
(defun snoc (x L)
	(cond 	(	(null L) (cons x nil)
			)(t	(cons (car L) (snoc x (cdr L)))
			)
	)
)

; RADIANS A GRAUS
(defun RtD (r)
	(* 180.0 (/ r pi))
)

; GRAUS A RADIANS
(defun DtR (d)
	(* pi (/ d 180.0))
)

; OBTENIR ELS PIXLES HORIZONTALS DEL CANO 1
(defun getCos (a)
	(realpart (round (/ (* (cos (DtR a)) 15) (cos (DtR 0)))))
)

; OBTENIR ELS PIXELS VERTICALS DE CANO 1
(defun getSin (a)
	(realpart (round (/ (* (sin (DtR a)) 15) (sin (DtR 90)))))
)

; OMPLIR FIGURA AMB COLOR (bàsicament fa línies horitzontals)
(defun omplirFigura (xMin yMin xMax yMax)
	; Mentre no sigui adalt de la figura omplir amb retxes
	(cond ((< yMin yMax)
		(drawrel (- xMax xMin) 0)
			(move xMin (+ yMin 1))
			(omplirFigura xMin (+ yMin 1) xMax yMax)
	))
)

; DIBUIXAR RECTANGLE
(defun drawRect (x1 y1 x2 y2)
	(move x1 y1)
	(drawrel 0 (- y2 y1))	; Recta vertical esquerra
	(drawrel (- x2 x1) 0)	; Recta horitzontal adalt
	(drawrel 0 (- y1 y2))	; Recta vertical dreta
	(drawrel (- x1 x2) 0)	; Recta horitzontal abaix
)


;================
;Funcions per a realitzar el fractal "Curva del dragón"
;================

; INVERTIR LLISTA
(defun invLLista (L)
	(cond	(	(null L) nil
			)(t (snoc (girMovs (car L)) (invLLista (cdr L)))
			)
	)
)

; JUNTAR DUES LLISTES
(defun juntarLlistes (L1 L2)
	(cond	(	(null L2) L1
			)(t	(juntarLlistes (snoc (car L2) L1) (cdr L2))
			)
	)
)

; OBTENIR MOVIMENTS DRAGÓN
(defun girMovs (x)
	(cond	(	(eq x 'I) 'D
			)(	(eq x 'D) 'I
			)
	)
)

; ALGORISME "LA CURVA DEL DRAGÓN"
(defun curva (n)
	(cond	(	(eq n 0) nil
			)(t	(juntarLlistes 	(snoc 'I (curva (- n 1)))
								(invLLista (curva (- n 1)))
				)
			)
	)
)

; PINTAT EXPLOSIÓ "CURVA DEL DRAGÓN"
(defun rebenta (x)
	(putprop 'escenari (cdr (get 'escenari 'corba)) 'corba)
	; Moviment per cap a l'esquerra o la dreta
	(cond	(	(null x) nil
			)(	(eq x 'I) 
				(cond 	(	(eq (get 'escenari 'lastMove) 'L)
							(drawrel 0 (- 0 (get 'escenari 'tamMove)))
							(putprop 'escenari 'D 'lastMove)
						)(	(eq (get 'escenari 'lastMove) 'D)
							(drawrel (get 'escenari 'tamMove) 0)
							(putprop 'escenari 'R 'lastMove)
						)(	(eq (get 'escenari 'lastMove) 'R)
							(drawrel 0 (get 'escenari 'tamMove))
							(putprop 'escenari 'U 'lastMove)
						)(	(eq (get 'escenari 'lastMove) 'U)
							(drawrel (- 0 (get 'escenari 'tamMove)) 0)
							(putprop 'escenari 'L 'lastMove)
						)
				)
				(rebenta (car (get 'escenari 'corba)))
			)(	(eq x 'D)
				(cond 	(	(eq (get 'escenari 'lastMove) 'L)
							(drawrel 0 (get 'escenari 'tamMove))
							(putprop 'escenari 'U 'lastMove)
						)(	(eq (get 'escenari 'lastMove) 'D)
							(drawrel (- 0 (get 'escenari 'tamMove)) 0)
							(putprop 'escenari 'L 'lastMove)
						)(	(eq (get 'escenari 'lastMove) 'R)
							(drawrel 0 (- 0 (get 'escenari 'tamMove)))
							(putprop 'escenari 'D 'lastMove)
						)(	(eq (get 'escenari 'lastMove) 'U)
							(drawrel (get 'escenari 'tamMove) 0)
							(putprop 'escenari 'R 'lastMove)
						)
				)
				(rebenta (car (get 'escenari 'corba)))
			)
	)
	
)


;=================
;Entitats del joc
;=================

; CREAR LES PROPIETATS DEL ESCENARI Y CANONS
(defun crearPropietats ()
	; Propietats escenari
	(putprop 'escenari 300 'yMax)											; Altura màxima assolible
	(putprop 'escenari 1 'xT1)												; Posició X més esquerra (1)
	(putprop 'escenari (+ (random 300) 100) 'xT2)							; Posició X final bloc 1
	(putprop 'escenari (+ (+ (random 130) 20) (get 'escenari 'xT2)) 'xT3)	; Posició X final bloc 2
	(putprop 'escenari 640 'xT4)											; Posició X final bloc 3 (màxima, 635)
	(putprop 'escenari (random (get 'escenari 'yMax)) 'yT2)					; Altura Y bloc 2
	(putprop 'escenari (+ (random (- (get 'escenari 'yMax) 					; Altura Y bloc 1
						(get 'escenari 'yT2))) (get 'escenari 'yT2)) 'yT1)
	(putprop 'escenari (random (get 'escenari 'yT1)) 'yT3)					; Altura Y bloc 3
	(putprop 'escenari 1 'yT4)												; Altura mínima (1)
	(putprop 'escenari (- 0 9.8) 'G)				; Gravetat (9.8)
	(putprop 'escenari (- 5 (random 10)) 'vent)		; Força del vent
	(putprop 'escenari (curva 9) 'corba)			; Corba del drac nivell 9
	(putprop 'escenari 'L 'lastMove)				; Darrer moviment per la corva del drac (L, R, U, D)
	(putprop 'escenari 2 'tamMove)					; Tamany de les línies de la corva del drac
	
	; Propietas cano 1
	(putprop 'cano1 (random (- (get 'escenari 'xT2) 20)) 'xcp)	; Posició X esquerra
	(putprop 'cano1 (+ (get 'cano1 'xcp) 20) 'xcg) 				; Posició X dreta
	(putprop 'cano1 (+ (get 'cano1 'xcp) 10) 'xcc)				; Posició X centre canó
	(putprop 'cano1 (get 'escenari 'yT2) 'ycp)					; Posició Y abaix
	(putprop 'cano1 (+ (get 'cano1 'ycp) 10) 'ycg)				; Posició Y adalt
	(putprop 'cano1 45 'gc)										; Graus del canó
	(putprop 'cano1 (getCos (get 'cano1 'gc)) 'xpc)				; Quantitat píxels X canó 
	(putprop 'cano1 (getSin (get 'cano1 'gc)) 'ypc)				; Quantitat píxels Y canó
	(putprop 'cano1 0 'vx)		; Velocitat X tir parabòlic
	(putprop 'cano1 0 'vy)		; Velocitat Y tir parabòlic
	(putprop 'cano1 0 'px)		; Posició X tir parabòlic
	(putprop 'cano1 0 'py)		; Posició Y tir parabòlic
	
	; Propietats cano 2
	(putprop 'cano2 (+ (random (- (- (get 'escenari 'xT4) 20)	; Posició X esquerra
					(get 'escenari 'xT3))) (get 'escenari 'xT3)) 'xcp)
	(putprop 'cano2 (+ (get 'cano2 'xcp) 20) 'xcg)				; Posició X centre canó
	(putprop 'cano2 (+ (get 'cano2 'xcp) 10) 'xcc)				; Posició X centre canó
	(putprop 'cano2 (get 'escenari 'yT3) 'ycp)					; Posició Y abaix
	(putprop 'cano2 (+ (get 'cano2 'ycp) 10) 'ycg)				; Posició Y adalt
	(putprop 'cano2 135 'gc)									; Graus del canó
	(putprop 'cano2 (getCos (get 'cano2 'gc)) 'xpc)				; Quantitat píxels X canó 
	(putprop 'cano2 (getSin (get 'cano2 'gc)) 'ypc)				; Quantitat píxels Y canó
	(putprop 'cano2 0 'vx)		; Velocitat X tir parabòlic
	(putprop 'cano2 0 'vy)		; Velocitat Y tir parabòlic
	(putprop 'cano2 0 'px)		; Posició X tir parabòlic
	(putprop 'cano2 0 'py)		; Posició Y tir parabòlic
)

; PINTAR LÍNIES VENT
(defun forzaVent (n)
	(cond	((> n 0)
				(drawrel 0 (- 0 10))
				(moverel 5 (+ 0 10))
				(forzaVent (- n 1))
			)((< n 0)
				(drawrel 0 (- 0 10))
				(moverel (- 0 5) (+ 0 10))
				(forzaVent (+ n 1))
			)
	)
)

; CREAR LES 3 PLATAFORMES
(defun crearEscenari ()
	(color 0 0 0 135 206 250) ;definim els colors de les peces
	(cls)

	; Plataforma 1
	
	;Amb les dades predefinides de la llista, pintarem l'escenari
	(drawRect 0 0 (get 'escenari 'xT2) (get 'escenari 'yT2))
	(color 133 249 176 0 0 0)
	(move (get 'escenari 'xT1) (get 'escenari 'yT4))
	(omplirFigura (get 'escenari 'xT1) (get 'escenari 'yT4) 
				(get 'escenari 'xT2) (get 'escenari 'yT2))
	(color 0 0 0 135 206 250)
	
	; Plataforma 2
	(drawRect (get 'escenari 'xT2) 0 (get 'escenari 'xT3) (get 'escenari 'yT1))
	(color 133 249 176 0 0 0)
	(move (+ (get 'escenari 'xT2) 1) (get 'escenari 'yT4))
	(omplirFigura (+ (get 'escenari 'xT2) 1) (get 'escenari 'yT4) 
				(get 'escenari 'xT3) (get 'escenari 'yT1))
	(color 0 0 0 135 206 250)
	
	; Plataforma 3
	(drawRect (get 'escenari 'xT3) 0 (get 'escenari 'xT4) (get 'escenari 'yT3))
	(color 133 249 176 0 0 0)
	(move (+ (get 'escenari 'xT3) 1) (get 'escenari 'yT4))
	(omplirFigura (+ (get 'escenari 'xT3) 1) (get 'escenari 'yT4) 
				(get 'escenari 'xT4) (get 'escenari 'yT3))
	(color 0 0 0 135 206 250)
	
	; Fletxa vent
	(cond	(	(> (get 'escenari 'vent) 0)
				(move 10 300)
				(drawrel 40 0)
				(drawrel (- 0 (getCos 30)) (- 0 (getSin 30)))
				(move 50 300)
				(drawrel (- 0 (getCos 30)) (+ 0 (getSin 30)))
				(move 10 300)
				(forzaVent (get 'escenari 'vent))
			)((< (get 'escenari 'vent) 0)
				(move 10 300)
				(drawrel 40 0)
				(move 10 300)
				(drawrel (+ 0 (getCos 30)) (- 0 (getSin 30)))
				(move 10 300)
				(drawrel (+ 0 (getCos 30)) (+ 0 (getSin 30)))
				(move 50 300)
				(forzaVent (get 'escenari 'vent))
			)
	)
)

; COLOCAR ELS DOS CANONS
(defun colocarCanons ()
	
	; Base Cano 1
	(drawRect 	(get 'cano1 'xcp) (get 'cano1 'ycp) 
				(get 'cano1 'xcg) (get 'cano1 'ycg))
	(color 194 193 189 0 0 0)
	(move (+ (get 'cano1 'xcp) 1) (+ (get 'cano1 'ycp) 1))
	(omplirFigura (+ (get 'cano1 'xcp) 1) (+ (get 'cano1 'ycp) 1)
				(get 'cano1 'xcg) (get 'cano1 'ycg))
	(color 0 0 0 135 206 250)
	
	; Cano 1
	(move (get 'cano1 'xcc) (get 'cano1 'ycg))
	(drawrel (get 'cano1 'xpc) (get 'cano1 'ypc))

	; Base Cano 2
	(drawRect 	(get 'cano2 'xcp) (get 'cano2 'ycp) 
				(get 'cano2 'xcg) (get 'cano2 'ycg))
	(color 194 193 189 0 0 0)
	(move (+ (get 'cano2 'xcp) 1) (+ (get 'cano2 'ycp) 1))
	(omplirFigura (+ (get 'cano2 'xcp) 1) (+ (get 'cano2 'ycp) 1)
				(get 'cano2 'xcg) (get 'cano2 'ycg))
	(color 0 0 0 135 206 250)
	
	; Cano 2
	(move (get 'cano2 'xcc) (get 'cano2 'ycg))
	(drawrel (getCos (get 'cano2 'gc)) (getSin (get 'cano2 'gc)))
)

; PUJAR N GRAUS EL CANO 1
(defun puja (c n)
	;Movem el braç del canó del paràmetre
	(cond ((eq c 'cano1) 
		(cond ((< (+ (get c 'gc) n) 180)
			(move (get c 'xcc) (get c 'ycg))
			(putprop c (+ (get c 'gc) n) 'gc)
			(putprop c (getCos (get c 'gc)) 'xpc)
			(putprop c (getSin (get c 'gc)) 'ypc)
			)
		))
	(t (eq c 'cano2)
		(cond ((> (- (get c 'gc) n) 0)
			(move (get c 'xcc) (get c 'ycg))
			(putprop c (- (get c 'gc) n) 'gc)
			(putprop c (getCos (get c 'gc)) 'xpc)
			(putprop c (getSin (get c 'gc)) 'ypc)
			)
		)
	))
	;Actualitzam la pantalla
	(crearEscenari)
	(colocarCanons)
)

; BAIXAR N GRAUS EL CANO 1
(defun baixa (c n)
	(cond ((eq c 'cano1) 
		(cond ((> (- (get c 'gc) n) 0)
			(move (get c 'xcc) (get c 'ycg))
			(putprop c (- (get c 'gc) n) 'gc)
			(putprop c (getCos (get c 'gc)) 'xpc)
			(putprop c (getSin (get c 'gc)) 'ypc)
			)
		))
	(t (eq c 'cano2)
		(cond ((< (+ (get c 'gc) n) 180)
			(move (get c 'xcc) (get c 'ycg))
			(putprop c (+ (get c 'gc) n) 'gc)
			(putprop c (getCos (get c 'gc)) 'xpc)
			(putprop c (getSin (get c 'gc)) 'ypc)
			)
		)
	))
	(crearEscenari)
	(colocarCanons)
)

; OBTENIR VELOCITAT AL MOMENT T
(defun getVel (c v0x v0y tmp)
	(putprop c (+ v0x (get 'escenari 'vent)) 'vx)
	(putprop c (+ v0y (* (get 'escenari 'G) tmp)) 'vy)
)

; OBTENIR POSICIÓ AL MOMENT T
(defun getPos (c v0 tmp)
	; (((v0 * (cos(radianes(angulo canyon1)))) * tmp) + x0) + ((vent / 2) * (tmp * tmp))
	(putprop c 
			(realpart (round (+ (+ (* (* v0 
					(cos (dtr (get c 'gc)))) tmp) 
					(+ (get c 'xcc) (get c 'xpc)))
					(* (/ (get 'escenari 'vent) 2)
					(* tmp tmp)))))
			'px
			)
		;(print (get c 'px))
	; (((v0 * sin(radianes(angulo canyon1))) * tmp) + ((-9.8 / 2) * (tmp * tmp))) + y0
	(putprop c 
			(realpart (round (+ (+ (* (* v0 (sin (dtr 
				(get c 'gc)))) tmp) (* (/ 
				(get 'escenari 'G) 2) (* tmp tmp)))
				(+ (get c 'ycg) (get c 'ypc)))))
			'py
			)
)

; TRAJECTORIA
(defun trajectoria (c v0 tmp x y)
	; Obtenir posicions vol
	(getPos c v0 tmp)
	; Si està en qualsevol part que hi hagi espai lliure i no un mur
	(cond 	(	(or (and	(< (get c 'px) (get 'escenari 'xT2)) 	; Plataforma 1
							(> (get c 'py) (get 'escenari 'yT2))				
					)
					(and	(>= (get c 'px) (get 'escenari 'xT2))	; Plataforma 2
							(> (get c 'py) (get 'escenari 'yT1))
					)
					(and	(> (get c 'px) (get 'escenari 'xT3))	; Plataforma 3
							(> (get c 'py) (get 'escenari 'yT3))
					)
				)
				(cond	(	(and	(>= (get c 'px) (get 'cano1 'xcp))
									(<= (get c 'px) (get 'cano1 'xcg))
									(<= (get c 'py) (get 'cano1 'ycg))
							)
							(move (get 'cano1 'xcg) (get 'cano1 'ycg))
							(rebenta (car (get 'escenari 'corba)))
						)(	(and	(>= (get c 'px) (get 'cano2 'xcp))
									(<= (get c 'px) (get 'cano2 'xcg))
									(<= (get c 'py) (get 'cano2 'ycg))
							)
							(move (get 'cano2 'xcg) (get 'cano2 'ycg))
							(rebenta (car (get 'escenari 'corba)))
						)
				)
				(draw (get c 'px) (get c 'py))
				(move (get c 'px) (get c 'py))
				(trajectoria c v0 (+ tmp 0.008) (get c 'px) (get c 'py))
			)
	)
)

; SIMULACIÓ DEL DISPAR
(defun simula (c v)
	(cls)
	(crearEscenari)
	(colocarCanons)
	(color 255 0 0 135 206 250)
	(move 	(+ (get c 'xcc) (get c 'xpc))
			(+ (get c 'ycg) (get c 'ypc)))
	(trajectoria c v 1 
			(+ (get c 'xcc) (get c 'xpc))
			(+ (get c 'ycg) (get c 'ypc))
	)
	(color 0 0 0 135 206 250)
)

; LLENÇAR EL JOC
(defun pinta ()
	(crearPropietats)
	(crearEscenari)
	(colocarCanons)
)

(pinta)
