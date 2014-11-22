generic 

type item is private;
with procedure Put_Item(x:in item);

package arbre_b is
type arbre is private;
type tipusdenode is (n_fulla, n_pare);
type pnode is private;

procedure buit(t:out arbre);
procedure construeix (t:out arbre; lt,rt:in arbre; f: out float);
procedure construeix (t:out arbre; x:in item; f: in float);
procedure arrel (t:in arbre; tnd:out tipusdenode);
procedure esquerra (t:in arbre; lt:out arbre);
procedure dreta (t:in arbre; rt:out arbre);
procedure get (t:in arbre; x: out item);
function es_buit (t:in arbre) return boolean;
--las dos siguientes pendientes de implementar
function "<" (x1,x2: in arbre) return boolean;
function ">" (x1,x2: in arbre) return boolean;

--procediments auxiliars
procedure mostra(t:in arbre);

--~ procedure recorrer(t:in arbre; n:in out pnode);

mal_us: exception;
overflow: exception;

--private specification
private

	type node;
	type pnode is access node;
	
	
	
	type node (tnd:tipusdenode) is record
		case tnd is
			when n_pare =>  fe: pnode;
							fd: pnode;
			when n_fulla => x: item;
		end case;
	end record;
	
	type arbre is 
		record
			root:pnode;
			f:float;
	end record;
	
end arbre_b;
	
