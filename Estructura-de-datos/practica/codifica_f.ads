with t_frequencies; use t_frequencies;
with arbre_caracters; use arbre_caracters, arbre_caracters.a_c;
with Direct_IO,Sequential_IO;


package codifica_f is

	type Entrada is record
		Lletra: Character;
		Codi: string(1..257);
	end record;
	
	package Dir_IO is new Direct_IO(Entrada);use Dir_IO;
	package Seq_IO is new Sequential_IO(character);use Seq_IO;
	
	procedure genera_codis(Taula: in abecedari; a: out arbre; fname: in string);
	procedure codifica(fname_text,fname_codis: in string);	
	procedure postordre(a: in arbre; fname: in String);	
	procedure recorregut(a: in arbre; file: in Dir_IO.File_Type;registre: in out Entrada;d: in integer);

end codifica_f;
