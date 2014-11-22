package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JScrollPaneTest2{
	private static JList listaColores, listaCopia;
	private static JButton botonCopiar;
	private static JScrollPane jsp1, jsp2;
	private final static String nombresColores[] = { "Negro", "Azul", "Cyan","Gris oscuro", "Gris", "Verde", "Gris claro", "Magenta", "Naranja","Rosa",
			                       "Rojo", "Blanco", "Amarillo" };
	public static void main(String args[]) {
		JFrame ventana= new JFrame("Listas de selección múltiple");
		ventana.setSize(325,130);
		ventana.getContentPane().setLayout(new FlowLayout());

		// establecer objeto JList listaColores
		listaColores = new JList(nombresColores);
		listaColores.setVisibleRowCount(5); //Mostrados en el JScrollPane
		listaColores.setSelectionMode(
		ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		jsp1= new JScrollPane(listaColores);
		ventana.getContentPane().add(jsp1);

		// crear botón copiar y registrar su componente de escucha
		botonCopiar = new JButton("Copiar >>>");
		ventana.getContentPane().add( botonCopiar );
		botonCopiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) { // colocar valores seleccionados en listaCopia
				listaCopia.setListData(listaColores.getSelectedValues());
			}
		});

		// establecer objeto JList listaCopia
		listaCopia = new JList();
		listaCopia.setVisibleRowCount(5);
		listaCopia.setFixedCellWidth(100);
		listaCopia.setFixedCellHeight(15);
		listaCopia.setSelectionMode(
		ListSelectionModel.SINGLE_INTERVAL_SELECTION );
		jsp2= new JScrollPane(listaCopia);
		ventana.getContentPane().add(jsp2);
		ventana.setVisible( true );
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}