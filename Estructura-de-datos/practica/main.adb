with t_frequencies; use t_frequencies;
with Ada.Text_IO; use Ada.Text_IO;
with codifica_f,decodifica_f; use codifica_f,decodifica_f;
with arbre_caracters; use arbre_caracters,arbre_caracters.a_c;

procedure main is

a : arbre;
Taula: abecedari;
ok: boolean;

begin
	Put_line("Inici d'execució...");
	tbuida(Taula);      
	omplir(Taula, "fitxer.txt", ok);	-- genera una taula d'aparicions de caracters donat un fitxer
	mostra(Taula); 						-- Guarda el nombre d'aparicions a un fitxer
	--~ codifica(Taula,a);					-- Passam a codificar
	--~ mostra(a);							-- imprimeix la taula resultant
	--~ decodifica(a,"transicions.de");
	put_line("..fi d'execucuió");
   
end main;


