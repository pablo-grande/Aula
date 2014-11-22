package GUI;

import java.awt.*;
import javax.swing.*;
public class BorderLayoutTest {
	public static void main(String[] args){
		JFrame ventana= new JFrame();
		ventana.setTitle("BorderLayoutTest");
		ventana.setLayout(new BorderLayout());
		JButton boton1 = new JButton("BOTON NORTE");
		ventana.add(boton1,BorderLayout.NORTH);
		JButton boton2 = new JButton("BOTON OESTE");
		ventana.add(boton2,BorderLayout.WEST);
		JButton boton3 = new JButton("BOTON CENTRAL");
		ventana.add(boton3,BorderLayout.CENTER);
		JButton boton4 = new JButton("BOTON ESTE");
		ventana.add(boton4,BorderLayout.EAST);
		JButton boton5 = new JButton("BOTON SUR");
		ventana.add(boton5,BorderLayout.SOUTH);
		ventana.pack();
		/* El método pack, hace que el contenedor pregunte a su LayoutManager el
		tamaño mínimo para que todos sus componentes se puedan ver y se ajusten
		a ese tamaño. */
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}
}