with arbre_caracters; use arbre_caracters, arbre_caracters.a_c;
with Sequential_IO;

package decodifica_f is
	
	fname_ne: constant string:= "nombre_estats.n";
	Significat_especial: constant Rang_valors:= Rang_valors'First; --null char
	type simbol_t is new integer range 0..1;
	type Transicio is record
		Estat_inicial: integer;
		simbol: simbol_t;
		Estat_final: integer;
		Significat: Rang_valors;
	end record;
	
	transicio_error: exception;
	recorregut_error: exception;

	package Seq_IO is new Sequential_IO(Transicio);use Seq_IO;
	package Int_IO is new Sequential_IO(Integer);use Int_IO;
		
	type automata is			
      record
         Simbol_0: Integer;
         Simbol_1: Integer;
         Caracter: Rang_Valors;
      end record;

	type t_automata is array (Integer range <>) of automata; --el array de automatas contiene la tabla, el índice del array serán los estados inciales
	
	procedure decodifica(f_text,f_recurs: in string);
	procedure genera_transicions(a: in arbre;fname: in string);	
	procedure recorregut(a: in arbre; file: in Seq_IO.File_Type; Estat: in out integer);
	procedure genera_transicio(file: in Seq_IO.File_Type; Estat_inicial: in integer; simbol: in simbol_t;Estat_final: in integer;significat: in Rang_valors);
    function NFA (file: in Seq_IO.File_Type;estats: in integer) return t_automata;
    procedure mostra_automata(a: in t_automata);
    
    private 
    
    function nombre_estats return integer;

end decodifica_f;
