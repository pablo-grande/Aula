separate (t_frequencies)

procedure mostra (tfreq: in abecedari) is
   Fitxer : File_Type;
   pct: Float;
begin
   Create(Fitxer, Out_File, Nom_Fitxer_Aparicio);
   
	for Index in Rang_Valors'Range loop
		if tfreq.Frequencies(Index)/=0 then
			pct:=float(tfreq.Frequencies(Index)*100)/float(tfreq.Limit); -- càlcul del % d'aparacions
			Put(Fitxer, Index'Img & " ->" & tfreq.Frequencies(Index)'Img);
			Put(Fitxer," (");Put(Fitxer,pct,FORE=>1, AFT=>2, EXP=>0);Put_Line(Fitxer,"%)");
		end if;
	end loop;
	
   Close(Fitxer);
   put_line("Taula de freqüències guardada a '" & Nom_Fitxer_Aparicio & "'");
   
end mostra;
