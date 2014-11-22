%criptoaritmetica
consulta(plutils.pl).

sum(X, 0,0,X,0).
sum(R, X, Y, Z, R2):- 	
	residu(R), digit(X), digit(Y),
	T is R+X+Y, R2 is T // 10, 
	Z is T mod 10.
