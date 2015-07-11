separate (t_frequencies)

procedure omplir (tfreq: out abecedari; fname: in String; ok: out boolean) is
begin
	--Control de excepciones
	begin 
		-- Obrir el fitxer origen per llegir
		Open(Origen, In_File, fname);
	exception 
		when Name_Error => ok := False; 
	end; 
	

	-- Recorregut fins al final del fitxer.
	-- End_Of_File ens indica si hi ha o no qualque cosa per llegir.
	while not End_Of_File(Origen) loop

			Get(Origen, Lletra);			
			if Lletra'Valid then
				tfreq.Frequencies(Lletra):=tfreq.Frequencies(Lletra) + 1;
				tfreq.Limit:= tfreq.Limit + 1;
			else
				raise no_rang;
			end if;

	end loop;
	
	-- Tancar el fitxer
	Close (Origen);
	-- Fer saber que s'ha acabat
	Put_Line("Taula de freqüències generada.");
   
end omplir;
