%permuta una llista%
permuta([],[]).
permuta([X|L1],L2):-permuta(L1,L3), inserta(X,L3,L2).

%inserta_elements
inserta(X,L,[X|L]).
inserta(X,[Y|L1],[Y|L2]):-inserta(X,L1,L2).

%posicions%
posicio(X,[X|_],1):-!.
posicio(X,[_|L],P):-posicio(X,L,P1), P is P1+1.

%retorna_element_n
element(1,[X|_],X).
element(N,[_|L],Y):-N1 is N-1, element(N1,L,Y).

%invertir
invertir([], []).
invertir([X|L1], L) :- invertir(L1, L2), append(L2, [X], L),!.

% Trasponer una lista %
trasposta([[]|_], []).
trasposta(L1, [L3|L5]) :- agafaPrimers(L1, L3), agafaDarrers(L1, L4), trasposta(L4, L5).

% Seleccionar los primeros elementos de una lista %
agafaPrimers([], []).
agafaPrimers([[X|_]|L2], [X|L3]) :- agafaPrimers(L2, L3).

% Seleccionar los últimos elementos de la lista %
agafaDarrers([], []).
agafaDarrers([[_|L1]|L2], [L1|L3]) :- agafaDarrers(L2, L3).

% Comprueba si dos filas son diferentes %
alturasDiferentes([],[]).
alturasDiferentes([X|L1], [Y|L2]) :- X \== Y, alturasDiferentes(L1, L2).

%restriccions
restriccio(4,[1,2,3,4]).

restriccio(3,[1,2,4,3]).
restriccio(3,[1,3|_]).
restriccio(3,[2,3|_]).
restriccio(3,[2,1,3,4]).

restriccio(2,[_,4|_]).
restriccio(2,[2,1,4,3]).
restriccio(2,[3|_]).

restriccio(1,[4|_]).

%trasposta


ciutat(L1,L2,L3,L4):-
    %filas
    permuta([1,2,3,4],L1),
    restriccio(2,L1),
    permuta([1,2,3,4],L2), alturasDiferentes(L2,L1),
    restriccio(2,L2),
    permuta([1,2,3,4],L3), alturasDiferentes(L3,L2), alturasDiferentes(L3,L1),
    restriccio(1,L3),
    permuta([1,2,3,4],L4), alturasDiferentes(L4,L3), alturasDiferentes(L4,L2), alturasDiferentes(L4,L1),
    restriccio(3,L4),

	%invertir
	invertir(L1,I1), invertir(L2,I2), invertir(L3,I3), invertir(L4,I4),
	restriccio(3,I1),restriccio(1,I2),restriccio(3,I3),restriccio(2,I4),
	%invertir(I1, L1), invertir(I2,L2), invertir(I3,L3), invertir(I4,L4),

	%trasponer
	trasposta([L1, L2, L3, L4], M),
	element(1, M, C1), element(2, M, C2), element(3, M, C3), element(4, M, C4),
	restriccio(3, C1), restriccio(1, C2), restriccio(2, C3), restriccio(2, C4),

	%invertir trasposta
	invertir(C1, I5), invertir(C2, I6), invertir(C3, I7), invertir(C4, I8),
	restriccio(2,I5),restriccio(3,I6),restriccio(1,I7),restriccio(2,I8),nl.
	%invertir(I5, C1), invertir(I6,C2), invertir(I7,C3), invertir(I8,C4),

	%trasposta([C1, C2, C3, C4], M),
	%element(1, M, L1), element(2, M, L2), element(3, M, L3), element(4, M, L4), nl.






