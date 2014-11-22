/bonus/
pertany(X,[X|_]).
pertany(X,[Y|L]):-pertany(X,L).

/exercicis/
/alt/
llista(1,[1]).
llista(N,[N|L]):-N1 is N-1, llista(N1,L).

/1/
llista([])
llista([_|_])

/2/
element(1,[X|_],X).
element(N,[_|L],X):-N is N-1,
			element(N1,L,X).

/3/
invertir([X|L1],L2):-invertir(L1,L3),
			afegir(L3,[X],L2).

invertirtot([X|L1],L2):-llista(X)!invertirtot(X,X1),
				invertirtot(L1,L3),
				afegir(L3,[X1],L2).

/4/
retornaNprimers(0,[],L).
retornaNprimers(N,[X|L1],[X|L2]):-N1 is N-1,
				retornaNprimers(N1,L1,L2).

/5/
extreuNprimers(0,L,L).
extreuNprimers(N,[X|L1],L2):-N1 is N-1,
				extreuNprimers(N1,L1,L2).

/6/
retornaNdarrers(N,L1,L2):-long(L1,N1),
				N2 is N1-N,
				extreuNprimers(N2,L1,L2).

/8/
sumar([],0).
sumar([X|L],N):-sumar(L,N1),N is N1+X.

/9/
sumaparells([0],N).
sumaparells([X|L],

/12/
sumallista(N):-digit(A),digit(B),digit(C),digit(D), N is A+B+C+D,
							write([A,B,C,D]),fail.

afegir([],L,L).
afegir([X|L1],L2,[X|L3]):-afegir(L1,L2,L3).

darrer([X], X).
darrer([X|L],Y):-darrer(L,Y).

borrar(X,[],[]).
borrar(X,[X|L1],L2):-borrar(X,L1,L2).
borrar(X,[Y|L1],[Y|L2]):-X\=Y,borrar(X,L1,L2).

permuta([],[]).
permuta([X|L1],L2):-permuta(L1,L3), 
			    inserta(X,L3,L2).

inserta(X,L,[X|L]).
inserta(X,[Y|L1],[Y|L2]):-inserta(X,L1,L2).

