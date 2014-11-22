package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JDialogTest {
	private static JFrame ventanaPrincipal;
	private static JDialog ventanaSecundaria;
	public static void main(String[] args) {
		JButton boton1 = new JButton("Abre secundaria");
		// CONSTRUCCIÓN DE VENTANA PRINCIPAL
		ventanaPrincipal = new JFrame("VENTANA PRINCIPAL");
		ventanaPrincipal.setSize(300,100);
		ventanaPrincipal.getContentPane().setLayout(new FlowLayout());
		ventanaPrincipal.getContentPane().add(boton1);

		JButton boton2 = new JButton("Abre principal");
		// CONSTRUCCIÓN DE VENTANA SECUNDARIA
		ventanaSecundaria = new JDialog(ventanaPrincipal,"VENTANA SECUNDARIA");  // La ventana secundaria requiere del contenedor JFrame
		ventanaSecundaria.getContentPane().setLayout(new FlowLayout());
		ventanaSecundaria.getContentPane().add(boton2);
		ventanaSecundaria.setSize(300,100);

		// HACER QUE EL BOTÓN ABRA LA VENTANA SECUNDARIA
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaSecundaria.setVisible(true);
			}
		});

		// HACER QUE EL BOTÓN ABRA LA VENTANA PRINCIPAL
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal.setVisible(true);
				ventanaSecundaria.setVisible(false);
			}
		});

		// HACER QUE AL CERRARSE LA SECUNDARIA CON LA X DE ARRIBA A LA DERECHA, SE MUESTRE LA PRIMARIA
		ventanaSecundaria.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				ventanaPrincipal.setVisible(true);
				ventanaSecundaria.setVisible(false);
			}
		});
		ventanaPrincipal.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		ventanaPrincipal.setVisible(true);
	}
}