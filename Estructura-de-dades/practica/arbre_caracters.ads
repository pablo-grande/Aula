with arbre_b;
with Ada.Text_IO;

package arbre_caracters is
	
	subtype Rang_Valors is Character Range Character'First..Character'Last;
	package a_c is new arbre_b (item => Rang_Valors, Put_Item => Ada.Text_IO.Put);

end arbre_caracters;
