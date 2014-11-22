package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class E_JToolBar {

    static JLabel etiqueta = new JLabel();

    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        ventana.setTitle("EJEMPLO JToolBar");
        ventana.setSize(400, 150);
        ventana.getContentPane().add(etiqueta, BorderLayout.EAST);
        JToolBar toolbar = new JToolBar();
        final JButton boton1 = new JButton(new ImageIcon("asdf.jpg"));
        final JButton boton2 = new JButton(new ImageIcon("asdf2.jpg"));
        final JButton boton3 = new JButton(new ImageIcon("tonicabron.jpg"));
        toolbar.add(boton1);
        toolbar.add(boton2);
        toolbar.addSeparator();
        toolbar.add(boton3);

        boton1.addActionListener(new ActionListener() {
            // AGREGAMOS UN OYENTE DE EVENTO AL BOTON boton1

            public void actionPerformed(ActionEvent ev) {//Tratamiento del evento
                // TRATAMIENTO DEL EVENTO
                if (ev.getSource() == boton1) {
                    etiqueta.setText("SELECCIONADO BOTON 1");
                }
            }
        });

        boton2.addActionListener(new ActionListener() {
            // AGREGAMOS UN OYENTE DE EVENTO AL BOTON boton2

            public void actionPerformed(ActionEvent ev) {
                // TRATAMIENTO DEL EVENTO
                if (ev.getSource() == boton2) {
                    etiqueta.setText("SELECCIONADO BOTON 2");
                }
            }
        });

        boton3.addActionListener(new ActionListener() {
            // AGREGAMOS UN OYENTE DE EVENTO AL BOTON boton3

            public void actionPerformed(ActionEvent ev) {
                // TRATAMIENTO DEL EVENTO
                if (ev.getSource() == boton3) {
                    etiqueta.setText("SELECCIONADO BOTON 3");
                }
            }
        });

        ventana.getContentPane().add(toolbar, BorderLayout.NORTH);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
