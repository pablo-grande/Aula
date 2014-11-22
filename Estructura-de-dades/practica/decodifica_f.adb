with Ada.Text_IO; use Ada.Text_IO;
with Ada.Characters.Latin_1; use Ada.Characters.Latin_1;
with Ada.IO_exceptions;

package body decodifica_f is
procedure genera_transicions(a: in arbre;fname: in String) is
	Fitxer: Seq_IO.File_Type;
	estats: Int_IO.File_Type;				--fitxer on guardam el nombre d'estats
	Estat: integer:=1;
	f_transicions: constant String:=fname&".de";
	begin
		Create(Fitxer, Out_File,f_transicions);
		recorregut(a, Fitxer,Estat);
		Close(Fitxer);
		new_line;put_line("Taula de transicions generada i guardada a '" & f_transicions & "'");
		Create(estats,Out_File,fname_ne);
		Write(estats,Estat); 		-- guardam el nombre de estats
		Close(estats);
		put_line("Nombre d'estats guardat a '" & fname_ne);		
end genera_transicions;

procedure recorregut(a: in arbre; file: in Seq_IO.File_Type; Estat: in out integer) is
	tnd: tipusdenode; 					-- discrimina
	lt, rt: arbre;
	lletra: Character;
	estat_local: integer;
begin
	arrel(a,tnd);
	estat_local:=Estat;
	if (tnd = n_pare) then
		Estat:=Estat+1;
		esquerra(a,lt);
		genera_transicio(file,estat_local,0,Estat,Significat_especial);						
		recorregut(lt, file,Estat);
		
		Estat:=Estat+1;
		dreta(a,rt);
		genera_transicio(file,estat_local,1,Estat,Significat_especial);	
		recorregut(rt, file,Estat);
	else
		get(a,lletra);
		genera_transicio(file,estat_local,0,0,lletra);
	end if;
end recorregut;

procedure genera_transicio(file: in Seq_IO.File_Type; Estat_inicial: in integer; simbol: in simbol_t;Estat_final: in integer;significat: in Rang_valors) is
	registre: Transicio;
begin
	--~ new_line;put(Estat_inicial'img&" "&simbol'img&" "&Estat_final'img&" "&significat);
	registre:=(Estat_inicial,simbol,Estat_final,significat);
	write(file,registre);
end genera_transicio;

function NFA (file: in Seq_IO.File_Type;estats: in integer) return t_automata is
t: Transicio;
t_a: t_automata(1..estats);
begin
	--lectura del fichero dado por parámetro
	while not End_Of_File (file) loop
		read(file,t);
		--~ new_line;put(t.Estat_inicial'img&" "&t.simbol'img&" "&t.Estat_final'img&" "&t.significat);
		if (t.simbol = 0)then
			t_a(t.Estat_inicial).Simbol_0:=t.Estat_final;
			if (t.significat /= significat_especial) then t_a(t.Estat_inicial).Simbol_1:=0; end if;
		else
			t_a(t.Estat_inicial).Simbol_1:=t.Estat_final; 
		end if;
		t_a(t.Estat_inicial).Caracter:=t.Significat;
	end loop;	
	mostra_automata(t_a);
	return t_a;
end NFA;


procedure mostra_automata(a: in t_automata) is
begin
	new_line;
	Put(HT&"Estat"&HT&"|"&HT&"0"&HT&"|"&HT&"1"&HT&"|  Caràcter"&HT&"");new_line;
	Put("-----------------------------------------------------------------");new_line;
	for i in a'Range loop
		Put(HT & i'Img & HT & "|");
		Put(HT & a(i).simbol_0'Img & HT & "|");
		Put(HT & a(i).simbol_1'Img & HT & "|");
		Put(HT & a(i).Caracter);
		new_line;
	end loop;
end mostra_automata;

procedure decodifica(f_text,f_recurs: in string) is
transicions: Seq_IO.File_Type;			-- taula de transicions
text: Ada.Text_IO.File_Type;			-- text a decodificar
resultat: Ada.Text_IO.File_Type;		-- resultat de la decodificació
fname_res: constant string:= "d_"&f_text;
ne: integer;
lletra: character;
Estat,Estat_final: integer;
t_a: t_automata(1..nombre_estats);
begin	
		ne:= nombre_estats;			--llegim el nombre d'estats
		
		put_line("Llegim la taula de transicions del fitxer '"&f_recurs&"':");
		--carregam la taula de transicions
		Open(transicions, In_File, f_recurs);
		t_a:=NFA(transicions,ne);
		Close(transicions);
		
		put_line("Inici decodificació del fitxer '"&f_text&"'");
		--carregam la taula de transicions
		Open(text, In_File, f_text);
		Create(resultat, Out_File, fname_res);
		Get(text,lletra);
		while not End_Of_File(text) loop
			if (lletra = '1' or else lletra = '0') then			-- es un codi
				Estat:=1;
				-- cercam sa lletra
				while not End_Of_File(text) and then (Estat /= 0) loop
					if (lletra = '1') then
						Estat_final:= t_a(Estat).simbol_1;
					else -- lletra = '0'
						Estat_final:= t_a(Estat).simbol_0;
					end if;
					if (Estat_final = 0) then
						put(t_a(Estat).Caracter);		-- hem trobat el caràcter
						put(resultat,t_a(Estat).Caracter);
						Estat:=0;						-- marcam el final						
					else
						Estat:=Estat_final;				-- actualitzam s'estat
						get(text,lletra);						
					end if;
				end loop;
			else 										-- es una lletra
				put(lletra);
				put(resultat,lletra);
				Get(text,lletra);
			end if;
		end loop;
		Close(resultat);
		Close(text);
		put_line("Resultat de la decodificació guardat a '"&fname_res&"'.");
exception
		when ada.io_exceptions.end_error => Close(resultat);Close(text);
end decodifica;

function nombre_estats return integer is
f_estats: Int_IO.File_Type;
ne: integer;
begin
	Open(f_estats, In_File, fname_ne);
	read(f_estats,ne);
	Close(f_estats);
return ne;
end nombre_estats;
end decodifica_f;
