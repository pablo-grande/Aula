%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%        Práctica Prolog        %%
%%                               %%
%%  Axel Víctor Aliaga Batanero  %%
%%                y              %%
%%      Pablo Riutort Grande     %%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


% Invertir una lista %
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

% Seleccionar un elemento concreto de la lista %
element(1, [X|_], X).
element(N, [_|L], Y) :- N1 is N - 1, element(N1, L, Y).

% Restricciones por filas/columnas %
%restriccion de la fila (1,2,3,4) a izquierda y a derecha%
restriccion(1, f, 2, 3).
restriccion(2, f, 2, 1).
restriccion(3, f, 1, 3).
restriccion(4, f, 3, 2).
%restriccion de la columna (1,2,3,4) arriba y abajo%
restriccion(1, c, 3, 2).
restriccion(2, c, 1, 3).
restriccion(3, c, 2, 1).
restriccion(4, c, 2, 2).

% Alturas de los edificios %
alturaEdifici(1).
alturaEdifici(2).
alturaEdifici(3).
alturaEdifici(4).

% Comprueba si dos filas son diferentes %
alturasDiferentes([],[]).
alturasDiferentes([X|L1], [Y|L2]) :- X \== Y, alturasDiferentes(L1, L2).

% Monta una fila especifica %
% Coloca la restricciones, dice qué alturas son las posibles desde la izquierda, %
% gira la lista, dice qué alturas son posibles desde la derecha y coloca alturas %
% en los edificios que no se sabe seguro qué altura tienen.						 %
montarFila(L, N, C) :-
	restriccion(N, C, R1, R2),
	posiblesAlturas(R1, L),
	invertir(L, L1),
	posiblesAlturas(R2, L1),
	alturaEdifici(X),
	alturaEdifici(Y), X \== Y,
	alturaEdifici(Z), X \== Z, Y \== Z,
	alturaEdifici(T), X \== T, Y \== T, Z \== T,
	append([X], [Y], L2), append([Z], [T], L3),
	append(L2, L3, L).

% Montar la ciudad/matriz %
ciutat(L1, L2, L3, L4) :-
    % montamos dos filas con las listas %
	montarFila(L1, 1, f),
	montarFila(L2, 2, f),
    
    % comprobamos que los elementos de la lista sean distintos %
	alturasDiferentes(L1, L2),

    % seguimos este proceso con el resto de listas %
	montarFila(L3, 3, f),
	alturasDiferentes(L1, L3),
	alturasDiferentes(L2, L3),
	montarFila(L4, 4, f),
	alturasDiferentes(L1, L4),
	alturasDiferentes(L2, L4),
	alturasDiferentes(L3, L4),

	% Trasponer para tener en cuenta las restricciones verticales %
	trasposta([L1, L2, L3, L4], L),
	element(1, L, L5),
	element(2, L, L6),
	element(3, L, L7),
	element(4, L, L8),

    % una vez que tenemos la traspuesta, creamos nuevas filas con las listas %
	montarFila(L5, 1, c),
	montarFila(L6, 2, c),
	
    % y seguimos el mismo proceso de comprobar que las alturas sean distintas %
	alturasDiferentes(L5, L6),
	montarFila(L7, 3, c),
	alturasDiferentes(L5, L7),
	alturasDiferentes(L6, L7),
	montarFila(L8, 4, c),
	alturasDiferentes(L5, L8),
	alturasDiferentes(L6, L8),
	alturasDiferentes(L7, L8), nl.

% Restricciones de Alturas Edificios %
posiblesAlturas(1, [4, _, _, _]).

posiblesAlturas(2, [_, 4, _, _]).
posiblesAlturas(2, [3, _, _, 4]).
posiblesAlturas(2, [X, Y, 4, _]) :- alturaEdifici(X), alturaEdifici(Y), X > Y, X < 4.

posiblesAlturas(3, [1, 2, 4, 3]).
posiblesAlturas(3, [1, 3, _, _]).
posiblesAlturas(3, [2, 3, _, _]).
posiblesAlturas(3, [2, 1, 3, 4]).

posiblesAlturas(4, [1, 2, 3, 4]).