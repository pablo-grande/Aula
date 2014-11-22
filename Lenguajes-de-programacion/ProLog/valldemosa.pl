pertany(X,[X|L]).
pertany(X,[Y|L]):-pertany(X,L). de coneixements del animals

afegir([],L,L).
afegir([X|L1],L2,[X|L3]):-afegir(L1,L2,L3).

darrer([X], X).
darrer([X|L],Y):-darrer(L,Y).

invertir([],[]).
invertir([X|L1],L2):- invertir(L1,L3), 
			afegir(L3,[X],L2).

borrar(X,[],[]).
borrar(X,[X|L1],L2):-borrar(X,L1,L2).
borrar(X,[Y|L1],[Y|L2]):-X\=Y,borrar(X,L1,L2).

permuta([],[]).
permuta([X|L1],L2):-permuta(L1,L3), 
			    inserta(X,L3,L2).

inserta(X,L,[X|L]).
inserta(X,[Y|L1],[Y|L2]):-inserta(X,L1,L2).

costat(X,Y):- X is Y-1, X>0, Y<6.
costat(X,Y):- X is Y+1, X>0, Y<6.

posicio(X,[X|L],1):-!.
posicio(X,[Y|L],P):-posicio(X,L,P1), P is P1+1.

qui_es(L,N,A):-element

estudia(pep,historia)
viu-costat(joana,Y):-es(Y,binissalem)
viu-costat(manel):-es(Y,palma)
condueix(X,Y):-de-color(Y,vermell),viu-costat(X,Z),condueix(A,Z),de-color(Z,blau)
condueix(X,Y):-color(Y,vermell),estudia(X,pedagogia)
condueix(X,fiat):-viu-costat(X,Z),condueix(Z,A),de-color(A,negre)
viu-cosat(joana,Y):-estudia(Y,dret)
de-color(volkswagen,gris)
condueix(X,renault):-es(X,manacor)
viu-costat(X,_):-condueix(X,fiat)
condueix(maria,audi)
es(toni,soller)
estudia(X,informatica):-condueix(X,bmw)
condueix(manel,Y):-color(Y,blanc)
estudia(X,economiques):-viu-costat(X,_)