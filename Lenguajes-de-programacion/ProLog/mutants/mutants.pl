animal([c,o,c,o,d,r,i,l]).
animal([t,o,r,t,u,g,a]).
animal([l,l,o,p]).
animal([g,o,r,r,i,o]).
animal([o,n,s,o]).
animal([g,a,l,l,i,n,a]).
animal([s,o,m,e,r,a]).

afegir([],L,L).
afegir([X|L1],L2,[X|L3]):-afegir(L1,L2,L3).

mutant(X):-
			animal(A), animal(B),	
			afegir(CapA,CoaA,A), CapA\=[], CoaA\=[],
			afegir(CapB,CoaB,B),
			CoaA = CapB,
			afegir(CapA,B,X).
