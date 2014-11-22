package GUI;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
public class FlowLayoutTest2 {
	public static void main(String[] args){
		JFrame ventana= new JFrame();
		 ventana.setTitle("FlowLayoutTest2");
		 ventana.setSize(500,150);
		 ventana.setLayout(new FlowLayout(FlowLayout.RIGHT,20,80));
		JButton boton1 = new JButton("BOTON 1");
		JButton boton2 = new JButton("BOTON 2");
		JButton boton3 = new JButton("BOTON 3");
		 ventana.add(boton1);
		 ventana.add(boton2);
		 ventana.add(boton3);
		 ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 ventana.setVisible(true);
	}
}