with d_heap;
with Ada.Text_IO; use Ada.Text_IO;
with Ada.Characters.Latin_1; use Ada.Characters.Latin_1;
with Ada.Strings.Fixed;use Ada.Strings.Fixed;
with Ada.Strings.Unbounded;use Ada.Strings.Unbounded; 

package body codifica_f is
procedure genera_codis(Taula: in abecedari; a: out arbre; fname: in string) is

package tree_heap is new d_heap (item => arbre,"<" => "<",">" => ">");	use tree_heap;

arbre_consulta,arrel,fe,fd: arbre; 
f: float; 
it: iterator;
k: arbre_caracters.Rang_Valors; 		--caracter del nostre conjunt 
monticle: heap; 						--monticle on guardarem els arbres
final: boolean:= false;
f_codis: constant String:= fname&".co";

begin
	buit(monticle);		--construim un monticle buit
	primer(Taula, it);	--es situa al primer element(iterador)
	-- construeix un arbre per cada caràcter i l'afegeix al monticle
	while (esValid(it)) loop
		consulta(Taula, it, k, f);
		construeix(arbre_consulta,k,f);
		posa(monticle,arbre_consulta);
		succesor(Taula, it);
	end loop;
	
	-- agrupa els arbres del monticle fins obtenirne un amb tots el caràcters
	while not final loop	
		fe:= darrer(monticle);
		elimina_darrer(monticle);
		if not es_buit(monticle) then
			fd:= darrer(monticle);
			elimina_darrer(monticle);
		end if;
		final:=es_buit(monticle); 		--condició final, tenim l'arbre complet al heap
		construeix(arrel,fe,fd,f);
		posa(monticle,arrel);
	end loop;
	a:=darrer(monticle);
	postordre(a,f_codis);				-- calcula taula de codificació de l'arbre obtingut
	
end genera_codis;

procedure postordre(a: in arbre; fname: in String) is
	Fitxer: Dir_IO.File_Type;
	registre: Entrada;
	begin
		Put_line("----------------------------------------");
		Put_line("      Simbol"&HT&"|      Codi");
		Put_line("----------------------------------------");
		Create(Fitxer, Out_File,fname);
		recorregut(a, Fitxer,registre,0);
		Close(Fitxer);
		Put_line("----------------------------------------");
		put_line("Taula de codificació generada i guardada a '" & fname & "'");
end postordre;
		
procedure recorregut(a: in arbre; file: in Dir_IO.File_Type; registre: in out Entrada;d: in integer) is
	lt, rt: arbre;
	tnd: tipusdenode; 					-- discriminant
	codi_e,codi_d: Unbounded_String; 	-- codis dels fills
	reg_fe,reg_fd: Entrada; 			-- registres succesors
	begin
		-- obtenim el codi 'base' per als fills
		codi_e:= to_unbounded_string(registre.codi(1..d));
		codi_d:=codi_e;		
		arrel(a,tnd);
		if (tnd = n_pare) then
			-- cap a l'esquerra
			esquerra(a,lt);							
			Append(codi_e,"0");											-- afegim el codi del successor
			Move(to_string(codi_e),reg_fe.Codi);						-- guardam el codi complet al registre
			recorregut(lt, file,reg_fe,d+1);		
			-- cap a la dreta
			dreta(a,rt);
			Append(codi_d,"1");
			Move(to_string(codi_d),reg_fd.Codi);
			recorregut(rt, file,reg_fd,d+1);
		else
			get(a,registre.Lletra);										--llegim el caracter actual y el guardam al registre
			Write(file,registre,Rang_Valors'Pos(registre.Lletra)); 		-- escribim el registre al fitxer(posicio = valor ASCII)
			Put_line(HT&registre.Lletra&""&HT&"|"&HT&registre.codi);
		end if;
end recorregut;

procedure codifica(fname_text,fname_codis: in string) is
text: Seq_IO.File_Type;
codis: Dir_IO.File_Type;
resultat: Ada.Text_IO.File_Type;
Lletra: Rang_Valors; 																	--lletra que llegim del fitxer de text
registre: Entrada;																		--codi que llegim de la taula de codis
fname_resultat: constant string :="c_"&fname_text;
begin
	Open(text,In_File,fname_text);
	Open(codis,In_File,fname_codis);
	Create(resultat,Out_File,fname_resultat);
	put_line("Text codificat(guardat a '"& fname_resultat &"'):");
	while not End_Of_File(text) loop
			Read(text, Lletra);															-- llegim el caràcter
			if (Lletra'Valid) and then (Rang_Valors'Pos(Lletra) <= Size(codis)) then			
				Set_Index(codis,Rang_Valors'Pos(Lletra));								-- apuntam al codi corresponent
				Read(codis,registre);
				if (registre.Lletra /= Lletra) then									-- aquesta lletra no té codi
					put(Lletra);
					put(resultat, lletra);
				else 																	-- té codi
					for i in 1..registre.codi'length loop
						exit when (registre.codi(i) = ' ');
						put(registre.codi(i));
						put(resultat, registre.codi(i));	
					end loop;
										
				end if;
			else
				put(Lletra);
				put(resultat, lletra);
			end if;
	end loop;
	Close(resultat);
	Close(text);
	Close(codis);
end codifica;
		
end codifica_f;
