with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;
with Ada.Text_IO;use Ada.Text_IO;

package body d_heap is

--crea un monticle buit
procedure buit (q:out heap)is
	n: natural renames q.n;
begin
	n:=0;
end buit;

--miram si es buit
function es_buit (q:in heap) return boolean is
	n: natural renames q.n;
begin
	return n=0;
end es_buit;

--posa un element al monticle
procedure posa (q:in out heap; x:in item) is
	a: mem_space renames q.a;
	n: natural renames q.n;
	i: natural;	--index a un node del monticle
	pi: natural; --index al pare del node
begin
	--si la cola està plena
	--~ if n=size then raise space_overflow; end if;
	--si no estigués plena, la preparam per a ficar un element
	n:=n+1; --augmentam el nombre d'elements de la coa
	i:=n; --l'índex del node que visitam a la coa
	pi:=n/2; --índex del pare del node que visitam a la coa
	
	--mentres hi hagi un pare per a aquest element, llavors miram si l'element a ficar es menor que el del seu pare,
	--en cas afirmatiu, vol dir que s'ha de recolocar a la coa de prioritats.
	while pi>0 and then a(pi)>x loop
		--per a recolocar l'element feim:
		a(i):=a(pi); --asignam la posició del nou node al seu pare (pujam un nivell)
		--actualitzam els nodes
		i:=pi; --el node fill apunta al pare
		pi:=i/2; --actualitzam el node pare
	end loop;
	--si no tenim un node major que el del propi objecte, hem acabat
	a(i):=x;
end posa;

--elimina el darrer element de l'arbre
procedure elimina_darrer(q: in out heap)is
	a: mem_space renames q.a;
	n: natural renames q.n;
	i: natural;	--index a un node del monticle
	ci: natural; --index per al darrer fill de i
	x: item; --item auxiliar.
begin
	--si el monticle està buit
	if n=0 then raise bad_use; end if;
	x:=a(n); --guardam el darrer element de la coa
	
	--pasam al calcular com quedarà el darrer dins el nostre monticle
	n:=n-1; --decrementam els elements de la coa
	i:=1; --posa el node al primer element de la coa
	ci:=i*2; --calculam el fill del node anterior
	
	--@TODO: comentar esta linea
	if ci<n and then a(ci+1)<a(ci) then ci:=ci+1; end if;
	
	--mentres quedin fills i el nostre element sigui menor que l'element darrer
	while ci<=n and then a(ci)<x loop
		--feim actualitzacio de tal manera que podem recorrer l'arbre cap a baix
		a(i):=a(ci);
		i:=ci;
		ci:=i*2;
	end loop;
	--si l'element darrer es major que l'actual, hem acabat
	a(i):=x;
end elimina_darrer;

--retorna el darrer element de la coa
function darrer (q:in heap) return item is
	a: mem_space renames q.a;
	n: natural renames q.n;
begin
	if n=0 then raise bad_use; end if; --la coa està buida!
	return a(1); --el "darrer element" de la coa es troba al principi.
end darrer;

end d_heap;
