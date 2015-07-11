--~ with Ada.Integer_Text_IO, Ada.Float_Text_IO;
--~ use Ada.Integer_Text_IO, Ada.Float_Text_IO;
  
with arbre_caracters; use arbre_caracters;

package t_frequencies is

type abecedari is private;

-- rang de valors dels índexos de les taules

procedure tbuida (tfreq: out abecedari);
procedure omplir (tfreq: out abecedari; fname: in String; ok: out boolean);
procedure mostra (tfreq: in abecedari);

no_rang : exception;
mal_us :exception;


type iterator is private;

procedure primer(ce: in abecedari; it: out iterator);
procedure succesor(ce: in abecedari; it: in out iterator);
procedure consulta(ce: in abecedari; it: in iterator; k: out Rang_Valors; x: out Float);
function esValid(it: in iterator) return boolean;
 --~ 
pragma inline(primer,succesor,consulta,esValid);


private 

	Maxim : constant Integer := 200;

	-- tipus per recordar quins caracters apareixen
	type T_Caracters is array (Rang_Valors) of Character; 
	
	-- tipus per comptar el nombre d'aparicions de cada caracter
	type T_Frequencies is array (Rang_Valors) of Integer; 


	-- declaració de la 'taula de freqüencies' per treballar
	type abecedari is 
		record 
			Caracters   : T_Caracters;  
			Frequencies : T_Frequencies;  
			Limit       : Integer;    -- nombre d'elements incorporats a les taules. 
                                      -- També indica el lloc on es troba el darrer
                                      -- element incorporat.
		end record; 

	--iterador
	type iterator is
		record
			k: Rang_Valors;
			valid: boolean;
		end record;
   
end t_frequencies;
