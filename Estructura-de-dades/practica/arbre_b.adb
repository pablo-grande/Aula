with Ada.Text_Io; use Ada.Text_Io;
with Ada.Float_Text_io; use Ada.Float_Text_io;

package body arbre_b is

--crea un arbre buit
procedure buit (t:out arbre)is
	p: pnode renames t.root;
begin
	p:=null;
end buit;

--fa un node interior
procedure construeix (t:out arbre; lt,rt:in arbre; f: out float)is
	p: pnode renames t.root;
begin
	p:= new node(n_pare);
	p.fe:=lt.root;
	p.fd:=rt.root;
	--sumamos las probabilidades.
	f:=lt.f+rt.f;
	t.f:=f;
exception
	when storage_error => raise overflow;
end construeix;

--fa un node fulla
procedure construeix (t:out arbre; x:in item; f: in float)is
	p: pnode renames t.root;
begin
	--declaración del nodo hoja
	p:= new node(n_fulla);
	p.x:=x;
	--construcción del árbol
	t.f:=f;
exception
	when storage_error => raise overflow;
end construeix;

procedure arrel (t:in arbre; tnd:out tipusdenode)is
	p: pnode renames t.root;
begin
	 tnd:=p.tnd;
exception
	when constraint_error => raise mal_us;
end arrel;

--fa fill esquerr el segon paràmetre del primer paràmetre
procedure esquerra (t:in arbre; lt:out arbre) is
	p: pnode renames t.root;
	pe: pnode renames lt.root;
begin
	pe:=p.fe;
exception
	when constraint_error => raise mal_us;
end esquerra;

--fa fill dret el segon paràmetre del primer paràmetre
procedure dreta (t:in arbre; rt:out arbre)is
	p: pnode renames t.root;
	pd: pnode renames rt.root;
begin
	pd:=p.fd;
exception
	when constraint_error => raise mal_us;
end dreta;


--funcions de major, menor i buit--

function es_buit (t:in arbre) return boolean is
	p: pnode renames t.root;
begin
	return p=null;
end es_buit;

function "<" (x1,x2: in arbre) return boolean is
	f1:float renames x1.f;
	f2:float renames x2.f;
begin
	return (f1 < f2);
end "<";

function ">" (x1,x2: in arbre) return boolean is
	f1:float renames x1.f;
	f2:float renames x2.f;
begin
	return (f1 > f2);
end ">";

procedure get (t: in arbre; x:out item) is
	begin
		x:=t.root.x;
end get;

--PROCEDIMENTS AUXILIARS

--funció auxiliar per imprimir un node
procedure mostra (pn: in pnode;d: in Integer) is 
	tipus: tipusdenode renames pn.tnd;
	--~ nivell: constant Integer:=d+1;	--actualitza el nivell de profunditat
	root_simbol: constant character:= '*';
	shift: constant string:= "  "; 
begin	
	if (pn /= null) then --si està buit no fa res
		for i in 1..d loop put(shift);	end loop;
		case tipus is
			when n_pare =>  
				put("└──> ");				
				put(root_simbol);new_line;				
				mostra(pn.fe,d+1);new_line;
				mostra(pn.fd,d+1);
			when n_fulla => 
				put("└──> ");
				Put_Item(pn.x);
		end case;
	end if;
end mostra;

--saca el árbol a un fichero de texto
procedure mostra (t:in arbre) is
   --campos del árbol
   r: pnode renames t.root;
   f: float renames t.f;
   d: constant Integer:=0;   --profunditat de s'arbre
begin
	new_line;
    Put("[");Put(f,FORE=>1, AFT=>2, EXP=>0);Put("%]");
	new_line;
	mostra(r,d);
	new_line(2);
end mostra;
end arbre_b;


