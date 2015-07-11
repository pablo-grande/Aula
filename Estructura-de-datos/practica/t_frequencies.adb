with Ada.Text_Io; use Ada.Text_Io;
with Ada.Float_Text_io; use Ada.Float_Text_io;

package body t_frequencies is 

	Origen : File_Type;  -- fitxer d'origen
	Nom_Fitxer_Aparicio  : constant String := "frequencies.txt";
	Lletra : Character;  -- Variable per llegir el contingut del fitxer origen
	
	procedure tbuida (tfreq: out abecedari) is
	begin
		for Index in Rang_Valors'Range loop
			tfreq.Frequencies:=(others=>0);
		end loop;
		tfreq.Limit := 0;
	end tbuida;
   
	procedure omplir (tfreq: out abecedari; fname: in String; ok: out boolean) is separate;
   
	-- Procediment per guardar el resultat de la feina feta
	procedure mostra (tfreq: in abecedari) is separate;
	
	--Iteradors
	procedure primer (ce: in abecedari; it: out iterator) is
		k: Rang_Valors renames it.k;
		e: T_Frequencies renames ce.Frequencies;
	begin
		k:=Rang_Valors'First;
		while not (e(k) > 0) and k<Rang_Valors'Last loop
			k:=Rang_Valors'succ(k);
		end loop;
		it.valid:= (e(k)>0);
	end primer;	
	
	
	procedure succesor(ce:in abecedari; it: in out iterator) is
		k: Rang_Valors renames it.k;
		e: T_Frequencies renames ce.Frequencies;
	begin
		if not it.valid then raise mal_us; end if;
		if k < Rang_Valors'last then
			k:=Rang_Valors'succ(k);
			while not (e(k) > 0) and k<Rang_Valors'Last loop
				k:=Rang_Valors'succ(k);
			end loop;
			it.valid:= (e(k)>0);
		else
			it.valid:=false;
		end if;
	end succesor;
	
	function esValid(it: in iterator) return boolean is
	begin
		return it.valid;
	end esValid;
	
	procedure consulta(ce: in abecedari; it: in iterator; k: out Rang_Valors; x: out Float) is
		c: T_Frequencies renames ce.Frequencies;
		valid: boolean renames it.valid;
		freq: Integer;
	begin
		if not valid then raise mal_us; end if;
		k:= it.k; 
		freq:=c(k);
		x:=float(freq*100)/float(ce.Limit);
	end consulta;
	
end t_frequencies;
