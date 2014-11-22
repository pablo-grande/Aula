with Ada.Command_line; use Ada.Command_Line;
with t_frequencies; use t_frequencies;
with Ada.Text_IO; use Ada.Text_IO;
with codifica_f,decodifica_f; use codifica_f,decodifica_f;
with arbre_caracters; use arbre_caracters,arbre_caracters.a_c;
 
procedure cryptomatic is
	a : arbre;
	Taula: abecedari;
	ok: boolean;
begin   
   
   if (Argument_Count /= 3) then 
		Put_line("Nombre de paràmetres incorrecte, haurien de ser 3");
   else		
		if (Argument(1) = "c") then			-- codifica			
			codifica(Argument(2),Argument(3));	
		else 
			if (Argument(1) = "d") then 		-- decodifica
				decodifica(Argument(2),Argument(3));
			else 
				if (Argument(1) = "r") then		-- genera els recursos .co i .de
					-- Arg 2: nom del fitxer a partir del qual generam el recursos
					-- Arg 3: nom que donam als recursos (ex: "re" -> re.co / re.de)
					tbuida(Taula);      
					omplir(Taula, Argument(2), ok);		-- genera una taula d'aparicions de caracters donat un fitxer
					mostra(Taula); 						-- Guarda el nombre d'aparicions de cada caracter
					genera_codis(Taula,a,Argument(3));	-- Genera una taula de codis per a cada caracter (*.co)
					mostra(a);							-- imprimeix s'arbre resultant	
					genera_transicions(a,Argument(3));
				else
					Put_line("Ordre no reconeguda, només 'c','d' o 'r'");
				end if;
			end if;
		end if;
   end if;
end cryptomatic;
